package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.domain.BuyDTO;
import kr.co.mapper.BuyMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BuyServiceImpl implements BuyService {

	@Setter(onMethod_ = @Autowired)
	private BuyMapper mapper;
	
	@Override
	public List<BuyDTO> orderList(Long m_no) {
		log.info("orderList....");
		return mapper.orderList(m_no);
	}

	@Override
	public void approve(BuyDTO buy) {
		log.info("approve...");
		mapper.intsertSelectKey(buy);
	}

}
