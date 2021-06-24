package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	@RequestMapping("/doB")
	public String doB() {
		logger.info("doB() 메서드 호출 ");
		return "doA2"; 
	}
	
	@RequestMapping("/doB1")
	public String doB1() {
		logger.info("doB1() 메서드 호출 ");
		logger.info("String 타입 리턴 -> 리턴 결과.jsp 페이지 호출!"); 
		
		return "doB"; 
	}
	// String 타입으로 리턴하는 동작
	// 주소와 다른 이름의 페이지를 보여줘야 하는 경우 String으로 리턴 

//	@RequestMapping("/doB2")
//	public String doB2() {
//		logger.info("doB2() 메서드 호출 ");
//		logger.info("String 타입 리턴 -> 리턴 결과.jsp 페이지 호출!"); 
//		
//		//return "doB"; 
//		return "redirect:doB1"; 
//	}
	
	// http://localhost:8088/web/doB2?msg=1000&txt=1234
	@RequestMapping(value="/doB2" )
	public String doB3(@ModelAttribute("msg") String msg ,
						@ModelAttribute("txt") int txt ) {
		
		//msg = "test"; (이렇게는 사용 불가)
		
		logger.info("doB2() 메서드 호출"); 
		logger.info("result.jsp 페이지로 이동"); 
		logger.info("msg 정보 : " + msg);
		logger.info("txt 정보 : " + txt); 
		
		// Spring에서는 자동으로 형변환을 시도한다.
		return "result"; 
	}

	
}
