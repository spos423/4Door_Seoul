package com.globalin.biz.eboard.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globalin.biz.common.DateUtil;
import com.globalin.biz.common.JDBCUtil;
import com.globalin.biz.eboard.E_BoardVO;

@Repository("e_boardDAO")
public class E_BoardDAO implements E_BoardService{

	public int getArticleCount(String searchCondition, String keyword) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt=conn.prepareStatement("select count(*) from e_board where deleteyn='N' and "+searchCondition+" like '%"+keyword+"%'");
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return x;
	}//end getArticleCount()	
	
	public int getArticleCount(String search_startDate, String search_endDate, String status) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer("select count(*) from e_board where deleteyn='N' and ");
		
		int x = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			if(status == null) {
				sql.append("startdate>=? and enddate<=?");
				stmt=conn.prepareStatement(sql.toString());
				stmt.setString(1, search_startDate  + " " + "00:00:00");
				stmt.setString(2, search_endDate   + " " + "23:59:59");
			}else {
				Date date = new Date(System.currentTimeMillis());
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
				String today = sdf.format(date);
				
				if(status.equals("ongoing")) {
					sql.append("startdate<=? and enddate>=?");	
				}else if(status.equals("isscheduled")) {
					sql.append("startdate>? and enddate>?");
				}else if(status.equals("done")) {
					sql.append("startdate<? and enddate<?");
				}
				
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, today + " " + "00:00:00");
				stmt.setString(2, today + " " + "23:59:59");
			}
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return x;
	}
	
	public void insertBoard(E_BoardVO vo) {
		final String sql="insert into E_Board(NUM, TITLE, CONTENT, ZIPCODE, ADDRESS, TRAF, PRICE, STARTDATE, ENDDATE," + 
				"TEL, URI, WRITER, WRITEDATE, UPDATER, UPDATEDATE, img1_url)" + 
				"values((select nvl(max(num),0)+1 from E_Board), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
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
			stmt.setTimestamp(7, Timestamp.valueOf(vo.getStartdate().substring(0,10)+" "+vo.getStartdate().substring(11)+":00"));
			stmt.setTimestamp(8, Timestamp.valueOf(vo.getEnddate().substring(0,10)+" "+vo.getEnddate().substring(11)+":59"));
			stmt.setString(9, vo.getTel());
			stmt.setString(10, vo.getUri());
			stmt.setString(11, vo.getWriter()); 
			stmt.setTimestamp(12, DateUtil.getCurrentTime());
			stmt.setString(13, vo.getWriter());
			stmt.setTimestamp(14, DateUtil.getCurrentTime());
			stmt.setString(15, vo.getImg1_url());
			
			stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}// end insertArticle

	
	@Override 
	public void updateBoard(E_BoardVO vo, String num) {
		StringBuffer sql = new StringBuffer("update E_Board set TITLE=?, CONTENT=?, ZIPCODE=?, ADDRESS=?, "
						+ "TRAF=?, PRICE=?, STARTDATE=?, ENDDATE=?, TEL=?, URI=?, UPDATER=?, UPDATEDATE=? ");
		
		if(vo.getImg1_url() != null) {
			sql.append(", img1_url=?");
		}
		
		sql.append("where num=?");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setString(3, vo.getZipcode());
			stmt.setString(4, vo.getAddress());
			stmt.setString(5, vo.getTraf());
			stmt.setString(6, vo.getPrice());
			stmt.setTimestamp(7, Timestamp.valueOf(vo.getStartdate().substring(0,10)+" "+vo.getStartdate().substring(11)+":00"));
			stmt.setTimestamp(8, Timestamp.valueOf(vo.getEnddate().substring(0,10)+" "+vo.getEnddate().substring(11)+":59"));
			stmt.setString(9, vo.getTel());
			stmt.setString(10, vo.getUri());
			stmt.setString(11, vo.getWriter());
			stmt.setTimestamp(12, DateUtil.getCurrentTime());
			
			if(vo.getImg1_url() != null) {
				stmt.setString(13, vo.getImg1_url());
				stmt.setInt(14, Integer.parseInt(num));
			}else {
				stmt.setInt(13, Integer.parseInt(num));
			}
			
			stmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}	  
	}
	 
	@Override
	public void deleteBoard(E_BoardVO vo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		final String sql = "update E_BOARD set DELETEYN='Y' where num=?";
		
		try {
			conn = JDBCUtil.getConnection();
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getNum());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		
		
	}

	@Override
	public E_BoardVO getBoard(E_BoardVO vo, String num) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		E_BoardVO e_board = null;
		
		final String sql = "select num, title, content, zipcode, address, traf, "
						+ "PRICE, STARTDATE, ENDDATE, TEL, URI, WRITER, WRITEDATE, "
						+ "UPDATER, UPDATEDATE, READCNT, IMG1_URL "
						+ "from e_board where num=? and DELETEYN='N'";
		
		try {
			conn = JDBCUtil.getConnection();
				
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(num));
			
			rs= stmt.executeQuery();
			
			if(rs.next()) {
				e_board = new E_BoardVO();
				
				e_board.setNum(rs.getInt("num"));
				e_board.setTitle(rs.getString("title"));
				e_board.setContent(rs.getString("content"));
				e_board.setZipcode(rs.getString("zipcode"));
				e_board.setAddress(rs.getString("address"));
				e_board.setTraf(rs.getString("traf"));
				e_board.setPrice(rs.getString("price"));
				e_board.setStartdate(rs.getTimestamp("startdate").toLocalDateTime().toString());
				e_board.setEnddate(rs.getTimestamp("enddate").toLocalDateTime().toString());
				e_board.setTel(rs.getString("tel"));
				e_board.setUri(rs.getString("uri"));
				e_board.setWriter(rs.getString("writer"));
				e_board.setWritedate(rs.getTimestamp("writedate"));
				e_board.setUpdater(rs.getString("updater"));
				e_board.setUpdatedate(rs.getTimestamp("updatedate"));
				e_board.setReadcnt(rs.getInt("readcnt"));
				e_board.setImg1_url(rs.getString("IMG1_URL"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		
		return e_board;
	}

	@Override
	public List<E_BoardVO> getBoardList(int start, int end, String searchCondition, String keyword) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<E_BoardVO> e_boardList = null;
		
		final String sql = "select * from (select rownum rnum, num, title, content, startdate, enddate, writedate, readcnt, DELETEYN, img1_url "
				+ "from (select * from e_board "
				+ "where DELETEYN='N' and "+searchCondition+" like '%"+keyword+"%' order by num desc)) "
				+ "where rnum>=? and rnum<=?";
		try {
			conn = JDBCUtil.getConnection();
				
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, start);
			stmt.setInt(2, end);
			rs = stmt.executeQuery();
				
			if(rs.next()) {
				e_boardList = new ArrayList<E_BoardVO>(end-start+1);
				
				do {
					E_BoardVO vo = new E_BoardVO();
					vo.setNum(rs.getInt("num"));
					vo.setTitle(rs.getString("title"));
					vo.setContent(rs.getString("content"));
					vo.setStartdate(rs.getTimestamp("startdate").toLocalDateTime().toString());
					vo.setEnddate(rs.getTimestamp("enddate").toLocalDateTime().toString());
					vo.setWritedate(rs.getTimestamp("writedate"));
					vo.setReadcnt(rs.getInt("readcnt"));
					vo.setImg1_url(rs.getString("img1_url"));
					
					e_boardList.add(vo);
				}while(rs.next());
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		
		return e_boardList;
	}


	@SuppressWarnings("null")
	public List<E_BoardVO> getBoardList(int start, int end, 
			String search_startDate, String search_endDate, String status) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<E_BoardVO> e_boardList = null;
		
		StringBuffer sql = new StringBuffer(
		"select * from (select rownum rnum, num, title, content, startdate, enddate, readcnt, writedate, DELETEYN, img1_url " + 
		"from(select * from e_board where DELETEYN='N' "
				); 
		try {
			conn = JDBCUtil.getConnection();
			
			if(status == null) {
				sql.append("and startdate>=? and enddate<=? order by num desc)) where rnum>=? and rnum<=?");
				
				
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, search_startDate  + " " + "00:00:00");
				stmt.setString(2, search_endDate   + " " + "23:59:59");
				stmt.setInt(3, start);
				stmt.setInt(4, end);
			}else {
				Date date = new Date(System.currentTimeMillis());
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
				String today = sdf.format(date);
				
				if(status.equals("ongoing")) {
					sql.append("and startdate<=? and enddate>=? order by num desc)) where rnum>=? and rnum<=?");	
				}else if(status.equals("isscheduled")) {
					sql.append("and startdate>? and enddate>? order by num desc)) where rnum>=? and rnum<=?");
				}else if(status.equals("done")) {
					sql.append("and startdate<? and enddate<? order by num desc)) where rnum>=? and rnum<=?");
				}
					
				stmt = conn.prepareStatement(sql.toString());
				stmt.setString(1, today + " " + "00:00:00");
				stmt.setString(2, today + " " + "23:59:59");
				stmt.setInt(3, start);
				stmt.setInt(4, end);
			}
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				e_boardList = new ArrayList<E_BoardVO>(end-start+1);
				
				do {
					E_BoardVO vo = new E_BoardVO();
					vo.setNum(rs.getInt("num"));
					vo.setTitle(rs.getString("title"));
					vo.setContent(rs.getString("content"));
					vo.setStartdate(rs.getTimestamp("startdate").toLocalDateTime().toString());
					vo.setEnddate(rs.getTimestamp("enddate").toLocalDateTime().toString());
					vo.setReadcnt(rs.getInt("readcnt"));
					vo.setImg1_url(rs.getString("img1_url"));
					
					e_boardList.add(vo);
				}while(rs.next());
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return e_boardList;
	}
	
}
