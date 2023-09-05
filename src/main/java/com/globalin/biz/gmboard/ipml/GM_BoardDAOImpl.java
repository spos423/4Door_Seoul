package com.globalin.biz.gmboard.ipml;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globalin.biz.gmboard.GM_BoardVO;

@Repository("GM_boardDAO")
public class GM_BoardDAOImpl {
 
	@Autowired
	private SqlSessionTemplate mybatis;
	

	public List<GM_BoardVO> getgmBoardList(GM_BoardVO vo) {
		
		return mybatis.selectList("GM_BoardDAO.getgmBoardList", vo);
	}
	

	
     public GM_BoardVO getgmBoard(GM_BoardVO vo) {
		
		return mybatis.selectOne("GM_BoardDAO.getgmBoard", vo);
	}
	
	public void insertgmBoard(GM_BoardVO vo) {
	
		mybatis.insert("GM_BoardDAO.insertgmBoard", vo);
	}
	
	public void updategmBoard(GM_BoardVO vo) {
		
		mybatis.update("GM_BoardDAO.updategmBoard", vo);
	}
	
	public void deletegmBoard(GM_BoardVO vo) {
		
		mybatis.delete("GM_BoardDAO.deletegmBoard", vo);
	}
	
	public void readcount(GM_BoardVO vo) {
		
		mybatis.update("GM_BoardDAO.readcount", vo);
	}
	
	
}

