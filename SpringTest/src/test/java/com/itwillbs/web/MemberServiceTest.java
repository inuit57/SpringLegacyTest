package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberServiceTest {

	// Service 객체를 생성 -> 의존 주입 
	@Inject
	private MemberService service;
	
	
	@Test
	public void testInsertMembersS() {
		try {
			MemberVO vo = new MemberVO(); 
			vo.setUserid("aaaa");
			vo.setUserpw("1234");
			vo.setUsername("bbbb");
			vo.setUseremail("aaaa@naver.com");
			
			service.insertMember(vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
