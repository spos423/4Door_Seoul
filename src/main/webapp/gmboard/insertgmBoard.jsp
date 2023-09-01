<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><meta content="width=device-width, initial-scale=1.0" name="viewport">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Playfair+Display:wght@700;900&display=swap" rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="./lib/animate/animate.min.css" rel="stylesheet">
<link href="./lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

<!-- Bootstrap Stylesheet -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<!-- Template Stylesheet -->
<link href="./css/style.css" rel="stylesheet">

<title></title>
</head>
<body style="display:flex;
		     flex-flow:column;
		     min-height:100vh;
		     padding:0;
		     margin:0;">	   
		    
	<!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" role="status" style="width: 3rem; height: 3rem;"></div>
    </div>
    <!-- Spinner End -->

    
    <!-- Navbar Start -->
    <header>
    	<c:import url="./header.jsp"></c:import>
    </header>
    <!-- Navbar End -->


    <!-- Carousel Start -->
	<!-- <div class="dd" style="float: left; height:100px; width:100%; display:inline-block;"></div>

 -->

	<main class="container-fluid px-0 mb-5" style="float:left; width:60%; display: block; flex: 1;">
		 <div class="container">
    <div class="row">
     <h1 align="center">글쓰기</h1>
     <form method=post action="insertgmBoard.do" enctype="multipart/form-data">
     <table class="table">
       <tr>
        <th class="text-center danger bg-primary bg-opacity-50" width=15% align="left">이름</th>
        <td width=85%>
          <input type="text" name="writer"  size=85 />
        </td>
       </tr>
       
       <tr>
        <th class="text-center danger bg-primary bg-opacity-50" width=15% >제목</th>
        <td width=85%>
          <input type="text" name="title" size=85 />
          
        </td>
       </tr>
       
       <tr>
        <th class="text-center danger bg-primary bg-opacity-50" width=15%>내용</th>
        <td width=85%>
          <textarea rows="15" cols="90" name="content"></textarea>
        </td>
       </tr>
        <!-- <tr>
				<td bgcolor="orange" width="70">업로드</td>
				<td align="left">
					<input type="file" name="uploadFile" >
				</td>
			</tr> 
        
       <tr> -->
        <td colspan="2" class="text-center">
          <input type="submit" class="btn btn-xs btn-success" value="글쓰기">
          <input type="button" class="btn btn-xs btn-warning" value="취소" onclick="javascript:history.back()">
        </td>
       </tr>
     </table>
     </form>
    </div>
  </div>
	</main>
   	
   	
    <!-- Carousel End -->
	
    <!-- Copyright Start -->
    <footer>
    	<c:import url="./footer.jsp"></c:import>
    </footer>
    <!-- Copyright End -->
	
    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>

	<!-- JavaScript Libraries -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="./lib/wow/wow.min.js"></script>
    <script src="./lib/easing/easing.min.js"></script>
    <script src="./lib/waypoints/waypoints.min.js"></script>
    <script src="./lib/owlcarousel/owl.carousel.min.js"></script>
    <!-- Template JavaScript -->
    <script src="./js/main.js"></script>
	<!-- Bootstrap Script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>


</body>
</html>