package com.globalin.biz.gmboard.ipml;

import java.util.HashMap;
import java.util.List;

import com.globalin.biz.gmboard.GM_BoardVO;

public interface GM_BoardDAO {
     
	// 글 등록
	void insertgmBoard(GM_BoardVO vo);
	
	// 글 수정
	void updategmBoard(GM_BoardVO vo);
	
	// 글 삭제
	void deletegmBoard(GM_BoardVO vo);
	
	// 글 상제 조회
	GM_BoardVO getgmBoard(GM_BoardVO vo);
		
	// 글 목록 조회
	List<GM_BoardVO> getBoardList(HashMap map);
}
