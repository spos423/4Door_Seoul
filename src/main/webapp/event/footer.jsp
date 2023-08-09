<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title></title>
</head>
<body>
   <!-- Copyright Start -->
    <div class="container-fluid copyright py-4">
        <div class="container">
            <div class="row">
                <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                    &copy; <a class="fw-medium" href="#">Your Site Name</a>, All Right Reserved.
                </div>
                <div class="col-md-6 text-center text-md-end">
                    <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                    Designed By <a class="fw-medium" href="https://htmlcodex.com">HTML Codex</a> Distributed By <a class="fw-medium" href="https://themewagon.com">ThemeWagon</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Copyright End -->
    
    		<div class="collapse" id="collapseExample">
			<div class="card card-body">
			<div class="container text-center">
				<form class="form-control"  id="sh-date" action="#" method="post" style="display:none;">
					<label>시작일 </label> 
					<input type="date" style="width: 200px;">
					<label>~ 종료일 </label>
    				<input type="date" style="width: 200px;">
    				<input type="submit" value="검색">
    			</form>
    		</div>	
  			</div>
		</div>	
	
		<div class="collapse" id="collapseExample2">
			<div class="card card-body">
    		<div class="container text-center">
    			<form class="form-control" id="sh-keyword" action="#" method="post" style="display:none;">
    				<input type="text" name="keyword">
    				<input type="submit" value="키워드 검색">
    			</form>
    		</div>
  			</div>
		</div>	
    </div>
</body>
</html>