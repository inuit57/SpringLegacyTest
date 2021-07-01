package com.itwillbs.web;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger
	= LoggerFactory.getLogger(MemberController.class); 
	
	@Inject
	private MemberService mService; 
	
	// 입력 : Get / 데이터 처리 : Post
	
	// 회원 가입 동작 
	// 1) 회원 정보 입력폼 ( get )
	//@RequestMapping("/insert")
	
	// 2) 전달된 정보를 받아서 처리 (post) 
	
	// 이 메서드는 GET방식만 지원하겠다. -> POST로 들어오면 405 에러가 뜬다.
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public void insertMemberGET() throws Exception{
		logger.info("insertMemberGET() 호출");
		
		logger.info("주소에 해당하는 view 페이지 연결"); 
		logger.info("/views/member/insert.jsp 이동 ");
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insertMemberPOST(MemberVO vo) throws Exception{
		logger.info("insertMemberPOST() 호출"); 
		// 전달된 정보를 저장 
		
		// 컬럼명-변수명-파라미터명을 모두 맞춰주면 정보를 알아서 받아온다.
		logger.info("vo : " + vo);
		// 만약 다르다면 @ModelAttribute를 사용하면 된다. 
		
		mService.insertMember(vo); 
		logger.info("회원 가입 성공!");
		
		// 페이지 이동 (login 페이지로 리다이렉트) 
		return "redirect:/member/login"; 
	}

	// 이렇게 하면 둘 다 받아서 처리도 가능
	//@RequestMapping(value="/insert", method = {RequestMethod.GET , RequestMethod.POST})
	
	
	//로그인 페이지
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginGET() throws Exception{
		logger.info("C: 로그인 페이지 호출"); 
		
		return "" ; 
	}
}
