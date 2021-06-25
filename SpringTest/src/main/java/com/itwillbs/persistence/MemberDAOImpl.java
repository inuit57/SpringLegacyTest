package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

}
