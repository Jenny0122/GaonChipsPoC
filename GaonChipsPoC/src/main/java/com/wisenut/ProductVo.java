package com.wisenut;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductVo {

	// 상품 코드
	private String code;

	// 상품 이름
	private String name;

	// 상품 단위
	private String unit;

	// 삼품 등록날짜
	private String initiateddate;
	
	// 삼품 정보
	private String prSort;
	
	// 그룹사 정보
	private String prGRP;
	
	//카테고리 정보
	private String prProduct;
}
