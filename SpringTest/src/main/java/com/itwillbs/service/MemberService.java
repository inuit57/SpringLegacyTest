package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {

	
	// 실행해야 하는 동작을 구현 - 예외를 던져놓아야한다. 
	
	//회원 가입 처리 동작 
	public void insertMember(MemberVO vo) throws Exception; 
	
	//로그인 체크 동작
	public MemberVO loginMember(MemberVO vo) throws Exception;
	public MemberVO loginMember(String loginID, String loginPW) throws Exception;
	
	//유저 정보 조회
	public MemberVO getMember(String id) throws Exception; 
}
