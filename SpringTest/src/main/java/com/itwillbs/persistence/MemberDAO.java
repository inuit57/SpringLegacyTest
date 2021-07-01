package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {

	// DB를 사용하는 기능 구현 ( 추상메서드 ) 
	
	// DB 서버의 시간 정보를 가져오는 기능
	public String getTime(); 
	
	// 회원 정보 가입 기능
	public void insertMember(MemberVO vo); 
	
	// 회원 정보 가져오는(조회) 기능 
	public MemberVO getMember(String userid);

	//회원 정보 수정
	public void updateMember(MemberVO vo);
	

	public void deleteMember(MemberVO vo);

	public MemberVO loginMember(String loginId, String loginPw);

	public List<MemberVO> getMemberList(); 
}
