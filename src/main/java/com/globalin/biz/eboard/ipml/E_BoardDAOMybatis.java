package com.globalin.biz.eboard.ipml;

import org.mybatis.spring.SqlSessionTemplate;

import com.globalin.biz.eboard.E_BoardVO;

public class E_BoardDAOMybatis {

	private SqlSessionTemplate mybatis;
	
	public void insertE_Board(E_BoardVO vo) {
		mybatis.insert("", vo);
	}
	
	
}
