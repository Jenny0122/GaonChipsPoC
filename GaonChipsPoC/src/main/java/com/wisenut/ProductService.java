package com.wisenut;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	/**
	 * Execute Search By Category
	 *
	 * @author 안선정
	 * @param query 검색어
	 * @throws Exception
	 */
	public ResponseEntity<List<FileSearchVo>> searchTotalList(String query) throws Exception {

		log.info("query: {}", query);

		List<FileSearchVo> list = new ArrayList<>();
		// 검색기 server 설정
		String server_ip = "128.134.179.83";
		int server_port = 7000;
		int server_timeout = 10 * 1000;

		String Query = query;

		// collection, 검색필드, 출력필드 정의
		String COLLECTION = "file";
		int QUERY_LOG = 1;
		int EXTEND_OR = 0;
		int PAGE_START = 0; // 검색 결과를 받아오는 시작 위치
		int RESULT_COUNT = 10; // 한번에 출력되는 검색 건수
		String SORT_FIELD = "RANK/DESC"; // 정렬필드
		String SEARCH_FIELD = "FILE_NAME"; // 검색필드
		String DOCUMENT_FIELD = "DOCID,FILE_NAME,FILE_CONTENT,EXTENSION,FILE_SIZE,FILE_PATH,SFTP_FILE_PATH,DATE,ALIAS"; // 출력필드

		// create object
		QueryAPI530.Search search = new QueryAPI530.Search();
		int ret = 0;

		// common query 설정
		ret = search.w3SetCodePage("UTF-8");
		ret = search.w3SetQueryLog(QUERY_LOG);
		ret = search.w3SetCommonQuery(Query, 1);

		// collection, 검색 필드, 출력 필드 설정
		ret = search.w3AddCollection(COLLECTION);
		ret = search.w3SetPageInfo(COLLECTION, PAGE_START, RESULT_COUNT);
		ret = search.w3SetSortField(COLLECTION, SORT_FIELD);
		ret = search.w3SetSearchField(COLLECTION, SEARCH_FIELD);
		ret = search.w3SetDocumentField(COLLECTION, DOCUMENT_FIELD);

		// filter query
//		StringBuilder builder = new StringBuilder();

//		builder.append("<PR_SORT:match:"+prSort+">").toString();
//		builder.append("<PR_GRP_GB:match:"+prGRP+">").toString();
//		builder.append("<PR_PRODUCT_GB:in:"+prProduct+" >").toString();
//		builder.append("<PR_PRODUCT_GB:not_in:"+prProduct+" >").toString();

//		builder.append("<PR_SORT:match:"+prSort+">");
//		builder.append("<PR_GRP_GB:match:"+prGRP+">");	
//		
//		boolean in = contain.equals("in") ? true : false;
//		if(in) {
//			builder.append("<PR_PRODUCT_GB:in:"+prProduct+" >");	
//		}else{
//			builder.append("<PR_PRODUCT_GB:not_in:"+prProduct+" >");
//		}
//		
//		ret = search.w3SetFilterQuery(COLLECTION, builder.toString());

		// 오타교정을 수행할 최소 검색 결과 건수 설정
		ret = search.w3SetSpellCorrectionQuery(query, 0);

		// request
		ret = search.w3ConnectServer(server_ip, server_port, server_timeout);
		log.info(String.valueOf(ret));
		ret = search.w3ReceiveSearchQueryResult(3);
		log.info(String.valueOf(ret));

		// check error
//		if (search.w3GetError() != 0) {
//			log.error("검색 오류 로그 : {}", search.w3GetErrorInfo());
//			throw new Exception(search.w3GetErrorInfo());
//		}

		// 전체건수, 결과건수 출력
		int totalCount = search.w3GetResultTotalCount(COLLECTION);
		int resultCount = search.w3GetResultCount(COLLECTION);

		// 오타가 교정된 단어를 반환
		String suggestQuery = search.w3GetSuggestedQuery();

		log.info("검색 결과 : " + resultCount + "건 / 전체 건수 : " + totalCount + "건");

		for (int i = 0; i < resultCount; i++) {

			// 기본 검색결과 객체 생성
			String file_name = search.w3GetField(COLLECTION, "FILE_NAME", i);
			String file_extension = search.w3GetField(COLLECTION, "EXTENSION", i);
			String file_path = search.w3GetField(COLLECTION, "FILE_PATH", i);
			String sftp_file_path = search.w3GetField(COLLECTION, "SFTP_FILE_PATH", i);
			String date = search.w3GetField(COLLECTION, "DATE", i);

			FileSearchVo vo = FileSearchVo.builder()
					.file_name(file_name)
					.file_extension(file_extension)
					.file_path(file_path)
					.sftp_file_path(sftp_file_path)
					.date(date)
					.build();

			list.add(vo);
		}

		if (resultCount < 0) {
			final int SAMPLE_SIZE = 1000;
			for (int i = 0; i < SAMPLE_SIZE; i++) {

				list.add(FileSearchVo.builder()
						.file_name("file_name" + i)
						.file_extension("file_extension" + i)
						.file_path("file_path" + i)
						.sftp_file_path("sftp_file_path" + i)
						.date("date" + i)
						.build());
			}
		}

		System.out.println(list);

		return ResponseEntity.ok(list);

	}
}
