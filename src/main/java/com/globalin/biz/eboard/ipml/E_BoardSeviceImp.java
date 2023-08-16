package com.globalin.biz.eboard.ipml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.biz.eboard.E_BoardVO;

@Service("e_boardService")
public class E_BoardSeviceImp implements E_BoardService {

	@Autowired
	private E_BoardDAOMybatis E_boardDAO;
	
	@Override
	public void insertBoard(E_BoardVO vo) {
		E_boardDAO.insertE_Board(vo);
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
