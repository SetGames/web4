package kr.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.domain.ProductDTO;
import kr.co.service.FileService;
import kr.co.service.MemberService;
import kr.co.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/shop/*")
public class ShopController {
	private ProductService pService;
	private FileService fService;
	private MemberService mService;
	
	@GetMapping({"","/index"})
	public String index(Model model) {
		log.info("Shop main");
		model.addAttribute("plist",pService.getList());
		model.addAttribute("flist",fService.getImageList1());
		return "./shop/index";
	}
	
	@GetMapping("/newpage")
	public String newPage(Model model) {
		log.info("Shop newPage");
		model.addAttribute("list",pService.getList());
		model.addAttribute("flist",fService.getImageList1());
		return "./shop/newpage";
	}
	
	@GetMapping("/poppage")
	public String detailPage(@RequestParam("p_no") Long p_no,Model model ) {
		log.info("shop getlist");
		ProductDTO product = pService.get(p_no);
		int cnt = product.getP_readcount()+1;
		product.setP_readcount(cnt);
		if(pService.modify(product)) {
			log.info("product read count add success");
			model.addAttribute("product",pService.get(p_no));
			model.addAttribute("flist", fService.getImageList(p_no));
			return "./shop/detailPage";
		}else {
			log.info("Product read cound add fail");
			return "./shop/";
		}
	}
}
