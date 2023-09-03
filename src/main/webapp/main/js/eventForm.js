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