package com.globalin.biz.eboard.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.globalin.biz.common.DateUtil;
import com.globalin.biz.common.JDBCUtil;
import com.globalin.biz.eboard.E_BoardVO;

@Repository("e_boardDAO")
public class E_BoardDAO implements E_BoardService{

	
	
	
	public void insertBoard(E_BoardVO vo) {
		String sql="insert into E_Board(NUM, TITLE, CONTENT, ZIPCODE, ADDRESS, TRAF, PRICE, STARTDATE, ENDDATE," + 
				"TEL, URI, WRITER, WRITEDATE, UPDATER, UPDATEDATE)" + 
				"values((select nvl(max(num),0)+1 from E_Board), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setString(3, vo.getZipcode());
			stmt.setString(4, vo.getAddress());
			stmt.setString(5, vo.getTraf());
			stmt.setString(6, vo.getPrice());
			stmt.setTimestamp(7, Timestamp.valueOf(vo.getStartdate().substring(0,10) +" "+ vo.getStartdate().substring(11)+":00"));
			stmt.setTimestamp(8, Timestamp.valueOf(vo.getEnddate().substring(0,10) +" "+ vo.getEnddate().substring(11)+":59"));
			stmt.setString(9, vo.getTel());
			stmt.setString(10, vo.getUri());
			stmt.setString(11, vo.getWriter()); 
			stmt.setTimestamp(12, DateUtil.getCurrentTime());
			stmt.setString(13, vo.getWriter());
			stmt.setTimestamp(14, DateUtil.getCurrentTime());
			
			
			
			stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}// end insertArticle

	@Override
	public void updateBoard(E_BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(E_BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E_BoardVO getBoard(E_BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E_BoardVO> getBoardList(E_BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
