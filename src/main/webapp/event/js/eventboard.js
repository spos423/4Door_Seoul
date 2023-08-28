function deleteCheck(num){
	if (confirm('해당 글을 정말로 삭제하시겠습니까?')) {
	
	let f = document.createElement('form');
    
    let obj1 = document.createElement('input');
    obj1.setAttribute('type', 'hidden');
    obj1.setAttribute('name', 'num');
    obj1.setAttribute('value', num);

	f.appendChild(obj1);
    f.setAttribute('method', 'post');
    f.setAttribute('action', '/event/deleteE_Board.do');
    document.body.appendChild(f);
    alert('해당글이 정상적으로 삭제되었습니다.');      
    f.submit();
    } 
}

function goUpdate(num){
	let f = document.createElement('form');
    
    let obj1 = document.createElement('input');
    obj1.setAttribute('type', 'hidden');
    obj1.setAttribute('name', 'num');
    obj1.setAttribute('value', num);

	f.appendChild(obj1);
    f.setAttribute('method', 'post');
    f.setAttribute('action', '/event/updateE_Board.do');
    document.body.appendChild(f); 
    f.submit();
}