
function zipSearch() {
	// 카카오 지도 발생
	new daum.Postcode({
		oncomplete: function(data) { //선택시 입력값 세팅
			document.getElementById("zipcode1").value = data.zonecode; // 우편번호 넣기
			document.getElementById("zipcode2").value = data.address; // 주소 넣기
			document.querySelector("input[name=address]").focus(); // 주소 포커싱
		}
	}).open();
}

// 파일 삭제 확인 메서드
function deleteCheck() {
	var res = confirm("정말 삭제하시겠습니까?");
	if(!res){
		event.preventDefault();
	}
}

// 파일 삭제 메서드
function fileDel() {
	var del = document.getElementById('delete');
	del.value = 1;
	var up = document.getElementById('fileName_u');
	var a = document.getElementById('a');
	var btn = document.getElementById('btnDel');
	a.style.display = 'none';
	btn.style.display = 'none';
	up.style.display = 'block';
}

// 축제&행사 write 체크
function formCheck0() {

	if(document.boardForm.title.value=="") {
		alert("제목을 작성해주세요");
		document.boardForm.title.focus();
		return;
	}
	
	if(!document.getElementById("fileName").value) {
		alert("사진을 업로드해주세요");
		document.boardForm.fileName.focus();
		return;
	}
	
	if(document.boardForm.content.value=="") {
		alert("내용을 입력해주세요.");
		document.boardForm.content.focus();
		return;
	}
	
	if(document.boardForm.tel_info.value=="") {
		alert("전화번호를 입력해주세요.");
		document.boardForm.tel_info.focus();
		return;
	}
	
	if(document.boardForm.url_info.value=="") {
		alert("웹사이트를 입력해주세요.");
		document.boardForm.url_info.focus();
		return;
	}
	
	if(document.boardForm.start_datetime.value=="") {
		alert("이용 기간 및 시간 (시작)을 입력해주세요.");
		document.boardForm.start_datetime.focus();
		return;
	}
	
	if(document.boardForm.end_datetime.value=="") {
		alert("이용 기간 및 시간 (종료)을 입력해주세요.");
		document.boardForm.end_datetime.focus();
		return;
	}
	
	
	var str1 = document.boardForm.start_datetime.value.split('T')[0].split('-');
	var str2 = str1[0]+str1[1]+str1[2];
	var start = parseInt(str2);
	
	
	var str3 = document.boardForm.end_datetime.value.split('T')[0].split('-');
	var str4 = str3[0]+str3[1]+str3[2] 
	var end = parseInt(str4);
	
	var date = new Date();
	var year = date.getFullYear();
	var month = ('0'+(date.getMonth()+1)).slice(-2);
	var day = ('0' + date.getDate()).slice(-2);
	var today = parseInt(year+month+day);
	
	if(start>end) {
		alert("이용 기간 시작일이 종료일보다 미래입니다.\n다시 확인해주세요.");
		document.boardForm.end_datetime.focus();
		return;
	}
	
	if(today>end) {
		alert("이용 기간 종료일이 현재날짜보다 과거입니다.\n다시 확인해주세요.");
		document.boardForm.end_datetime.focus();
		return;
	}
	
	if(document.boardForm.open_day.value=="") {
		alert("운영일을 입력해주세요.");
		document.boardForm.open_day.focus();
		return;
	}
	
	if(document.boardForm.fee_info.value=="") {
		alert("이용 요금을 입력해주세요.");
		document.boardForm.fee_info.focus();
		return;
	}
	
	if(document.boardForm.zipcode1.value=="") {
		alert("주소를 입력해주세요.");
		document.boardForm.zipcode1.focus();
		return;
	}
	
	if(document.boardForm.traffic_info.value=="") {
		alert("교통 정보를 입력해주세요.");
		document.boardForm.traffic_info.focus();
		return;
	}
	
	document.boardForm.submit();
}


// 볼거리 write 체크
function formCheck1() {

	if(document.boardForm.title.value=="") {
		alert("제목을 작성해주세요");
		document.boardForm.title.focus();
		return;
	}
	
	if(!document.getElementById("fileName").value) {
		alert("사진을 업로드해주세요");
		document.boardForm.fileName.focus();
		return;
	}
	
	if(document.boardForm.content.value=="") {
		alert("내용을 입력해주세요.");
		document.boardForm.content.focus();
		return;
	}
	
	if(document.boardForm.tel_info.value=="") {
		alert("전화번호를 입력해주세요.");
		document.boardForm.tel_info.focus();
		return;
	}
	
	if(document.boardForm.url_info.value=="") {
		alert("웹사이트를 입력해주세요.");
		document.boardForm.url_info.focus();
		return;
	}
	
	if(document.boardForm.open_day.value=="") {
		alert("운영일을 입력해주세요.");
		document.boardForm.open_day.focus();
		return;
	}
	
	if(document.boardForm.fee_info.value=="") {
		alert("이용 요금을 입력해주세요.");
		document.boardForm.fee_info.focus();
		return;
	}
	
	if(document.boardForm.zipcode1.value=="") {
		alert("주소를 입력해주세요.");
		document.boardForm.zipcode1.focus();
		return;
	}
	
	if(document.boardForm.traffic_info.value=="") {
		alert("교통 정보를 입력해주세요.");
		document.boardForm.traffic_info.focus();
		return;
	}
	
	document.boardForm.submit();
}


// 먹거리 write 체크
function formCheck2() {
	
	if(document.boardForm.title.value=="") {
		alert("제목을 작성해주세요");
		document.boardForm.title.focus();
		return;
	}
	
	if(!document.getElementById("fileName").value) {
		alert("사진을 업로드해주세요");
		document.boardForm.fileName.focus();
		return;
	}
	

	if(document.boardForm.content.value=="") {
		alert("내용을 입력해주세요.");
		document.boardForm.content.focus();
		return;
	}
	
	if(document.boardForm.tel_info.value=="") {
		alert("전화번호를 입력해주세요.");
		document.boardForm.tel_info.focus();
		return;
	}
	
	if(document.boardForm.open_day.value=="") {
		alert("운영일을 입력해주세요.");
		document.boardForm.open_day.focus();
		return;
	}
	
	if(document.boardForm.dish_info.value=="") {
		alert("대표 메뉴를 입력해주세요.");
		document.boardForm.dish_info.focus();
		return;
	}
	
	if(document.boardForm.zipcode1.value=="") {
		alert("주소를 입력해주세요.");
		document.boardForm.zipcode1.focus();
		return;
	}
	
	if(document.boardForm.traffic_info.value=="") {
		alert("교통 정보를 입력해주세요.");
		document.boardForm.traffic_info.focus();
		return;
	}
	
	document.boardForm.submit();
}


// 축제&행사 update 체크
function u_formCheck0() {

	if(document.boardForm.title.value=="") {
		alert("제목을 작성해주세요");
		document.boardForm.title.focus();
		return;
	}
	
	if(document.getElementById("delete").value=="1"){
		if(!document.getElementById("fileName_u").value) {
			alert("사진을 업로드해주세요");
			document.boardForm.fileName.focus();
			return;
		}
	}
	
	if(document.boardForm.content.value=="") {
		alert("내용을 입력해주세요.");
		document.boardForm.content.focus();
		return;
	}
	
	if(document.boardForm.tel_info.value=="") {
		alert("전화번호를 입력해주세요.");
		document.boardForm.tel_info.focus();
		return;
	}
	
	if(document.boardForm.url_info.value=="") {
		alert("웹사이트를 입력해주세요.");
		document.boardForm.url_info.focus();
		return;
	}
	
	if(document.boardForm.start_datetime.value=="") {
		alert("이용 기간 및 시간 (시작)을 입력해주세요.");
		document.boardForm.start_datetime.focus();
		return;
	}
	
	if(document.boardForm.end_datetime.value=="") {
		alert("이용 기간 및 시간 (종료)을 입력해주세요.");
		document.boardForm.end_datetime.focus();
		return;
	}
	
	
	var str1 = document.boardForm.start_datetime.value.split('T')[0].split('-');
	var str2 = str1[0]+str1[1]+str1[2];
	var start = parseInt(str2);
	
	
	var str3 = document.boardForm.end_datetime.value.split('T')[0].split('-');
	var str4 = str3[0]+str3[1]+str3[2] 
	var end = parseInt(str4);
	
	var date = new Date();
	var year = date.getFullYear();
	var month = ('0'+(date.getMonth()+1)).slice(-2);
	var day = ('0' + date.getDate()).slice(-2);
	var today = parseInt(year+month+day);
	
	if(start>end) {
		alert("이용 기간 시작일이 종료일보다 미래입니다.\n다시 확인해주세요.");
		document.boardForm.end_datetime.focus();
		return;
	}
	
	if(today>end) {
		alert("이용 기간 종료일이 현재날짜보다 과거입니다.\n다시 확인해주세요.");
		document.boardForm.end_datetime.focus();
		return;
	}
	
	if(document.boardForm.open_day.value=="") {
		alert("운영일을 입력해주세요.");
		document.boardForm.open_day.focus();
		return;
	}
	
	if(document.boardForm.fee_info.value=="") {
		alert("이용 요금을 입력해주세요.");
		document.boardForm.fee_info.focus();
		return;
	}
	
	if(document.boardForm.zipcode1.value=="") {
		alert("주소를 입력해주세요.");
		document.boardForm.zipcode1.focus();
		return;
	}
	
	if(document.boardForm.traffic_info.value=="") {
		alert("교통 정보를 입력해주세요.");
		document.boardForm.traffic_info.focus();
		return;
	}
	
	document.boardForm.submit();
}


// 볼거리 update 체크
function u_formCheck1() {

	if(document.boardForm.title.value=="") {
		alert("제목을 작성해주세요");
		document.boardForm.title.focus();
		return;
	}
	
	if(document.getElementById("delete").value=="1"){
		if(!document.getElementById("fileName_u").value) {
			alert("사진을 업로드해주세요");
			document.boardForm.fileName.focus();
			return;
		}
	}
	
	if(document.boardForm.content.value=="") {
		alert("내용을 입력해주세요.");
		document.boardForm.content.focus();
		return;
	}
	
	if(document.boardForm.tel_info.value=="") {
		alert("전화번호를 입력해주세요.");
		document.boardForm.tel_info.focus();
		return;
	}
	
	if(document.boardForm.url_info.value=="") {
		alert("웹사이트를 입력해주세요.");
		document.boardForm.url_info.focus();
		return;
	}
	
	if(document.boardForm.open_day.value=="") {
		alert("운영일을 입력해주세요.");
		document.boardForm.open_day.focus();
		return;
	}
	
	if(document.boardForm.fee_info.value=="") {
		alert("이용 요금을 입력해주세요.");
		document.boardForm.fee_info.focus();
		return;
	}
	
	if(document.boardForm.zipcode1.value=="") {
		alert("주소를 입력해주세요.");
		document.boardForm.zipcode1.focus();
		return;
	}
	
	if(document.boardForm.traffic_info.value=="") {
		alert("교통 정보를 입력해주세요.");
		document.boardForm.traffic_info.focus();
		return;
	}
	
	document.boardForm.submit();
}


// 먹거리 update 체크
function u_formCheck2() {
	
	if(document.boardForm.title.value=="") {
		alert("제목을 작성해주세요");
		document.boardForm.title.focus();
		return;
	}
	
	if(document.getElementById("delete").value=="1"){
		if(!document.getElementById("fileName_u").value) {
			alert("사진을 업로드해주세요");
			document.boardForm.fileName.focus();
			return;
		}
	}
	

	if(document.boardForm.content.value=="") {
		alert("내용을 입력해주세요.");
		document.boardForm.content.focus();
		return;
	}
	
	if(document.boardForm.tel_info.value=="") {
		alert("전화번호를 입력해주세요.");
		document.boardForm.tel_info.focus();
		return;
	}
	
	if(document.boardForm.open_day.value=="") {
		alert("운영일을 입력해주세요.");
		document.boardForm.open_day.focus();
		return;
	}
	
	if(document.boardForm.dish_info.value=="") {
		alert("대표 메뉴를 입력해주세요.");
		document.boardForm.dish_info.focus();
		return;
	}
	
	if(document.boardForm.zipcode1.value=="") {
		alert("주소를 입력해주세요.");
		document.boardForm.zipcode1.focus();
		return;
	}
	
	if(document.boardForm.traffic_info.value=="") {
		alert("교통 정보를 입력해주세요.");
		document.boardForm.traffic_info.focus();
		return;
	}
	
	document.boardForm.submit();
}