<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link type="text/css" rel="stylesheet" href="/com.globalin.login.view/form2.css"><!--"/com.globalin.login.view/form2.css?ver=1.3"  -->
<script type="text/javascript" src="script.js"></script>
<style>
table, tr, td {
	border: 0;
}

table{
padding:0px;
}
</style>


</head>
<body onload="begin()">


	<form action="member.mdo?cmd=deleteProc" method="post" name="myForm"
		onsubmit="return checkIt()">

		<table width="400" border="1" align="center">
			<tr>
				<td colspan="2" align="center"><b>회원 탈퇴</b></td>
			</tr>

			<tr>
				<td width="200"><b> 비밀번호</b></td>
				<td width="200"><input type="password" name="pass" size="15"></td>

			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="회원탈퇴">&nbsp;&nbsp; <input type="button" value="취소"
					onclick="javascript:window.location='member.mdo?cmd=login'">
				</td>
			</tr>

		</table>

	</form>
</body>
</html>