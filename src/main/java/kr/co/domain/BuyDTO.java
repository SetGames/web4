package kr.co.domain;

import lombok.Data;

@Data
public class BuyDTO {
	private Long b_no;
	private Long m_no;
	private Long p_no;
	private String p_name;
	private String p_price;
	private String p_image;
	private String b_regdate;
}
