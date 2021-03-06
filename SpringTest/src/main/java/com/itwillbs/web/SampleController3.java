package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController3 {

	private static final Logger logger 
	= LoggerFactory.getLogger(SampleController3.class); 
	
	// view 페이지로 객체 정보를 전달
	@RequestMapping("/doC")
	public String doC(Model model) {
		// Model 객체 : 스프링 MVC에서 기본 제공 클래스.
		// View에 데이터를 전달하는 컨테이너 역할 클래스 

		//request.setAttribute() 하던 것이 이런 식으로 바뀌었다고 알아두면 좋다.
		//model.addAttribute("test", "12345");
		//model.addAttribute("key" , value); 
		ProductVO vo = new ProductVO("Computer", 100.0);
		model.addAttribute("pvo", vo); 
		
		// 키 값 없이 객체만 넘기는 경우 
		// model.addAttribute(value); 
		// => key 값이 없기 때문에 전달되는 타입의 클래스명
		// 첫글자만 소문자로 변경해서 key 값으로 사용 가능
		model.addAttribute(vo);  
		
		logger.info("doC() 메서드 호출"); 
		logger.info("productDetail.jsp 페이지로 이동"); 
		return "productDetail" ; 
	}
	
}
