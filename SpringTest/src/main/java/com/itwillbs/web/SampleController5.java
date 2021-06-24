package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController5 {

	private static final Logger logger = 
			LoggerFactory.getLogger(SampleController5.class); 
	
	@RequestMapping("/doPro")
	public ProductVO doPro() {
		logger.info("doPro() 호출"); 
		ProductVO vo = new ProductVO("휴대폰" , 200) ; 
		
		
		return vo; 
	}
	// JSON 타입 데이터 활용 
	
	@RequestMapping("/doPro2")
	public @ResponseBody ProductVO doPro2() {
		logger.info("doPro() 호출"); 
		ProductVO vo = new ProductVO("휴대폰" , 200) ; 
		
		return vo; 
	}
	//https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.8.4
	// pom.xml에 dependency 적용
	// @ResponseBody 를 함수헤더에 적용 
	// http://localhost:8088/web/doPro2 으로 확인해보면 json데이터로 주고 있는 것을 확인가능
	
	// 쉽게 json 데이터를 생성할 수 있는 방식. 
	
}
