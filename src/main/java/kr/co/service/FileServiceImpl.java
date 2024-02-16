package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.domain.UploadDTO;
import kr.co.mapper.FileMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService {
	@Setter(onMethod_ = @Autowired)
	private FileMapper fileMapper;

	@Override
	public List<UploadDTO> getImageList(Long i_pno) {
		log.info("i_pno into getIamgeList:"+i_pno);
		return fileMapper.getImageList(i_pno);
	}

	@Override
	public List<UploadDTO> getImageList1() {
		log.info("getImageList.....");
		return fileMapper.getImageList1();
	}

}
