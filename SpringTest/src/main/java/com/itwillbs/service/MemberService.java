package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {

	
	// 실행해야 하는 동작을 구현 - 예외를 던져놓아야한다. 
	
	//회원 가입 처리 동작 
	public void insertMember(MemberVO vo) throws Exception; 
}
