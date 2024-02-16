package kr.co.domain;

import lombok.Data;

@Data
public class MemberDTO {
	private Long m_no;
	private String m_id;
	private String m_pw;
	private String m_pw2;
	private String m_name;
	private String m_email;
	private String m_point;
	private String m_access;
}
