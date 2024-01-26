package com.wisenut;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 통합 검색 필드 정보
 * 
 * @author 안선정
 * 
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Builder
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@Schema(description = "통합 검색 필드 정보")
public class FileSearchVo {

//	@Schema(description = "파일 이름")
	private String file_name;
	
//	@Schema(description = "파일 이름")
	private String file_content;

//	@Schema(description = "파일 확장자")
	private String file_extension;
	
//	@Schema(description = "파일 크기")
	private String file_size;

//	@Schema(description = "파일 전체 위치")
	private String file_path;
	
//	@Schema(description = "파일 상위 디렉토리")
	private String sftp_file_path;

//	@Schema(description = "날짜")
	private String date;	

}

