package com.globalin.biz.frboard.ipml;

import java.util.HashMap;
import java.util.List;

import com.globalin.biz.frboard.FR_BoardVO;

public interface FR_BoardDAO {
     
	// 글 등록
	void insertBoard(FR_BoardVO vo);
	
	// 글 수정
	void updateBoard(FR_BoardVO vo);
	
	// 글 삭제
	void deleteBoard(FR_BoardVO vo);
	
	// 글 상제 조회
	FR_BoardVO getBoard(FR_BoardVO vo);
		
	// 글 목록 조회
	List<FR_BoardVO> getBoardList(HashMap map);
}
