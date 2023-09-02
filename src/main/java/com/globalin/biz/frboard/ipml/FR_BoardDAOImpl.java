package com.globalin.biz.frboard.ipml;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globalin.biz.frboard.FR_BoardVO;

@Repository("FR_boardDAO")
public class FR_BoardDAOImpl {
 
	@Autowired
	private SqlSessionTemplate mybatis;
	

	public List<FR_BoardVO> getBoardList(FR_BoardVO vo) {
		
		System.out.println("=>Spring Mybatis로 getBoardList(2) 기능 처리");
	
		return mybatis.selectList("FR_BoardDAO.getBoardList", vo);
	}
	

	
     public FR_BoardVO getBoard(FR_BoardVO vo) {
		
		System.out.println("=>Spring Mybatis로 getBoard(2) 기능 처리");
	
		
		
		return mybatis.selectOne("FR_BoardDAO.getBoard", vo);
	}
	
	public void insertBoard(FR_BoardVO vo) {
	
		System.out.println("=>Spring Mybatis로 insertBoard(2) 기능 처리");
		
		mybatis.insert("FR_BoardDAO.insertBoard", vo);
	}
	
	public void updateBoard(FR_BoardVO vo) {
		System.out.println("=>Spring Mybatis로 updateBoard() 기능 처리");
		
		mybatis.update("FR_BoardDAO.updateBoard", vo);
	}
	
	public void deleteBoard(FR_BoardVO vo) {
		System.out.println("=>Spring Mybatis로 deleteBoard() 기능 처리");
		
		mybatis.delete("FR_BoardDAO.deleteBoard", vo);
	}
	
	public void readcount(FR_BoardVO vo) {
		System.out.println("=>Spring Mybatis로 deleteBoard() 기능 처리");
		
		mybatis.update("FR_BoardDAO.readcount", vo);
	}
	
	
}

