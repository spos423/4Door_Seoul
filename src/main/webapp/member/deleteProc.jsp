<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" 
content="1;url=member.mdo?cmd=index">
<title>회원탈퇴</title>
</head>
<body>
<c:set var="result" value="${result }" />
	
<div align="center">
   
 <script>
    window.onload = function() {
        alert("회원탈퇴 성공");
    }; 
</script>
</div>
<c:if test="${result eq 0 }">
<script type="text/javascript">
       alert("비밀번호 오류");
       history.go(-1);
</script>
</c:if>


</body>
</html>