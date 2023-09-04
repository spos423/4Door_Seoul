package com.globalin.biz.dboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.biz.dboard.D_BoardVO;
import com.globalin.biz.dboard.impl.D_BoardDAOMyIpml;

@Service("dboardService")
public class D_BoardServiceImpl implements D_BoardService{
	
	@Autowired
	private D_BoardDAOMyIpml D_boardDAO;
	
	@Override
	public void insertDBoard(D_BoardVO vo) {
		D_boardDAO.insertDBoard(vo);
	}
	
	@Override
	public void updateDBoard(D_BoardVO vo) {
		D_boardDAO.updateDBoard(vo);
	}
	
	@Override
	public void deleteDBoard(D_BoardVO vo) {
		D_boardDAO.deleteDBoard(vo);
	}
	
	
	@Override
	public D_BoardVO getDBoard(D_BoardVO vo) {
		// 상세 게시글로 들어오면 다오의 incReadCount 호출
		
		
		return D_boardDAO.getDBoard(vo);
	}


	
	@Override
	public List<D_BoardVO> getDBoardList(int d_num) {
		// TODO Auto-generated method stub
		return D_boardDAO.getDBoardList(d_num);
	}
}
