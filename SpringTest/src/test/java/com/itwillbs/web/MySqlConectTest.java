package com.itwillbs.web;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.Connection;

public class MySqlConectTest {

	private static final String DRIVER = "com.mysql.jdbc.Driver"; 
	// 8.0~ "com.mysql.cj.jdbc.Driver
	private static final String DBURL = "jdbc:mysql://localhost:3306/springdb?useSSL=false";
	// 8.0~ "jdbc:mysql://localhost:3306/springdb?useSSL=false&serverTimezone=Asia/Seoul"
	
	private static final String DBID = "root"; 
	private static final String DBPW = "1234"; 
	
	// Junit 사용 테스트 
	//@Test
	public void testCon() {
		
		try {
			Class.forName(DRIVER);
			Connection con = (Connection) DriverManager.getConnection(DBURL,DBID,DBPW);
			System.out.println("디비연결 : " + con);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 추가 공부 필요 : TDD (테스트 기반 개발)
	@Test
	public void testCon2() throws Exception {
	
		//try - with : 1.7 이상의 java에서 사용가능
		// (이하 버전일 경우 오류가 생기는데 그냥 버전을 올려주면 된다.) 
		// try~catch~finally 를 한번에 쓰는 것. 
		
//		try(AutoCloseable인터페이스를 구현한 객체 ){
//			
//		}catch(Exception e) {
//			
//		}
		
		//1. 드라이버 로드
		Class.forName(DRIVER);
		//2 . 디비 연결 
		try(Connection con = (Connection) DriverManager.getConnection(DBURL,DBID,DBPW)){
			System.out.println("DB 연결 성공! : " + con);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
			
}
