package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
		return "doB"; 
	}
}
