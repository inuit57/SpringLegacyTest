package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

// @Repository : 스프링에 DAO 파일을 인식한다.
//				=> root-context.xml 에서 해당 객체를 bean으로 인식한다.

@Repository
public class MemberDAOImpl implements MemberDAO {
	// DAO 객체 
	
	// DB 연결 + 자원 해제 객체를 생성 => SqlSessionTemplate 객체 
	// => 객체를 주입 받아서 사용 
	
	@Inject
	private SqlSession sqlSession ; 
	
	//mapper 주소
	// xml 에 작성한 namespace랑 같아야한다. 
	private static final String namespace 
			= "com.itwillbs.mapper.MemberMapper" ;  
	
	@Override
	public String getTime() {
		System.out.println("session : "+ sqlSession);
		System.out.println("DB-SQL 구문 실행 ");
		
		System.out.println("sqlSession 객체를 사용해서 mapper 호출");
		
		String result = sqlSession.selectOne(namespace+".getTime");
		//sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		// 제네릭 타입으로 리턴. mapper에서 설정한 타입으로 리턴. (캐스팅이 필요 없다)
		
		return result;
	}
	
	@Override
	public void insertMember(MemberVO vo) {
		
		System.out.println("DAOImpl 객체 - insertMember() 호출");
		System.out.println("SqlSEssion 객체 생성 - mapper 접근");
		
		//sqlSession.insert(namespace); // sql 쿼리만 실행
		//sqlSession.insert(namespace  , Object ); // sql 쿼리 + 쿼리에 필요한 값을 전달
		
		sqlSession.insert(namespace+".insertMember" ,  vo); 
		
		System.out.println("mapper 사용 -> DB 실행 ");
		System.out.println("회원 가입 성공 -> TEST 파일로 이동 ");
	}

	@Override
	public MemberVO getMember(String userid) {

		System.out.println("DAO : getMember() 호출");
		System.out.println("DAO : DB 연결(sqlSession), mapper로 이동. sql 실행");
		
		MemberVO vo = sqlSession.selectOne(namespace+".getMember" ,userid);
		
		System.out.println("DAO " + vo);
		
		return vo ; 
	}

	@Override
	public void updateMember(MemberVO vo) {
		System.out.println("DAO : updateMember() 호출");
		System.out.println("DAO : DB연결(sqlSession) , mapper 호출, sql 실행");
		
		sqlSession.update(namespace+".updateMember", vo) ;
	}

	@Override
	public void deleteMember(MemberVO vo) {

		System.out.println("DAO : deleteMember() 호출");
		System.out.println("DAO : DB연결(sqlSession) , mapper 호출, sql 실행");
		
		sqlSession.delete(namespace+".deleteMember", vo); 
	}

	@Override
	public void LoginMember(String loginId, String loginPw) {

		System.out.println("DAO : LoginMember() 호출 ");
		
		// 전달되는 데이터 값이 서로 연관이 없는 경우 (하나의 객체에 못 넣는 경우)
		// Map을 사용하여 데이터를 저장 => key, value 쌍으로 데이터 저장 
		
		Map<String, Object> paramMap = new HashMap<String, Object>();  
		
		//key값은 DB에서 조회해오는 컬럼명이랑 동일해야 한다.
		paramMap.put("userid", loginId); 
		paramMap.put("userpw", loginPw); 
		
		sqlSession.selectOne(namespace+".LoginMember",paramMap );
	}

}
