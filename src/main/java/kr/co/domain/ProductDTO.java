package kr.co.domain;

import java.util.List;

import lombok.Data;

@Data
public class ProductDTO {
	private Long p_no;
	private String p_name;
	private String p_price;
	private String p_image;
	private List<UploadDTO> imageList;
	private String p_creator;
	private String p_regdate;
	private String p_etc;
	private int p_readcount;
}
