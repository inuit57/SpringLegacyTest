package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
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
	public void testGetTime() {
		System.out.println("메서드 호출 테스트 ");
		System.out.println(mDAO.getTime());
	}
	
	@Test
	public void testInsertMember() {
		System.out.println("insert 호출 테스트");
		
		MemberVO vo = new MemberVO(); 
		vo.setUserid("admin22");
		vo.setUserpw("1234");
		vo.setUsername("관리자");
		vo.setUseremail("admin@itwillbs.co.kr");
		
		mDAO.insertMember(vo);
		
		System.out.println("객체 등록 완료 ");
	}
	
}
