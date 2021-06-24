package com.itwillbs.web;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.jdbc.Connection;

//@RunWith(SpringJUnit4ClassRunner.class)
// => 테스트 코드를 실행할 때 Spring으로 처리되도록 설정 

//@ContextConfiguration(
//		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
//		)
// => 테스트시 필요한 설정을 지정한다. 


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {
	//DB 연결 => 디비 객체 필요 -> 디비 객체를 의존하고 있다.
	// => 의존 주입 (DI) 
	// @Inject : 이미 생성된 객체를 주입하는 어노테이션 
	
	
	@Inject // BeanFactory 만들어서 하는 것을 대체한다. 
	private DataSource ds ;
	
	@Test
	public void testDS() throws Exception{
		System.out.println("DataSource 객체 생성 여부 확인 ! ");
		System.out.println( ds );
	}
	
	@Test
	public void testCon() throws Exception{
		System.out.println("DB연결 메서드 실행 ! ");
		
		Connection conn = (Connection)ds.getConnection(); 
		System.out.println(conn);
	}
	
	

}
