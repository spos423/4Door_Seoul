package com.globalin.biz.travel.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.biz.travel.t_boardVO;

//@Service("t_boardService") : 비즈니스 로직을 처리하는 클래스로 "t_boardService"라는 이름의 bean객체가 생성된다.
@Service("t_boardService")
public class t_boardServiceImpl implements t_boardService {

	@Autowired
	private t_boardDAO boardDAO;
	
	public t_boardServiceImpl() {
		
	}
	
	@Override
	public void insertBoard(t_boardVO vo) {
		
		boardDAO.insertBoard(vo);
	}

	@Override
	public void deleteBoard(t_boardVO vo) {
		
		boardDAO.deleteBoard(vo);
	}

	@Override
	public void updateBoard(t_boardVO vo) {
		
		boardDAO.updateBoard(vo);
	}

	
	@Override
	public int getBoardCount(t_boardVO vo) {
		
		return boardDAO.getBoardCount(vo);
	}

	@Override
	public int getBoardCount(t_boardVO vo, String searchKeyword) {
		
		return boardDAO.getBoardCount(vo, searchKeyword);
	}

	@Override
	public int getBoardCount(t_boardVO vo, String date_start, String date_end) {
		
		return boardDAO.getBoardCount(vo, date_start, date_end);
	}

	
	@Override
	public List<t_boardVO> getBoardList(t_boardVO vo, int startRow, int endRow) {
		
		return boardDAO.getBoardList(vo, startRow, endRow);
	}

	@Override
	public List<t_boardVO> getBoardList(t_boardVO vo, String searchKeyword, int startRow, int endRow) {
		
		return boardDAO.getBoardList(vo, searchKeyword, startRow, endRow);
	}

	@Override
	public List<t_boardVO> getBoardList(t_boardVO vo, String date_start, String date_end, int startRow, int endRow) {
		
		return boardDAO.getBoardList(vo, date_start, date_end, startRow, endRow);
	}

	
	@Override
	public t_boardVO getBoard(t_boardVO vo) {
		
		return boardDAO.getBoard(vo);
	}

}
