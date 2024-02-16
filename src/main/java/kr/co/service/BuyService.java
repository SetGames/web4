package kr.co.service;

import java.util.List;

import kr.co.domain.BuyDTO;

public interface BuyService {
	public abstract List<BuyDTO> orderList(Long m_no);
	public abstract void approve(BuyDTO buy);
}
