package com.globalin.biz.dboard.impl;

import java.util.List;

import com.globalin.biz.dboard.D_BoardVO;

public interface D_BoardDAO {

	// 글 등록
		void insertDBoard(D_BoardVO vo);
		
		// 글 수정
		void updateDBoard(D_BoardVO vo);
		
		// 글 삭제
		void deleteDBoard(D_BoardVO vo);
		
		// 글 상제 조회
		D_BoardVO getDBoard(D_BoardVO vo);
			
		// 글 목록 조회
		List<D_BoardVO> getDBoardList(int d_num);
	
}
