package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	//private static final Logger logger = LoggerFactory.getLogger(현재클래스명.class);
	
	//컨트롤에서의 동작은 메서드로 구현 
	@RequestMapping("doA")
	public void doA() {
		logger.info("출력하기!!!!!!!!!!!!!!!!!!!!!!111");
		
	}
}
