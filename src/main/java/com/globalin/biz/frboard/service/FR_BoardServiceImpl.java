package com.globalin.biz.frboard.service;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.biz.frboard.FR_BoardVO;
import com.globalin.biz.frboard.ipml.FR_BoardDAOImpl;

@Service("boardService")
public class FR_BoardServiceImpl implements FR_BoardService{

	@Autowired
	private FR_BoardDAOImpl FR_boardDAO;
	
	@Override
	public void insertBoard(FR_BoardVO vo) {
		FR_boardDAO.insertBoard(vo);
	}
	
	@Override
	public void updateBoard(FR_BoardVO vo) {
		FR_boardDAO.updateBoard(vo);
	}
	
	@Override
	public void deleteBoard(FR_BoardVO vo) {
		FR_boardDAO.deleteBoard(vo);
	}
	
	@Override
	public void readcount(FR_BoardVO vo) {
		FR_boardDAO.readcount(vo);
	}
	
	@Override
	public FR_BoardVO getBoard(FR_BoardVO vo) {
		// 상세 게시글로 들어오면 다오의 incReadCount 호출
		
		
		return FR_boardDAO.getBoard(vo);
	}


	@Override
	public List<FR_BoardVO> getBoardList(FR_BoardVO vo) {
		// TODO Auto-generated method stub
		return FR_boardDAO.getBoardList(vo);
	}}
