package com.wisenut;

import java.util.ArrayList;
import java.util.List;

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
	 * @Param prSort
	 * @Param prGRP
	 * @param prProduct
	 * @param contain
	 */
//	public List<ProductVo> searchTotalListByCategory(String query, int from, int count) {

	public List<ProductVo> searchTotalList(String query) {

		log.info("query : {}", query);

		List<ProductVo> list = new ArrayList<>();
		// 검색기 server 설정
		String server_ip = "127.0.0.1";
		int server_port = 7000;
		int server_timeout = 10 * 1000;

		String Query = query.replaceAll(" ", "");

		// collection, 검색필드, 출력필드 정의
		String COLLECTION = "product";
		int QUERY_LOG = 1;
		int PAGE_START = 0;
		int RESULT_COUNT = 10; // 한번에 출력되는 검색 건수
		String SORT_FIELD = "SCORE/DESC"; // 정렬필드
		String SEARCH_FIELD = "PR_CODE,PR_NAME,PR_SORT,PR_GRP_GB,PR_PRODUCT_GB,PR_SPRCODE"; // 검색필드
		String DOCUMENT_FIELD = "DOCID,PR_CODE,PR_NAME,PR_UNIT,PR_INITIATEDDATE,PR_SORT,PR_GRP_GB,PR_PRODUCT_GB"; // 출력필드

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
		ret = search.w3ReceiveSearchQueryResult(3);

		// check error
		if (search.w3GetError() != 0) {
			log.debug("검색 오류 로그 : {}", search.w3GetErrorInfo());
			return null;
		}

		// 전체건수, 결과건수 출력
		int totalCount = search.w3GetResultTotalCount(COLLECTION);
		int resultCount = search.w3GetResultCount(COLLECTION);

		// 오타가 교정된 단어를 반환
		String suggestQuery = search.w3GetSuggestedQuery();

		System.out.println("검색 결과 : " + resultCount + "건 / 전체 건수 : " + totalCount + "건");

		for (int i = 0; i < resultCount; i++) {

			// 기본 검색결과 객체 생성
			String code = search.w3GetField(COLLECTION, "PR_CODE", i);
			String name = search.w3GetField(COLLECTION, "PR_NAME", i);
			String unit = search.w3GetField(COLLECTION, "PR_UNIT", i);
			String initiateddate = search.w3GetField(COLLECTION, "PR_INITIATEDDATE", i);
			String prSort = search.w3GetField(COLLECTION, "PR_SORT", i);
			String prGRP = search.w3GetField(COLLECTION, "PR_GRP_GB", i);
			String prProduct = search.w3GetField(COLLECTION, "PR_PRODUCT_GB", i);

			ProductVo vo = ProductVo.builder()
					.code(code)
					.name(name)
					.unit(unit)
					.initiateddate(initiateddate)
					.prSort(prSort)
					.prGRP(prGRP)
					.prProduct(prProduct)
					.build();

			list.add(vo);
		}

		return list;

	}
}
