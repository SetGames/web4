package kr.co.mapper;

import java.util.List;

import kr.co.domain.MemberDTO;

public interface MemberMapper {
	public abstract void register(MemberDTO dto) throws Exception;
	public abstract MemberDTO read(Long m_no) throws Exception;
	public abstract MemberDTO login(MemberDTO dto) throws Exception;
	public abstract void memberUpdate(MemberDTO dto) throws Exception;
	public abstract void memberDelete(MemberDTO dto) throws Exception;
	public abstract int passChk(MemberDTO dto) throws Exception;
	public abstract int idChk(MemberDTO dto) throws Exception;
	
	public abstract List<MemberDTO> getList();
	public abstract MemberDTO readId(String m_id) throws Exception;
	public abstract void pointUpdate(MemberDTO dto) throws Exception;
}
