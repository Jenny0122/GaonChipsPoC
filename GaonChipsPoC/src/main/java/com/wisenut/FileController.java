package com.wisenut;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriUtils;

import lombok.extern.slf4j.Slf4j;

//@CrossOrigin(origins = "*")
@RequestMapping("${base.url}")
@RestController
@Slf4j
public class FileController {

	@Autowired
	private FileService service;

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return ResponseEntity.ok("ab");
	}

	final String SEARCH_API = "/search";

	@GetMapping(SEARCH_API)
	public ResponseEntity<List<FileSearchVo>> search(HttpServletRequest request,
			@RequestParam(name = "query") String query) {
		final String ip = request.getRemoteAddr();

		log.info("\n ip: {}\n api: {}\n query: {}", ip, SEARCH_API, query);
		try {
			return service.searchTotalList(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest()
					.body(new ArrayList<>());
		}

	}
	
	@Value("${base.download.path}")
	String location;

	@GetMapping("/download")
	public ResponseEntity<Resource> download(@RequestParam String name) throws MalformedURLException, UnsupportedEncodingException {
		
		final String path = location + URLDecoder.decode(name, "UTF-8");
		log.info("file_path: {}", path);
		Resource resource = new UrlResource(Paths.get(path)
				.toUri());
		log.info("file is exist? : {}", resource.exists());

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=\"" + UriUtils.encode(name, "UTF-8") + "\"")
				.body(resource);
	}

//	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
//	@Operation(summary = "상품 검색", description = "입력받은 검색어로 상품정보 조회")
//	public ResponseEntity<ProductDTO> retriveSearchList(
//			@Parameter(description = "검색어") @RequestParam(name = "query") String query) {
//
//		List<ProductVo> result = service.searchTotalListByCategory(query);
//
//		ProductDTO dto = ProductDTO.builder().data(result).build();
//
//		return ResponseEntity.ok(dto);
//	}
//
//	@RequestMapping(value = "/ark/api", method = RequestMethod.GET, produces = "application/json")
//	@Operation(summary = "자동완성", description = "입력받은 검색어와 정렬정보로 자동완성")
//	public ResponseEntity<Object> retriveARKord(@RequestParam(name = "target") String target,
//			@RequestParam(name = "query") String query, @RequestParam(name = "convert") String convert) {
//		RestTemplate restTemplate = new RestTemplate();
//
//		String protocol = "http";
//		String host = "localhost";
//		int port = 446;
//
//		String api = "/ark/api";
//		URI uri = UriComponentsBuilder.newInstance().scheme(protocol).host(host).port(port).path(api)
//				.queryParam("target", target).queryParam("query", query).queryParam("convert", convert).encode().build().toUri();
//
//		System.out.println(uri);
//		ResponseEntity<Map> response = restTemplate.getForEntity(uri, Map.class);
//		return new ResponseEntity<Object>(response.getBody(), response.getStatusCode());
//	}
//	
//	@RequestMapping(value = "/popular/api", method = RequestMethod.GET, produces = "application/json")
//	@Operation(summary = "인기검색어", description = "입력받은 dateType으로 인기검색어 조회")
//	public ResponseEntity<Object> retrivePopWord(@RequestParam(name = "dateType") String dateType) {
//		RestTemplate restTemplate = new RestTemplate();
//		String protocol = "http";
//		String host = "localhost";
//		int port = 446;
//		String api = "/popular/api";
//		URI uri = UriComponentsBuilder.newInstance().scheme(protocol).host(host).port(port).path(api)
//				.queryParam("label", "common").queryParam("dateType", dateType).build().toUri();
//
//		ResponseEntity<Map> response = restTemplate.getForEntity(uri, Map.class);
//
//		if (response.getStatusCode() == HttpStatus.OK) {
//			return ResponseEntity.ok(response.getBody());
//		} else {
//			return ResponseEntity.badRequest().build();
//		}
//	}
//	
//	@RequestMapping(value = "/recommend/api", method = RequestMethod.GET, produces = "application/json")
//	@Operation(summary = "추천검색어", description = "입력받은 검색어와 라벨 정보로 추천검색어 조회")
//	public ResponseEntity<Object> retriveRecommendord(@RequestParam(name = "label") String label,
//			@RequestParam(name = "searchWord") String searchWord) {
//		RestTemplate restTemplate = new RestTemplate();
//
//		String protocol = "http";
//		String host = "localhost";
//		int port = 446;
//
//		String api = "/recommend/api";
//		URI uri = UriComponentsBuilder.newInstance().scheme(protocol).host(host).port(port).path(api)
//				.queryParam("label", label).queryParam("searchWord", searchWord).encode().build().toUri();
//
//		System.out.println(uri);
//		ResponseEntity<Map> response = restTemplate.getForEntity(uri, Map.class);
//		return new ResponseEntity<Object>(response.getBody(), response.getStatusCode());
//	}
}
