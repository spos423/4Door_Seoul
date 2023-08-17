package com.globalin.biz.eboard.impl;

//import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.globalin.biz.eboard.E_BoardVO;

@Repository("E_BoardDAO")
public class E_BoardSpring {
	
	String E_BOARD_INSERT = "insert into E_Board(NUM, TITLE, CONTENT, ZIPCODE, ADDRESS, TRAF, PRICE, STARTDATE, ENDDATE," + 
			"TEL, URI, WRITER, WRITEDATE, UPDATER, UPDATEDATE)" + 
			"values((select nvl(max(num),0)+1 from E_Board), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public void insertBoard(E_BoardVO vo) {
		jdbctemplate.update(E_BOARD_INSERT, vo.getTitle(), vo.getContent(), vo.getZipcode(),
		vo.getAddress(), vo.getTraf(), vo.getPrice(), vo.getStartdate(), vo.getEnddate(), vo.getTel(),
		vo.getUri(), vo.getWriter(), vo.getWritedate(), vo.getUpdater(), vo.getUpdatedate());
	}
	
}
