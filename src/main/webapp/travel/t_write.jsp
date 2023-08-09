<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">
<title></title>
</head>
<body style="display: flex; flex-flow: column; min-height: 100vh; padding: 0; margin: 0;">

	<!-- Navbar Start -->
	<header>
		<c:import url="./header.jsp"></c:import>
	</header>
	<!-- Navbar End -->


	<!-- Carousel Start -->
	<div class="dd"
		style="float: left; height: 100px; width: 100%; display: inline-block;"></div>



	<main class="container-fluid px-0 mb-5"
		style="float: left; width: 60%; display: block; flex: 1;">
		<h4 style="font-family: 견고딕; color:gray">홈 > 여행정보 > 축제&행사 > 글쓰기</h4>
	  <br>
	  <h1 style="text-align: center; font-family: 견고딕; padding-bottom: 10px;">여행정보 글쓰기</h1>
	  <form action="#" method="post">
	    <div class="form-group" style="font-family: 견고딕; margin :20px 0px 20px 0px; font-size:18px;">
	      <label for="title">제목</label>
	      <input type="text" class="form-control"
	       placeholder="제목 입력(4-100)" name="title"
	       maxlength="100" required="required"
	       pattern=".{4,100}"
	       style="margin-top: 5px;">
	    </div>
	    
	    <div class="form-group" style="margin-bottom : 10px;">
	      <label for="writer">작성자</label>
	      <input type="text" class="form-control" id="writer"
	       placeholder="작성자(2자-10자)" name="writer">
	    </div>
	    
	    <div class="form-group" style="margin-bottom : 10px;">
	    	<label for="file">파일 업로드</label>
	    	<input type="file" class="form-control form-control-sm" id="formFileSm">
	    </div>
		
		<br>
	    
	    <div class="form-group" style="margin-bottom : 10px;">
		   <label for="content">내용</label>
		   <textarea class="form-control" rows="30" id="content"
		    name="content" placeholder="내용 작성"></textarea>
		</div>
		
		<div class="form-group" style="margin-bottom : 10px;">
	      <label for="zipcode" style="display: block;">우편번호 / 도로명 주소</label>
	      <input type="text" class="form-control" id="zipcode" placeholder="우편번호 5자리" name="zipcode" style="width: 300px; display:inline-block;">
	      <input type="button" class="btn btn-default" value="검색" onclick="#" style="margin-bottom : 10px;">
	      <input type="text" class="form-control" id="zipcode" placeholder="도로명 주소 입력" name="zipcode">
		</div>
	    
	   	<div class="form-group" style="margin-bottom : 10px;">
	      <label for="traffic_info">교통정보</label>
	      <input type="text" class="form-control" id="traffic_info"
	       placeholder="교통 정보를 간단하게 입력" name="traffic_info">
	    </div>
	    
	    <div class="form-group" style="margin-bottom : 10px;">
	      <label for="fee_info">이용요금</label>
	      <input type="text" class="form-control" id="fee_info"
	       placeholder="요금 입력" name="fee_info">
	    </div>
	    
	    <div class="form-group" style="margin-bottom : 10px;">
	      <label for="tel_info">전화번호</label>
	      <input type="text" class="form-control" id="tel_info" placeholder="행사 담당 연락처 입력" name="tel_info">
	    </div>
	    
	    <div class="form-group" style="margin-bottom : 10px;">
	      <label for="url_info">웹사이트</label>
	      <input type="text" class="form-control" id="url_info" placeholder="요금 입력" name="url_info">
	    </div>
		
		<div class="form-group" style="display: inline-block;">
			<label for="start_event">행사 시작일</label><br>
			<input type="datetime-local" class="form-control" name="start_event">&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<div class="form-group" style="display: inline-block;">	
			<label for="end_event">행사 종료일</label><br>
			<input type="datetime-local" class="form-control" name="end_event">&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		
		<div>	
		    <button style="width: 100px" type="submit" class="btn btn-default">등 록</button>
		    <button style="width: 100px" type="button" class="btn btn-default">취 소</button>
	    </div>
	  </form>
	  
	</main>


	<!-- Carousel End -->

	<!-- Copyright Start -->
	<footer>
		<c:import url="./footer.jsp"></c:import>
	</footer>
	<!-- Copyright End -->

	<!-- Back to Top -->
	<a href="#"
		class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i
		class="bi bi-arrow-up"></i></a>

</body>
</html>