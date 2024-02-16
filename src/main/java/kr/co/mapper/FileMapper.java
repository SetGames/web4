package kr.co.mapper;

import java.util.List;

import kr.co.domain.UploadDTO;

public interface FileMapper {
	public abstract List<UploadDTO> getImageList(Long i_pno);
	public abstract List<UploadDTO> getImageList1();
}
