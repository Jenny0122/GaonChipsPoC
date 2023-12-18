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

	private String code;

	private String name;

	private String unit;

	private String initiateddate;
	
	private String prSort;
	
	private String prGRP;
	
	private String prProduct;
}
