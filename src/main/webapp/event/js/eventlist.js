function frm_sub(i) {
	
	var urlParams = new URL(location.href).searchParams;
	var getStatus = urlParams.get('status');
	
	if(getStatus != null){
		if(getStatus == 'ongoing'){
			i_frm.action="/event/eventlist.do?status=ongoing&pageNum="+i;
			i_frm.submit();
		}else if(getStatus == 'isscheduled'){
			i_frm.action="/event/eventlist.do?status=isscheduled&pageNum="+i;
			i_frm.submit();
		}else if(getStatus == 'done'){
			i_frm.action="/event/eventlist.do?status=done&pageNum="+i;
			i_frm.submit();
		}
	}else{
		i_frm.action="/event/eventlist.do?pageNum="+i;
		i_frm.submit();
	}
}

function searchPeriod() {
   	
   	let start = document.searchPeriod_Form.search_startDate;
   	let end = document.searchPeriod_Form.search_endDate;
   	
   	if(start.value == ""){
   	alert('검색 기간 시작일을 입력해주세요.');
    start.focus();
    return false;
   	}
   	
   	if(end.value == ""){
   	alert('검색 기간 종료일을 입력해주세요.');
    end.focus();
    return false;
   	}
   	
    let startdate = new Date(start.value);
   	let enddate = new Date(end.value);   
    
    compare = enddate.getTime() - startdate.getTime();
        
    if(compare<0){
    alert('검색 시작일은 종료일 보다 빨라야 합니다.');
    start.focus();
    return false;
    }
}

function searchKeyword() {
	let keywordArea = document.searchKeyword_Form.keyword;
	if(keywordArea.value==""){
	alert('키워드를 입력해주세요.');
	keywordArea.focus();
	return false;
	}
}

function goBoard(num, currentPage) {
	
	let f = document.createElement('form');
    
    let obj;
    obj1 = document.createElement('input');
    obj1.setAttribute('type', 'hidden');
    obj1.setAttribute('name', 'num');
    obj1.setAttribute('value', num);
    
    obj2 = document.createElement('input');
    obj2.setAttribute('type', 'hidden');
    obj2.setAttribute('name', 'currentPage');
    obj2.setAttribute('value', currentPage);
    
    f.appendChild(obj1);
    f.appendChild(obj2);
    f.setAttribute('method', 'post');
    f.setAttribute('action', '/event/eventboard.do');
    document.body.appendChild(f);
    f.submit();

}