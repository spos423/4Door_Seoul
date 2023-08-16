package com.globalin.biz.eboard.ipml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.biz.eboard.E_BoardVO;

@Service("E_BoardService")
public class E_BoardServiceImpl implements E_BoardService {

	@Autowired
	private E_BoardSpring E_boardDAO;
	//private E_BoardDAOMybatis E_boardDAO;
	//private E_BoardDAO E_boardDAO;
	
	@Override
	public void insertBoard(E_BoardVO vo) {
		E_boardDAO.insertBoard(vo);
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