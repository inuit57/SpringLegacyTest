package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)

public class MemberDAOTest {

	// DAO 객체 생성 ( 의존관계)
	//private MemberDAO mDAO = new MemberDAOImpl(); //강한 결합
	
	// 의존 주입 
	@Inject
	private MemberDAO mDAO ; 
	
	// DAO 객체 주입 확인
	@Test
	public void testDAO() {
		System.out.println("DAO : " + mDAO);
	}
	
	@Test
	public void testDAO2() {
		System.out.println("메서드 호출 테스트 ");
		System.out.println(mDAO.getTime());
	}
	
}
