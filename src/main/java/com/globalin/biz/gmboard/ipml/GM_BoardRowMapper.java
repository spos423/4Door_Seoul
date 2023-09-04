package com.globalin.biz.gmboard.ipml;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.globalin.biz.gmboard.GM_BoardVO;

public class GM_BoardRowMapper implements RowMapper<GM_BoardVO> {

	@Override
	public GM_BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		GM_BoardVO gmboard = new GM_BoardVO();
		gmboard.setNum(rs.getInt("mum"));
		gmboard.setTitle(rs.getString("title"));
		gmboard.setContent(rs.getString("content"));
		gmboard.setWriter(rs.getString("writer"));		
		gmboard.setWriteday(rs.getDate("writeday"));
		gmboard.setReadcount(rs.getInt("readcount"));
		gmboard.setStep(rs.getInt("step"));
		gmboard.setDepth(rs.getInt("depth"));
		
		return gmboard;
	}
	
}