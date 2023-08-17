package com.globalin.biz.eboard.impl;

import java.util.List;

import com.globalin.biz.eboard.E_BoardVO;

public interface E_BoardService {
	
	// 글 등록(Create)
	void insertBoard(E_BoardVO vo); // end insert

	// 글 수정(Update)
	void updateBoard(E_BoardVO vo); // end update

	// 글 삭제(Delete)
	void deleteBoard(E_BoardVO vo); // end delete

	// 글 상세 조회
	E_BoardVO getBoard(E_BoardVO vo); // end getBoard

	// 글 목록 조회
	List<E_BoardVO> getBoardList(E_BoardVO vo); // end getBoardList
	
	
}
