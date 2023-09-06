<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 프로그램</title>
<style>
    .top-right {
        position: absolute;
        top: 0;
        right: 0;
        margin: 20px;
    }
</style>
</head>
<body>
<h3 align="center">인덱스 페이지</h3>
<div class="top-right">
		<!--  -->
		<c:if test="${loginID==null }">
    <a href="member.mdo?cmd=login">로그인</a>
    </c:if>
    <c:if test="${loginID!=null }">
  <a href="member.mdo?cmd=login">마이페이지</a>
  <a href="member.mdo?cmd=logout">로그아웃</a>
    </c:if>
</div>

  <c:if test="${requestScope.check eq 0 }">
             <script type="text/javascript">
             alert('비밀번호가 틀렸습니다.');
             history.go(-1); 
          
             </script>
             </c:if>
             
             <c:if test="${requestScope.check eq -1 }">
             <script type="text/javascript">
             alert('아이디가 존재하지 않습니다..');
            history.go(-1); 
             </script>
             </c:if>


<!-- <a href="member.mdo?cmd=regForm">회원가입</a> -->
</body>
</html>