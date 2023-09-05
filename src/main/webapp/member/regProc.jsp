<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>

<%--  <meta charset="UTF-8" http-equiv="refresh" content="3;url=member.mdo?cmd=login"> --%>
<title>회원가입확인</title>
</head>
<body bgcolor="#FFFFCC">
<c:set var="flag" value="${flag }" />
<br>
<div align="center">
<c:choose>
             <c:when test="${flag}">
                     <b>회원가입 성공</b><br>
                     <a href="member.mdo?cmd=login">로그인</a>
             </c:when>
  
             <c:otherwise>
                     <b>다시 입력하여 주십시요.</b><br>
                     <a href="member.mdo?cmd=regForm">다시입력</a>
             </c:otherwise> 
</c:choose>
</div>

</body>
</html>