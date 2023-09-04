package com.globalin.biz.travel.impl;

import java.util.List;

import com.globalin.biz.travel.t_boardVO;

public interface t_boardService {

	/*
		게시글 등록 메서드
	*/
	void insertBoard(t_boardVO vo);

	/*
		게시글 삭제 메서드
	*/
	void deleteBoard(t_boardVO vo);

	/*
		게시글 수정 메서드
	*/
	void updateBoard(t_boardVO vo);

	
	
	/*
		1. 전체 게시글 수 - 검색 X
	*/
	int getBoardCount(t_boardVO vo); 

	/*
		2. 전체 게시글 수 - 검색 O (키워드 검색)
	*/
	int getBoardCount(t_boardVO vo, String searchKeyword); 

	/*
		3. 전체 게시글 수 - 검색 O (기간 검색)
	*/
	int getBoardCount(t_boardVO vo, String date_start, String date_end); 

	
	
	/*
		1. 게시글 리스트 - 검색 X
	*/
	List<t_boardVO> getBoardList(t_boardVO vo, int startRow, int endRow);
	/*
		2. 게시글 리스트 - 키워드 검색O
	*/
	List<t_boardVO> getBoardList(t_boardVO vo, String searchKeyword, int startRow, int endRow); 

	/*
		3. 게시글 리스트 - 기간 검색O(축제&행사) 
	*/
	List<t_boardVO> getBoardList(t_boardVO vo, String date_start, String date_end, int startRow, int endRow); 

	
	
	/*
		해당 게시글 조회
	*/
	t_boardVO getBoard(t_boardVO vo); 

}