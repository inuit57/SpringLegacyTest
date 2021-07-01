package com.itwillbs.web;

import java.util.List;

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
	//@Test
	public void testDAO() {
		System.out.println("DAO : " + mDAO);
	}
	
	//@Test
	public void testGetTime() {
		System.out.println("메서드 호출 테스트 ");
		System.out.println(mDAO.getTime());
	}
	
	//@Test
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
	
	//@Test
	public void testGetMember() {
		System.out.println("select 테스트");
		String userid = "admin"; 
		
		MemberVO vo = mDAO.getMember(userid); 
		System.out.println(vo);
	}
	
	//@Test
	public void testUpdateMember() {
		MemberVO vo = new MemberVO(); 
		vo.setUserid("admin22");
		vo.setUserpw("12345");
		vo.setUsername("수정 이름");
		vo.setUseremail("updateEMAIL@itwillbs.co.kr");
		
		mDAO.updateMember(vo); 
	}
	
	//@Test
	public void testDeleteMember() {
		MemberVO vo = new MemberVO(); 
		vo.setUserid("admin22");
		vo.setUserpw("12345");
		
		mDAO.deleteMember(vo); 
	}
	
	
	//로그인 처리
	//@Test
	public void testLogin() {
		
		// id, pw 에 해당하는 회원 정보가 있을 경우 - 로그인 성공
		// id, pw 에 해당하는 회원 정보가 없을 경우 - 로그인 실패
		String loginId = "admin11" ; 
		String loginPw = "1234" ; 
		
		MemberVO loginVo = mDAO.loginMember(loginId, loginPw); 
		
		if(loginVo != null) {
			System.out.println("TEST : 로그인 성공!!@@@@@@@@@@@@@@@@");
		}else {
			System.out.println("TEST : 로그인 실패!!@@@@@@@@@@@@@@@@"); 
		}
	}
	
	// 회원 전체 목록 조회
	@Test
	public void testMemberList() {
		System.out.println("TEST : 회원 전체 목록 조회! ");
		
		List<MemberVO> memberList =  mDAO.getMemberList();
		System.out.println("Test : " + memberList);
	}
}
