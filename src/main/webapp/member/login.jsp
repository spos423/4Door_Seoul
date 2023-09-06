<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="loginID" value="${sessionScope.loginID }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
<link type="text/css" rel="stylesheet" href="/member/form2.css">

<style>
table, tr, td {
	border: 0;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${loginID ne null }">
			<div class="mypage" align="center" style="position:absolute;top:30%;left:40%;">
				<table width="300" border="0" align="center">



					<tr>
						<td align="center" colspan="3"><c:out value="${loginID }" />님
							환영합니다.</td>



					</tr>

					<tr>
						<td width="100" align="center"><a
							href="member.mdo?cmd=modifyForm">정보수정</a></td>
					</tr>
					<tr>
						<td width="100" align="center"><a
							href="member.mdo?cmd=delete">회원탈퇴</a></td>
					</tr>
					<tr>
						<td width="100" align="center"><a
							href="member.mdo?cmd=logout">로그아웃</a></td>
					</tr>



				</table>
			</div>
		</c:when>

		<c:otherwise>
			<c:if test="${requestScope.check eq 0 }">
				<script type="text/javascript">
					alert('비밀번호가 틀렸습니다.');
				</script>
			</c:if>

			<c:if test="${requestScope.check eq -1 }">
				<script type="text/javascript">
					alert('아이디가 존재하지 않습니다.');
				</script>
			</c:if>

			<form action="member.mdo?cmd=loginProc" method="post">
				<table>
					<tr>
						<td align="center" colspan="2">회원 로그인</td>
					</tr>

					<tr>


						<td width="200">&nbsp;&nbsp; <input type="text" name="id"
							size="20">
						</td>
					</tr>

					<tr>

						<td width="200">&nbsp;&nbsp; <input type="password"
							name="pass" size="20">
						</td>
					</tr>

					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="로그인">&nbsp;&nbsp; <input type="button"
							value="회원가입"
							onclick="javascript:window.location='member.mdo?cmd=regForm'">
						</td>
					</tr>
				</table>


				<!-- <div class="btns mt-2 flex justify-between"> -->
				<!-- <div>
					<a a class="btn btn-active btn-ghost" href="findLoginId">아이디찾기</a>
					<a a class="btn btn-active btn-ghost" href="findLoginPw">비밀번호찾기</a>
				</div> -->





			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>