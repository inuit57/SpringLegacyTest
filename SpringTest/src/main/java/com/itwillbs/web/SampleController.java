package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	//private static final Logger logger = LoggerFactory.getLogger(현재클래스명.class);
	
	// http://localhost:8088/web/doA
	//컨트롤에서의 동작은 메서드로 구현 
	@RequestMapping("doA")
	public void doA() {
		logger.info("출력하기!!!!!!!!!!!!!!!!!!!!!!111");
		// sysout과는 달리 INFO : 가 앞에 붙고 출력된다. 
		// 잘 보이고 리소스를 많이 잡아먹는 system call을 사용하지 않기 위해서 log를 사용 
		
		logger.info("doA() 메서드 호출");
	}

	// http://localhost:8088/web/doA2
	// doA2.jsp 를 찾을 수 없습니다. -> 메서드 이름이 아닌 Mapping한 이름을 기준으로 찾는다.
	@RequestMapping("/doA2")
	public void doA1() {
		logger.info("doA1() 메서드 호출");
	}
	
	// * 컨트롤러의 동작 메서드의 리턴 타입이 void인 경우 
	// 매핑된 현재 경로의 주소.jsp 페이지를 호출한다. 
	
	// * view 폴더 안에 있는 파일을 사용 
	
}
