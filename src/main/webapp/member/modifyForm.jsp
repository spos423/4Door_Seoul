<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<link type="text/css" rel="stylesheet" href="/member/form.css"><!-- "/com.globalin.login.view/form.css?ver=1.3" -->
<script type="text/javascript" src="script.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
table, tr, td {border:0;}
</style>


<!-- <script>
 
    function checkz() {
      var getIntro = $("#intro").val().replace(/\s|/gi,'');
      var hobbyCheck = false;
      var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
      var getCheck= RegExp(/^[a-zA-Z0-9]{4,12}$/);
      var getName= RegExp(/^[가-힣]+$/);
      var fmt = RegExp(/^\d{6}[1234]\d{6}$/); //형식 설정
      
 
 
      //아이디 공백 확인
      if($("#id").val() == ""){
        alert("아이디 입력");
        $("#id").focus();
        return false;
      }
 
      //이름의 유효성 검사
      if(!getCheck.test($("#id").val())){
        alert("형식에 맞게 입력해주세요");
        $("#id").val("");
        $("#id").focus();
        return false;
      }
 
      //비밀번호
      if(!getCheck.test($("#pass").val())) {
      alert("형식에 맞게 입력해주세요");
      $("#pass").val("");
      $("#pass").focus();
      return false;
      }
 
      //아이디랑 비밀번호랑 같은지
      if ($("#id").val()==($("#pass").val())) {
      alert("id와 중복");
      $("#pass").val("");
      $("#pass").focus();
    }
 
      //비밀번호 똑같은지
      if($("#pass").val() != ($("#repass").val())){ 
      alert("비밀번호 존재하지않음");
      $("#pass").val("");
      $("#repass").val("");
      $("#pass").focus();
      return false;
     }

     //이메일 공백 확인
      if($("#email").val() == ""){
        alert("이메일을 입력해주세요");
        $("#email").focus();
        return false;
      }
           
      //이메일 유효성 검사
      if(!getMail.test($("#email").val())){
        alert("이메일형식에 맞게 입력해주세요")
        $("#email").val("");
        $("#email").focus();
        return false;
      }
 	document.regForm.sumbit();
    
        }
 
  </script> -->


</head>
<body>
	<form action="member.mdo?cmd=modifyProc" method="post" name="regForm">
		<table border="1">
			<tr>
				<td align="center" colspan="2">회원 정보 수정</td>
			</tr>

			<tr>
				<td align="right">아이디</td>
				<td><input type="hidden" name="id" value="${id }">&nbsp;${id } <!-- <input
					type="button" value="중복확인" onclick="idCheck(this.form.id.value)"> -->
				</td>
			</tr>

			<tr>
				<td align="right">비밀번호</td>
				<td><input type="password" name="pass" value="${pass }"></td>
			</tr>

			<tr>
				<td align="right">비밀번호 확인</td>
				<td><input type="password" name="repass" value="${pass }"></td>
			</tr>

			<tr>
				<td align="right">이름</td>
				<td><input type="hidden" name="name"  value="${name }" >${name }</td>
			</tr>

			<tr>
				<td align="right">휴대전화</td>
				<td><select name="phone1">
						<option value="010">010</option>
				</select>- <input type="text" name="phone2" size="5" value="${phone2 }">- <input
					type="text" name="phone3" size="5" value="${phone3 }"></td>
			</tr>

		<%-- 	<tr>
				<td align="right">이메일</td>
				<td><input type="text" id="emailId" name="email"
					placeholder="이메일 입력"  value=${email }> <span>@</span> <input id="textEmail"
					placeholder="이메일을 선택"> <select id="select"
					onchange="emailOptionChanged(this)">
						<option value="" disabled selected>E-Mail 선택</option>
						<option value="naver.com">naver.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="gmail.com">gmail.com</option>
						<option value="directly">직접 입력하기</option>
				</select></td>
			</tr> --%>
			
			
			    <tr>
                  <td align="right">  이메일 </td>
                  <td><input type="text" name="email" value="${email }">
                  </td>          
          </tr>

			<tr>
				<td colspan="2" align="center"><input type="button"
					value="정보수정" onclick="inputCheck()">&nbsp;&nbsp;</td>
			</tr>

		</table>

	</form>

<!-- 	<script>
		function emailOptionChanged(selectElement) {
			var emailInput = document.getElementById("textEmail");
			if (selectElement.value === "directly") {
				emailInput.style.display = "inline";
			} else {
				emailInput.style.display = "none";
			}
		}
	</script> -->


</body>
</html>