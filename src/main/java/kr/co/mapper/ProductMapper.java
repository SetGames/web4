package kr.co.mapper;

import java.util.List;

import kr.co.domain.ProductDTO;
import kr.co.domain.UploadDTO;

public interface ProductMapper {
	public abstract ProductDTO read(Long p_no);
	public abstract List<ProductDTO> getList();
	public abstract void insert(ProductDTO product);
	public abstract void insertSelectKey(ProductDTO product);
	public abstract int delete(Long p_no);
	public abstract int update(ProductDTO product);
	public abstract void imageEnroll(UploadDTO upload);
	public abstract void deleteImageAll(Long i_pno);
	public abstract List<ProductDTO> readCountDescList();
}
