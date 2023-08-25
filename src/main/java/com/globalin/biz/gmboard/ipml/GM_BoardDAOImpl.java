package com.globalin.biz.gmboard.ipml;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globalin.biz.frboard.FR_BoardVO;
import com.globalin.biz.gmboard.GM_BoardVO;

@Repository("GM_boardDAO")
public class GM_BoardDAOImpl {
 
	@Autowired
	private SqlSessionTemplate mybatis;
	

	public List<GM_BoardVO> getgmBoardList(GM_BoardVO vo) {
		
		System.out.println("=>Spring Mybatis로 getgmBoardList(2) 기능 처리");
	
		return mybatis.selectList("GM_BoardDAO.getgmBoardList", vo);
	}
	

	
     public GM_BoardVO getgmBoard(GM_BoardVO vo) {
		
		System.out.println("=>Spring Mybatis로 getgmBoard(2) 기능 처리");
	
		
		
		return mybatis.selectOne("GM_BoardDAO.getgmBoard", vo);
	}
	
	public void insertgmBoard(GM_BoardVO vo) {
	
		System.out.println("=>Spring Mybatis로 insertgmBoard(2) 기능 처리");
		
		mybatis.insert("GM_BoardDAO.insertgmBoard", vo);
	}
	
	public void updategmBoard(GM_BoardVO vo) {
		System.out.println("=>Spring Mybatis로 updategmBoard() 기능 처리");
		
		mybatis.update("GM_BoardDAO.updategmBoard", vo);
	}
	
	public void deletegmBoard(GM_BoardVO vo) {
		System.out.println("=>Spring Mybatis로 deletegmBoard() 기능 처리");
		
		mybatis.delete("GM_BoardDAO.deletegmBoard", vo);
	}
	
	public void readcount(GM_BoardVO vo) {
		System.out.println("=>Spring Mybatis로 deletegmBoard() 기능 처리");
		
		mybatis.update("GM_BoardDAO.readcount", vo);
	}
	
	
}

