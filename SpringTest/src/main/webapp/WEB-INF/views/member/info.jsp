<%@page import="java.io.Console"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>member/info.jsp(springMVC)</h1>

<h2> 회원 정보 조회 </h2>

	<table border="1">
	<tr>
		<td>아이디</td>
		<td>${mdto.userid }</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>${mdto.userpw }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${mdto.username }</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${mdto.useremail }</td>
	</tr>
	<tr>
		<td>회원가입일</td>
		<td>${mdto.regdate }</td>
	</tr>
	<tr>
		<td>최종수정일</td>
		<td>${mdto.updateDate }</td>
	</tr>
	</table>
	
	<a href="./main">메인으로 돌아가기</a>
</body>
</html>