package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.ProductDTO;
import kr.co.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	@Setter(onMethod_ = @Autowired)
	private ProductMapper mapper;
	
	
	@Transactional
	@Override
	public void register(ProductDTO product) {
		log.info("register..."+product);
		if(product.getImageList()==null||product.getImageList().size() <= 0) {
			return;
		}
		
		product.getImageList().forEach(file ->{
			file.setI_pno(product.getP_no());
			mapper.imageEnroll(file);
		});

	}

	@Override
	public ProductDTO get(Long p_no) {
		log.info("get..."+p_no);
		return mapper.read(p_no);
	}

	@Override
	public boolean modify(ProductDTO product) {
		log.info("modify..."+product);
		int result = mapper.update(product);
		if(result == 1 && product.getImageList()!= null &&
				product.getImageList().size() > 0) {
			mapper.deleteImageAll(product.getP_no());
			
			product.getImageList().forEach(file ->{
				file.setI_pno(product.getP_no());
				mapper.imageEnroll(file);
			});
		}
		return true;
	}

	@Override
	public boolean remove(Long p_no) {
		log.info("remove..."+p_no);
		return mapper.delete(p_no) == 1 ;
	}

	@Override
	public List<ProductDTO> getList() {
		log.info("getList...");
		return mapper.getList();
	}

	@Override
	public List<ProductDTO> descList() {
		log.info("readCount desList...");
		return mapper.readCountDescList();
	}

}
