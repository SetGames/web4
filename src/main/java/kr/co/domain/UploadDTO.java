package kr.co.domain;

import lombok.Data;

@Data
public class UploadDTO {
	private Long i_no;
	private Long i_pno;
	private String i_name;
	private String i_uploadpath;
}
