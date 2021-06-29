<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> 회원 가입 페이지 </h2>
	<form action="/web/member/insert" method="post">
		ID : <input type="text" name="userid"> <br>
		PW : <input type="password" name="userpw"> <br>
		name : <input type="text" name="username"> <br>
		Email : <input type="email" name="useremail"> <br>
		<hr>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>