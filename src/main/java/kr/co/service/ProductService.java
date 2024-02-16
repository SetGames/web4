package kr.co.service;

import java.util.List;

import kr.co.domain.ProductDTO;

public interface ProductService {
	public abstract void register(ProductDTO product);
	public abstract ProductDTO get(Long p_no);
	public abstract boolean modify(ProductDTO product);
	public abstract boolean remove(Long p_no);
	public abstract List<ProductDTO> getList();
	public abstract List<ProductDTO> descList();
}
