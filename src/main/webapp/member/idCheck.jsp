<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복 체크</title>

<link type="text/css" rel="stylesheet" href="style.css">
<script type="text/javascript" src="script.js"></script>

</head>

<br>

<div align="center">


	<b>${id}</b>
	<c:if test="${check eq true }">
  는 이미 존재하는 ID입니다.<br>
	</c:if>

	<c:if test="${check ne true }">
  는 사용가능한 ID입니다.<br>
	</c:if>


	<a href="#" onclick="javascript:self.close()">닫기</a>

</div>

</body>
</html>