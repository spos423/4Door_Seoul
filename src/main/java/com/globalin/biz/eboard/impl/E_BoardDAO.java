package com.globalin.biz.eboard.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globalin.biz.common.JDBCUtil;
import com.globalin.biz.eboard.E_BoardVO;

@Repository("E_BoardDAO")
public class E_BoardDAO implements E_BoardService{
	
	public void insertBoard(E_BoardVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql="insert into E_Board(NUM, TITLE, CONTENT, ZIPCODE, ADDRESS, TRAF, PRICE, STARTDATE, ENDDATE," + 
					"TEL, URI, WRITER, WRITEDATE, UPDATER, UPDATEDATE)" + 
					"values((select nvl(max(num),0)+1 from E_Board), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getZipcode());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getTraf());
			pstmt.setString(6, vo.getPrice());
			pstmt.setTimestamp(7, vo.getStartdate());
			pstmt.setTimestamp(8, vo.getEnddate());
			pstmt.setString(9, vo.getTel());
			pstmt.setString(10, vo.getUri());
			pstmt.setString(11, vo.getWriter());
			pstmt.setTimestamp(12, vo.getWritedate());
			pstmt.setString(13, vo.getUpdater());
			pstmt.setTimestamp(14, vo.getUpdatedate());
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) 
				try{rs.close();}catch(SQLException sqle){sqle.printStackTrace();}
			if(pstmt!=null) 
				try{pstmt.close();}catch(SQLException sqle){sqle.printStackTrace();} 
			if(conn!=null) 
				try{conn.close();}catch(SQLException sqle){sqle.printStackTrace();} 
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
