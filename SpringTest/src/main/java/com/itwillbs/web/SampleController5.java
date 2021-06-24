package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.ProductVO;

@Controller
public class SampleController5 {

	private static final Logger logger = 
			LoggerFactory.getLogger(SampleController5.class); 
	
	@RequestMapping("/doPro")
	public ProductVO doPRo() {
		logger.info("doPro() 호출"); 
		ProductVO vo = new ProductVO("휴대폰" , 200) ; 
		
		
		return vo; 
	}
	
}
