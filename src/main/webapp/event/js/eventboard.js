function deleteCheck(){
	


	if (confirm('해당 글을 정말로 삭제하시겠습니까?')) {
    location.href="/event/deleteE_Board.do?num=${e_board.num}";   
    alert('해당글이 정상적으로 삭제되었습니다.');      
    return false;   
    } 

}
