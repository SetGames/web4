package kr.co.service;

import java.util.List;

import kr.co.domain.UploadDTO;

public interface FileService {
	public abstract List<UploadDTO> getImageList(Long i_pno);
	public abstract List<UploadDTO> getImageList1();
}
