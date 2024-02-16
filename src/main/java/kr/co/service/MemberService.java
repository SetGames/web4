package kr.co.service;

import java.util.List;

import kr.co.domain.MemberDTO;

public interface MemberService {
	public abstract void register(MemberDTO dto)throws Exception;
	public abstract MemberDTO get(Long m_no);
	public abstract MemberDTO login(MemberDTO dto) throws Exception;
	public abstract void memberUpdate(MemberDTO dto) throws Exception;
	public abstract void memberDelete(MemberDTO dto) throws Exception;
	public abstract int passChk(MemberDTO dto) throws Exception;
	public abstract int idChk(MemberDTO dto) throws Exception;
	public abstract List<MemberDTO> getList() throws Exception;
	public abstract MemberDTO getId(String m_id) throws Exception;
	public abstract void pointUpdate(MemberDTO dto) throws Exception;
	
}
