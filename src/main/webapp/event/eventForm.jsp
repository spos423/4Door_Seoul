<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<c:import url="../main/nav2.jsp" />
</head>
<body>
<div class="container" style="flex:1;">
  <h2>게시판 글쓰기</h2>
  <form action="#" method="post">
    <div class="form-group">
      <label for="title">제목</label>
<!-- placeholder 속성 입력한 데이터가 없는 경우 배경으로 나타난다.실제적으로 입력을 100자까지로 지정 -->
<!-- required 속성을 설정하면 필수입력 사항이된다. -->
<!-- pattern 속성을 이용한 정규표현식으로 데이터의 유효성 검사를 할 수 있다. -->
      <input type="text" class="form-control" id="title"
       placeholder="제목 입력(4-100)" name="title"
       maxlength="100" required="required"
       pattern=".{4,100}">
    </div>
    
    <div class="form-group">
      <label for="writer">작성자</label>
      <input type="text" class="form-control" id="writer" placeholder="작성자(2자-10자)" name="writer">
    </div>
    
    <div>
    <input type="file" class="form-control form-control-sm" id="formFileSm">
    </div>
	
	<br>
    
    <div class="form-group">
   <label for="content">내용</label>
<!--  여러줄의 데이터를 입력하고 하고자 할때 textarea 태그를 사용한다. -->
<!--  textarea 안에 있는 모든 글자는 그대로 나타난다. 공백문자, tag, enter -->
   <textarea class="form-control" rows="30" id="content"
    name="content" placeholder="내용 작성"></textarea>
	</div>
	
	<div class="form-group">
      <label for="zipcode">우편번호 / 도로명 주소</label>
      <input type="text" width="30" id="zipcode" placeholder="우편번호 5자리" name="zipcode">
      <input type="button" class="btn btn-default" value="검색" onclick="#">
      <input type="text" class="form-control" id="zipcode" placeholder="도로명 주소 입력" name="zipcode">
	</div>
    
   	<div class="form-group">
      <label for="traffic_info">교통정보</label>
      <input type="text" class="form-control" id="traffic_info"
       placeholder="교통 정보를 간단하게 입력" name="traffic_info">
    </div>
    
    <div class="form-group">
      <label for="fee_info">이용요금</label>
      <input type="text" class="form-control" id="fee_info"
       placeholder="요금 입력" name="fee_info">
    </div>
    
    <div class="form-group">
      <label for="tel_info">전화번호</label>
      <input type="text" class="form-control" id="tel_info" placeholder="행사 담당 연락처 입력" name="tel_info">
    </div>
    
    <div class="form-group">
      <label for="url_info">웹사이트</label>
      <input type="text" class="form-control" id="url_info" placeholder="요금 입력" name="url_info">
    </div>
	
	<div style="display: inline-block;">
		<label for="start_event">행사 시작일</label><br>
		<input type="datetime-local" class="form-control" name="start_event">&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<div style="display: inline-block;">	
		<label for="end_event">행사 종료일</label><br>
		<input type="datetime-local" class="form-control" name="end_event">&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	
	<br>
	
	<div>	
    <button class="dark" style="width: 100px; border-radius: 20px;" type="submit" class="btn btn-default">등록</button>
    <button style="width: 100px" type="button" class="btn btn-default">취소</button>
    </div>
    
    <br><br>
    
  </form>
</div>

<footer style="height: 30%">
	<c:import url="../main/bottom.jsp" />
</footer>

</body>
</html>