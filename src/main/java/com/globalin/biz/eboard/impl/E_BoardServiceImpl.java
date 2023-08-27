package com.globalin.biz.eboard.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.biz.eboard.E_BoardVO;

@Service
public class E_BoardServiceImpl implements E_BoardService {

	@Autowired
	private E_BoardDAO e_boardDAO;
	
	@Override
	public int getArticleCount(String searchCondition, String keyword) {
		return e_boardDAO.getArticleCount(searchCondition, keyword);
	}
	
	@Override
	public int getArticleCount(String search_startDate, String search_endDate, String status) {
		return e_boardDAO.getArticleCount(search_startDate, search_endDate, status);
	}
	
	@Override
	public void insertBoard(E_BoardVO vo) {
		e_boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(E_BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(E_BoardVO vo) {
		e_boardDAO.deleteBoard(vo);
		
	}

	@Override
	public E_BoardVO getBoard(E_BoardVO vo, String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E_BoardVO> getBoardList(int start, int end, String searchCondition, String keyword) {
		return e_boardDAO.getBoardList(start, end, searchCondition, keyword);
	}

	@Override
	public List<E_BoardVO> getBoardList(int start, int end, String search_startDate, String search_endDate, String status) {
		return null;
	}


}