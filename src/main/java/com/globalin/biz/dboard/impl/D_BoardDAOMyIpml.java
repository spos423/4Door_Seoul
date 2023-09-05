package com.globalin.biz.dboard.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globalin.biz.dboard.D_BoardVO;


@Repository("D_boardDAO")
public class D_BoardDAOMyIpml implements D_BoardDAO{

	
	@Autowired
	private SqlSessionTemplate mybatis;
	

	public List<D_BoardVO> getDBoardList(int d_num) {
		
		
	
		return mybatis.selectList("D_BoardDAO.getDBoardList", d_num);
	}
	

	
	
	 public D_BoardVO getDBoard(D_BoardVO vo) {
	 
	  return mybatis.selectOne("D_BoardDAO.getDBoard", vo); }
	
	
	public void insertDBoard(D_BoardVO vo) {
	
		mybatis.insert("D_BoardDAO.insertDBoard", vo);
	}
	
	public void updateDBoard(D_BoardVO vo) {
		
		mybatis.update("D_BoardDAO.updateDBoard", vo);
	}
	
	public void deleteDBoard(D_BoardVO vo) {
		
		mybatis.delete("D_BoardDAO.deleteDBoard", vo);
	}
	

	
	

}
