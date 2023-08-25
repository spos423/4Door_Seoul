package com.globalin.biz.frboard.ipml;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.globalin.biz.frboard.FR_BoardVO;

public class FR_BoardRowMapper implements RowMapper<FR_BoardVO> {

	@Override
	public FR_BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		FR_BoardVO frboard = new FR_BoardVO();
		frboard.setNum(rs.getInt("mum"));
		frboard.setTitle(rs.getString("title"));
		frboard.setContent(rs.getString("content"));
		frboard.setWriter(rs.getString("writer"));		
		frboard.setWriteday(rs.getDate("writeday"));
		frboard.setReadcount(rs.getInt("readcount"));
		
		return frboard;
	}
	
}