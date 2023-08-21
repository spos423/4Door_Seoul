package com.globalin.biz.eboard.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.globalin.biz.eboard.E_BoardVO;

@Service
public class E_BoardServiceImpl implements E_BoardService {

	@Autowired
	private E_BoardDAO e_boardDAO;
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public E_BoardVO getBoard(E_BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E_BoardVO> getBoardList(E_BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
}