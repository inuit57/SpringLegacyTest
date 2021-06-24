package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {

	private static final Logger logger 
	= LoggerFactory.getLogger(SampleController4.class);
	
	// 페이지 이동 
	//http://localhost:8088/web/doD?msg=testData
	@RequestMapping("/doD")
	//public String doD(@ModelAttribute("msg") String msg) {
	public String doD(RedirectAttributes rttr) {
		logger.info("doD() 호출"); 
		//주소줄에 데이터를 저장해서 보내주는 경우  
		//redirect로 보내는 경우 이어서 보내주는 식으로 동작하게 된다.
		
		//Model 객체와 유사한 객체
		//단, redirect에서만 사용된다는 차이가 존재한다.
		rttr.addFlashAttribute("msg","1회성 데이터 전달하기"); 
		// 이렇게 할 경우 데이터 없이 호출해도 된다.
		// 주소줄에 메시지 정보는 출력되지 않고, 1번만 날아가고 그 다음부터는 안 날아간다.
		// 인증 작업을 진행할 때, 본문에서 새로고침하더라도 조회수가 증가하지 않도록 만들기 
		// http://localhost:8088/web/doD
		
		return "redirect:/doE" ;

		// RedirectAttributes 객체 : redirect 페이지 이동시 사용가능한 객체
		// 페이지 간에 데이터 전달 가능(Model 기능과 유사) 
		
		// rtt.addAttribute() : URI에 노출됨.새로고침하더라도 데이터 유지
		
		// rttr.addFlashAttribute() : URI에 노출되지 않음.새로고침할 경우 데이터 소멸(1회성) 
		
		
		//return "forward:/doE" ; 
		// forwarding 방식은 이런 식으로 가능.
		// 주소는 바뀌지 않고 내용물만 바뀌게.
		
		// return "/doE" ; // doE.jsp 뷰페이지 연결 
	}
	
	@RequestMapping("/doE")
	public void doE(@ModelAttribute("msg") String msg) {
		logger.info("doE() 호출"); 
		logger.info("msg : " + msg);
	}
	
}
