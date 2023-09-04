<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<div class="container">
	<form action="/event/InsertE_Reply.do" method="post" name="e_replyForm">
		<input type="hidden" name=ref value="${e_board.num}">
		<div class="input-group">
			<span class="input-group-text">Comment</span>
			<textarea class="form-control" aria-label="With textarea"></textarea>
			<button class="btn btn-outline-secondary" type="submit" id="button-addon2">등록하기</button>
		</div>
	</form>
</div>
</body>
</html>