package kr.co.mapper;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import kr.co.domain.MemberDTO;

public class MemberDAOImpl implements MemberMapper {

	@Inject SqlSession sql;
	
	@Override
	public void register(MemberDTO dto) throws Exception {
		sql.insert("MemberMapper.register", dto);

	}

	@Override
	public MemberDTO read(Long m_no) throws Exception {
		sql.selectOne("MemberMapper.get",m_no);
		return null;
	}

	@Override
	public MemberDTO login(MemberDTO dto) throws Exception {
		
		return sql.selectOne("MemberMapper.login",dto);
	}

	@Override
	public void memberUpdate(MemberDTO dto) throws Exception {
		sql.update("MemberMapper.memberUpdate",dto);

	}

	@Override
	public void memberDelete(MemberDTO dto) throws Exception {
		sql.delete("MemberMapper.memberDelete",dto);
	}

	@Override
	public int passChk(MemberDTO dto) throws Exception {
		int result = sql.selectOne("MemberMapper.passChk",dto);
		return result;
	}

	@Override
	public int idChk(MemberDTO dto) throws Exception {
		int result = sql.selectOne("MemberMapper.idChk",dto);
		return result;
	}

	@Override
	public List<MemberDTO> getList() {
		return null;
	}

	@Override
	public MemberDTO readId(String m_id) throws Exception {
		return null;
	}

	@Override
	public void pointUpdate(MemberDTO dto) throws Exception {
		sql.update("MemberMapper.pointUpdate",dto);

	}

}
