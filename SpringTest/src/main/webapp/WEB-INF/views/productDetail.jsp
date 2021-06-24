<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>productDetail.jsp</h1>
	
	<h3>${pvo }</h3>
	상품명 : ${pvo.name }<br>
	가격 : ${pvo.price } <br>
	<hr>
	
	<!-- key 값 없이 value만 넣었을 때 값을 조회하는 방법 -->
	<h1>전달되는 속성의 key값이 없는 경우 클래스명의 첫글자만 소문자로 변경해서 조회</h1>
	<h3>${productVO }</h3>
	
	<h3>${productVO.name }</h3>
	<h3>${productVO.price }</h3>
		
</body>
</html>