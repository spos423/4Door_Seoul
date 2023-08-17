package com.globalin.biz.eboard.impl;

import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import com.globalin.biz.eboard.E_BoardVO;

//@Repository("E_BoardDAO")
public class E_BoardDAOMybatis {
	
	//@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(E_BoardVO vo) {
		mybatis.insert("E_BoardDAO.insertBoard", vo);
	}
	
	
}
