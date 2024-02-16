package kr.co.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.MemberDTO;
import kr.co.service.BuyService;
import kr.co.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/member.*")
public class MemberController {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	BuyService bService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister() throws Exception{ logger.info("get register");}
	
	@RequestMapping(value = "/register", method =  RequestMethod.POST)
	public String postRegister(MemberDTO dto)throws Exception{
		logger.info("post register");
		int result = service.idChk(dto);
		try {
			if(result==1) {
				return "/member/register";
			}else if(result == 0) {
				service.register(dto);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return "redirect:/";
	}
	
	@GetMapping("login")
	public String loginPage() {
		return "./member/login";
	}
	
	@RequestMapping(value = "/login" , method =  RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/memberUpdate", method = RequestMethod.POST )
	public String registerUpdate(MemberDTO dto,HttpSession session) throws Exception{
		service.memberUpdate(dto);
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/member-delete-view", method = RequestMethod.GET)
	public String memberDeleteView() throws Exception{
		return "member/memberDeleteView";
	}
	
	@RequestMapping(value="/memberDelete", method = RequestMethod.POST )
	public String memberDelete(MemberDTO dto,HttpSession session,RedirectAttributes rttr) throws Exception{
		MemberDTO member= (MemberDTO) session.getAttribute("member");
		String sessionPass = member.getM_pw();
		String voPass = dto.getM_pw();
		
		if(!(sessionPass.equals(voPass))) {
			rttr.addFlashAttribute("msg",false);
			return  "redirect:/member/member-delete-view";
		}
		service.memberDelete(dto);
		session.invalidate();
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value = "/passChk",method= RequestMethod.POST)
	public int passChk(MemberDTO dto) throws Exception{
		int result = service.passChk(dto);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/idChk",method= RequestMethod.POST)
	public int idChk(MemberDTO dto) throws Exception{
		int result = service.idChk(dto);
		return result;
	}
	
	@GetMapping("/profile-details")
	public String profileDetails(@RequestParam("m_id") String m_id,
			Model model) throws Exception{
		log.info("profile detail page...");
		model.addAttribute("my",service.getId(m_id));
		return "./member/profile-details";
	}
}
