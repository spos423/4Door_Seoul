function formCheck() {

    if(document.eventForm.title.value==""){
    alert('제목를 입력해주세요.');
    document.eventForm.title.focus();
    return false;
    }
    
    if(document.eventForm.writer.value==""){
    alert('작성자를 입력해주세요.');
    document.eventForm.writer.focus();
    return false;
    }
    
    if(document.eventForm.zipcode.value==""){
    alert('우편번호를 입력해주세요.');
    document.eventForm.address.focus();
    document.getElementById("address_kakao").click();
    return false;
    }
    
    if(document.eventForm.address.value==""){
    alert('주소를 입력해주세요.');
    document.eventForm.address.focus();
    return false;
    }
    
    if(document.eventForm.startdate.value==""){
    alert('행사 시작일을 입력해주세요.');
    document.eventForm.startdate.focus();
    return false;
    }
    
	if(document.eventForm.enddate.value==""){
    alert('행사 종료일을 입력해주세요.');
    document.eventForm.enddate.focus();
    return false;
    }
    
   	let splitStartdate = document.eventForm.startdate.value.split('T');
    let splitEnddate = document.eventForm.enddate.value.split('T');
    let getStartdate = splitStartdate[0].split('-');
    let getEnddate = splitEnddate[0].split('-');
    
    var start = new Date(getStartdate[0], getStartdate[1], getStartdate[2]);
    var end = new Date(getEnddate[0], getEnddate[1], getEnddate[2]);   
    
    compare = end.getTime() - start.getTime();
        
    if(compare<0){
    alert('행사 시작일은 행사 종료일 보다 빨라야 합니다.');
    document.eventForm.startdate.focus();
    return false;
    }
	
}

function lengthLimit(el,maxlength) {
	if(el.length > maxlength){
    el.value = el.value.substr(0, maxlength);
    }
}


function startFirst(){
	if(document.eventForm.startdate.value==""){
	alert('행사 시작일을 먼저 입력해주세요.');
	document.eventForm.startdate.focus();
    return false;
	}
}

function compareDate(){
	let getStartdate = document.eventForm.startdate.value.split('-');
    let getEnddate = document.eventForm.enddate.value.split('-');
    
    let start = new Date(getStartdate[0], getStartdate[1], getStartdate[2]);
    let end = new Date(getEnddate[0], getEnddate[1], getEnddate[2]);   
    
    compare = end.getTime() - start.getTime();
        
    if(compare<0){
    alert('행사 시작일은 행사 종료일 보다 빨라야 합니다.');
    document.eventForm.startdate.focus();
    return false;
    }
}

function fileUploadCheck(fileVal) {
	let fileLength = fileVal.length;
	let fileDot = fileVal.lastIndexOf(".");
	let fileType = fileVal.substring(fileDot+1, fileLength).toLowerCase();
	
	if(fileType !== "jpg" && fileType !== "jpeg" && fileType !== "png"){
	alert('업로드 파일의 확장자는 jpg, jpeg, png만 가능합니다.');
	document.eventForm.thumb_img1.value="";
	}
}



var fileNo = 0;
var filesArr = new Array();

/* 첨부파일 추가 */
function addFile(obj){
    var maxFileCnt = 5;   // 첨부파일 최대 개수
    var attFileCnt = document.querySelectorAll('.filebox').length;    // 기존 추가된 첨부파일 개수
    var remainFileCnt = maxFileCnt - attFileCnt;    // 추가로 첨부가능한 개수
    var curFileCnt = obj.files.length;  // 현재 선택된 첨부파일 개수

    // 첨부파일 개수 확인
    if (curFileCnt > remainFileCnt) {
        alert("첨부파일은 최대 " + maxFileCnt + "개 까지 첨부 가능합니다.");
    } else {
        for (const file of obj.files) {
            // 첨부파일 검증
            if (validation(file)) {
                // 파일 배열에 담기
                var reader = new FileReader();
                reader.onload = function () {
                    filesArr.push(file);
                };
                reader.readAsDataURL(file);

                // 목록 추가
                let htmlData = '';
                htmlData += '<div id="file' + fileNo + '" class="filebox">';
                htmlData += '   <p class="name">' + file.name + '</p>';
                htmlData += '   <a class="delete" onclick="deleteFile(' + fileNo + ');"><i class="far fa-minus-square"></i></a>';
                htmlData += '</div>';
                $('.file-list').append(htmlData);
                fileNo++;
            } else {
                continue;
            }
        }
    }
    // 초기화
    document.querySelector("input[type=file]").value = "";
}

/* 첨부파일 검증 */
function validation(obj){
    const fileTypes = ['application/pdf', 'image/gif', 'image/jpeg', 'image/png', 'image/bmp', 'image/tif', 'application/haansofthwp', 'application/x-hwp'];
    if (obj.name.length > 100) {
        alert("파일명이 100자 이상인 파일은 제외되었습니다.");
        return false;
    } else if (obj.size > (100 * 1024 * 1024)) {
        alert("최대 파일 용량인 100MB를 초과한 파일은 제외되었습니다.");
        return false;
    } else if (obj.name.lastIndexOf('.') == -1) {
        alert("확장자가 없는 파일은 제외되었습니다.");
        return false;
    } else if (!fileTypes.includes(obj.type)) {
        alert("첨부가 불가능한 파일은 제외되었습니다.");
        return false;
    } else {
        return true;
    }
}

/* 첨부파일 삭제 */
function deleteFile(num) {
    document.querySelector("#file" + num).remove();
    filesArr[num].is_delete = true;
}

/* 폼 전송 */
function submitForm() {
    // 폼데이터 담기
    var form = document.querySelector("form");
    var formData = new FormData(form);
    for (var i = 0; i < filesArr.length; i++) {
        // 삭제되지 않은 파일만 폼데이터에 담기
        if (!filesArr[i].is_delete) {
            formData.append("attach_file", filesArr[i]);
        }
    }

    $.ajax({
        method: 'POST',
        url: '/register',
        dataType: 'json',
        data: formData,
        async: true,
        timeout: 30000,
        cache: false,
        headers: {'cache-control': 'no-cache', 'pragma': 'no-cache'},
        success: function () {
            alert("파일업로드 성공");
        },
        error: function (xhr, desc, err) {
            alert('에러가 발생 하였습니다.');
            return;
        }
    })
}