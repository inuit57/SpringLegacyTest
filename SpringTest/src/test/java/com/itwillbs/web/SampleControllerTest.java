package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// 스프링 MVC 형태로 테스트 
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
		// /**/*.xml : 아래 경로에 있는 모든 폴더의 모든 xml 파일을 가져와서 사용하겠습니다.
		// root-context.xml ,  servlet-context.xml 모두 사용하겠다.
		)
public class SampleControllerTest {
	//테스트 파일 - 서버 없이 테스트 가능 
	
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleControllerTest.class);
	
	// 컨트롤러를 실행하는데 필요한 정보를 주입
	// root-context.xml , servlet-context.xml 에서 주입받는다. 
	@Inject
	private WebApplicationContext webCTX ; 
	
	// 브라우저에서 요청/응답을 처리하는 객체 
	private MockMvc mockMvc; 
	
	// 테스트 동작 전에 필요한 설정을 세팅 
	@Before
	public void setup() {
		this.mockMvc 
		= MockMvcBuilders.webAppContextSetup(this.webCTX).build();
		
		logger.info("setup() 메서드 호출!");
	}
	@Test
	public void testDoA() throws Exception{
		logger.info("testDoA() 메서드 호출!");
		mockMvc.perform(MockMvcRequestBuilders.get("/doA")); 
		// 서버를 실행하지 않은 상태에서 웹페이지 접속하는 방식. 
		
	}
	
}
