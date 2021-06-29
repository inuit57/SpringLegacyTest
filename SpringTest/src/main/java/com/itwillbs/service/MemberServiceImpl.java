package com.itwillbs.service;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

// @Service : 외부에서 해당 서비스를 호출 시 처리할 수 있도록 등록
//          => root-context.xml 파일에서 BEAN 형태로 인식 

@Service
public class MemberServiceImpl implements MemberService{

	// DAO 객체 생성
	@Inject
	private MemberDAO mdao ; 
	
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		System.out.println("S : 컨트롤러에서 정보를 받아서 제공 ");
		System.out.println("S : 회원가입 동작 ");
		
		mdao.insertMember(vo);
		
		System.out.println("S : 회원 가입 처리 완료");
		System.out.println("S : 컨트롤러로 이동");
	}

	
}