<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">
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
    	<c:import url="/main/header.jsp"></c:import>
    </header>
    <!-- Navbar End -->


    <!-- Carousel Start -->
	<div class="dd" style="float: left; height:100px; width:100%; display:inline-block;"></div>



	<main class="container-fluid px-0 mb-5" style="float:left; width:60%; display: block; flex: 1;">
		
	</main>
   	
   	
    <!-- Carousel End -->
	
    <!-- Copyright Start -->
    <footer>
    	<c:import url="/main/footer.jsp"></c:import>
    </footer>
    <!-- Copyright End -->
	
    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>

</body>
</html>