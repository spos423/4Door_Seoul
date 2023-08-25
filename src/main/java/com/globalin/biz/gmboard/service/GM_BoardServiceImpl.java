package com.globalin.biz.gmboard.service;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.biz.gmboard.GM_BoardVO;
import com.globalin.biz.gmboard.ipml.GM_BoardDAOImpl;

@Service("GM_boardService")
public class GM_BoardServiceImpl implements GM_BoardService{

	@Autowired
	private GM_BoardDAOImpl GM_boardDAO;
	
	@Override
	public void insertgmBoard(GM_BoardVO vo) {
		GM_boardDAO.insertgmBoard(vo);
	}
	
	@Override
	public void updategmBoard(GM_BoardVO vo) {
		GM_boardDAO.updategmBoard(vo);
	}
	
	@Override
	public void deletegmBoard(GM_BoardVO vo) {
		GM_boardDAO.deletegmBoard(vo);
	}
	
	@Override
	public void readcount(GM_BoardVO vo) {
		GM_boardDAO.readcount(vo);
	}
	
	@Override
	public GM_BoardVO getgmBoard(GM_BoardVO vo) {
		// 상세 게시글로 들어오면 다오의 incReadCount 호출
		
		
		return GM_boardDAO.getgmBoard(vo);
	}


	@Override
	public List<GM_BoardVO> getgmBoardList(GM_BoardVO vo) {
		// TODO Auto-generated method stub
		return GM_boardDAO.getgmBoardList(vo);
	}}
