<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1>WebContent/member/updateForm.jsp</h1>
  
  <h2> 회원수정(springMVC) </h2>
  <!-- 아이디,비밀번호, 이름,나이, 성별(라디오버튼),이메일 -->
  
  
  <fieldset>
    <legend> 아이티윌 회원 수정 페이지 </legend>
    <form action="./update" method="post">
      아이디 : <input type="text" name="userid" readonly value="${mdto.userid }"><br>
      비밀번호 : <input type="password" name="userpw" placeholder="비밀번호 입력하시오."><br>
      이름 : <input type="text" name="username" value="${mdto.username }"><br>
      이메일 : <input type="email" name="useremail" value="${mdto.useremail }"><br>
      <hr>
     <input type="submit" value="회원수정">           
    
    </form>  
  </fieldset>
  
  
  
  
  
  
  
  
  

</body>
</html>