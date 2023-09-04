package com.globalin.biz.travel.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.globalin.biz.travel.t_boardVO;
import com.globalin.biz.common.JDBCUtil;

//@Repository("t_boardDAO") : 데이터베이스 연동을 처리하는 클래스로 해당클래스를 데이터 저장소로 선언, 
//							  "t_boardDAO"라는 이름의 bean객체가 생성된다.
@Repository("t_boardDAO")
public class t_boardDAO implements t_boardService {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	/*
		게시글 등록 메서드
	*/
	@Override
	public void insertBoard(t_boardVO vo) {
		
		System.out.println("boardDAO - 게시글 등록 메서드 실행");
		
		try {
			conn = JDBCUtil.getConnection();
			
			if(vo.getCt_u()==0) { // 상위 카테고리 0 - 축제&행사
				
				stmt = conn.prepareStatement("INSERT INTO T_BOARD(NUM, CT_U, CT_D, TITLE, CONTENT, ZIPCODE, ADDRESS, TRAFFIC, PRICE, TIME_S, TIME_E, OPEN_DAY, TEL, URI, WRITER, FILEPATH) "
						                   + "VALUES(T_BOARD_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				stmt.setInt(1, vo.getCt_u());
				stmt.setInt(2, vo.getCt_d());
				stmt.setString(3, vo.getTitle());
				stmt.setString(4, vo.getContent());
				stmt.setString(5, vo.getZipcode());
				stmt.setString(6, vo.getAddress());
				stmt.setString(7, vo.getTraffic());
				stmt.setString(8, vo.getPrice());
				stmt.setTimestamp(9, vo.getTime_s());
				stmt.setTimestamp(10, vo.getTime_e());
				stmt.setString(11, vo.getOpen_day());
				stmt.setString(12, vo.getTel());
				stmt.setString(13, vo.getUri());
				stmt.setString(14, vo.getWriter());
				stmt.setString(15, vo.getFilepath());
				
			} else if(vo.getCt_u()==1) { // 상위 카테고리 1 - 볼거리
				
				stmt = conn.prepareStatement("INSERT INTO T_BOARD(NUM, CT_U, CT_D, TITLE, CONTENT, ZIPCODE, ADDRESS, TRAFFIC, PRICE, OPEN_DAY, TEL, URI, WRITER, FILEPATH) "
						+ "VALUES(T_BOARD_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				stmt.setInt(1, vo.getCt_u());
				stmt.setInt(2, vo.getCt_d());
				stmt.setString(3, vo.getTitle());
				stmt.setString(4, vo.getContent());
				stmt.setString(5, vo.getZipcode());
				stmt.setString(6, vo.getAddress());
				stmt.setString(7, vo.getTraffic());
				stmt.setString(8, vo.getPrice());
				stmt.setString(9, vo.getOpen_day());
				stmt.setString(10, vo.getTel());
				stmt.setString(11, vo.getUri());
				stmt.setString(12, vo.getWriter());
				stmt.setString(13, vo.getFilepath());
				
			} else { // 상위 카테고리 2 - 먹거리
				
				stmt = conn.prepareStatement("INSERT INTO T_BOARD(NUM, CT_U, CT_D, TITLE, CONTENT, ZIPCODE, ADDRESS, TRAFFIC, OPEN_DAY, TEL, BESTMENU, WRITER, FILEPATH) "
						                   + "VALUES(T_BOARD_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?)");
				stmt.setInt(1, vo.getCt_u());
				stmt.setInt(2, vo.getCt_d());
				stmt.setString(3, vo.getTitle());
				stmt.setString(4, vo.getContent());
				stmt.setString(5, vo.getZipcode());
				stmt.setString(6, vo.getAddress());
				stmt.setString(7, vo.getTraffic());
				stmt.setString(8, vo.getOpen_day());
				stmt.setString(9, vo.getTel());
				stmt.setString(10, vo.getBestmenu());
				stmt.setString(11, vo.getWriter());
				stmt.setString(12, vo.getFilepath());
				
			}
			
			stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	} // end insertBoard(boardVO vo)
	
	
	/*
		게시글 삭제 메서드
	*/
	@Override
	public void deleteBoard(t_boardVO vo) {
		
		System.out.println("boardDAO - 게시글 삭제 메서드 실행");
		
		try {
			
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement("UPDATE T_BOARD SET DELETE_YN='Y', DELETE_DAY=SYSDATE WHERE NUM=?");
			stmt.setInt(1, vo.getNum());
			stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	} // end deleteBoard(int num)
	
	
	/*
		게시글 수정 메서드
	*/
	@Override
	public void updateBoard(t_boardVO vo) {
		
		System.out.println("boardDAO - 게시글 수정 메서드 실행");
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			if(vo.getFilepath().equals("")) { // 파일 이미지 수정 X
				
				if(vo.getCt_u()==0) { // 축제&행사
					System.out.println("boardDAO - 게시글 수정 메서드 - 이미지수정X, 축제&행사");
					
					stmt = conn.prepareStatement("UPDATE T_BOARD "
							                   + "SET CT_U=0, CT_D=?, TITLE=?, CONTENT=?, ZIPCODE=?, ADDRESS=?, TRAFFIC=?, PRICE=?, TIME_S=?, TIME_E=?, OPEN_DAY=?, TEL=?, URI=?, UPDATER=?, UPDATE_DAY=SYSDATE "
							                   + "WHERE NUM=?");
					stmt.setInt(1, vo.getCt_d());
					stmt.setString(2, vo.getTitle());
					stmt.setString(3, vo.getContent());
					stmt.setString(4, vo.getZipcode());
					stmt.setString(5, vo.getAddress());
					stmt.setString(6, vo.getTraffic());
					stmt.setString(7, vo.getPrice());
					stmt.setTimestamp(8, vo.getTime_s());
					stmt.setTimestamp(9, vo.getTime_e());
					stmt.setString(10, vo.getOpen_day());
					stmt.setString(11, vo.getTel());
					stmt.setString(12, vo.getUri());
					stmt.setString(13, vo.getUpdater());
					stmt.setInt(14, vo.getNum());
					
				} else if(vo.getCt_u()==1) { // 볼거리
					System.out.println("boardDAO - 게시글 수정 메서드 - 이미지수정X, 볼거리");
					
					stmt = conn.prepareStatement("UPDATE T_BOARD "
							                   + "SET CT_U=1, CT_D=?, TITLE=?, CONTENT=?, ZIPCODE=?, ADDRESS=?, TRAFFIC=?, PRICE=?, OPEN_DAY=?, TEL=?, URI=?, UPDATER=?, UPDATE_DAY=SYSDATE "
							                   + "WHERE NUM=?");
					stmt.setInt(1, vo.getCt_d());
					stmt.setString(2, vo.getTitle());
					stmt.setString(3, vo.getContent());
					stmt.setString(4, vo.getZipcode());
					stmt.setString(5, vo.getAddress());
					stmt.setString(6, vo.getTraffic());
					stmt.setString(7, vo.getPrice());
					stmt.setString(8, vo.getOpen_day());
					stmt.setString(9, vo.getTel());
					stmt.setString(10, vo.getUri());
					stmt.setString(11, vo.getUpdater());
					stmt.setInt(12, vo.getNum());
					
				} else { // 먹거리
					
					System.out.println("boardDAO - 게시글 수정 메서드 - 이미지수정X, 먹거리");
					
					stmt = conn.prepareStatement("UPDATE T_BOARD "
							                   + "SET CT_U=2, CT_D=?, TITLE=?, CONTENT=?, ZIPCODE=?, ADDRESS=?, TRAFFIC=?, OPEN_DAY=?, TEL=?, BESTMENU=?, UPDATER=?, UPDATE_DAY=SYSDATE "
							                   + "WHERE NUM=?");
					stmt.setInt(1, vo.getCt_d());
					stmt.setString(2, vo.getTitle());
					stmt.setString(3, vo.getContent());
					stmt.setString(4, vo.getZipcode());
					stmt.setString(5, vo.getAddress());
					stmt.setString(6, vo.getTraffic());
					stmt.setString(7, vo.getOpen_day());
					stmt.setString(8, vo.getTel());
					stmt.setString(9, vo.getBestmenu());
					stmt.setString(10, vo.getUpdater());
					stmt.setInt(11, vo.getNum());
				}
				
			} else { // 파일 이미지 수정 O
				
				if(vo.getCt_u()==0) { // 축제&행사
					
					System.out.println("boardDAO - 게시글 수정 메서드 - 이미지수정O, 축제&행사");
					
					stmt = conn.prepareStatement("UPDATE T_BOARD "
							                   + "SET CT_U=0, CT_D=?, TITLE=?, CONTENT=?, ZIPCODE=?, ADDRESS=?, TRAFFIC=?, PRICE=?, TIME_S=?, TIME_E=?, OPEN_DAY=?, TEL=?, URI=?, UPDATER=?, FILEPATH=?, UPDATE_DAY=SYSDATE "
							                   + "WHERE NUM=?");
					stmt.setInt(1, vo.getCt_d());
					stmt.setString(2, vo.getTitle());
					stmt.setString(3, vo.getContent());
					stmt.setString(4, vo.getZipcode());
					stmt.setString(5, vo.getAddress());
					stmt.setString(6, vo.getTraffic());
					stmt.setString(7, vo.getPrice());
					stmt.setTimestamp(8, vo.getTime_s());
					stmt.setTimestamp(9, vo.getTime_e());
					stmt.setString(10, vo.getOpen_day());
					stmt.setString(11, vo.getTel());
					stmt.setString(12, vo.getUri());
					stmt.setString(13, vo.getUpdater());
					stmt.setString(14, vo.getFilepath());
					stmt.setInt(15, vo.getNum());
					
				} else if(vo.getCt_u()==1) { // 볼거리
					
					System.out.println("boardDAO - 게시글 수정 메서드 - 이미지수정O, 볼거리");
					
					stmt = conn.prepareStatement("UPDATE T_BOARD "
							                   + "SET CT_U=1, CT_D=?, TITLE=?, CONTENT=?, ZIPCODE=?, ADDRESS=?, TRAFFIC=?, PRICE=?, OPEN_DAY=?, TEL=?, URI=?, UPDATER=?, FILEPATH=?, UPDATE_DAY=SYSDATE "
							                   + "WHERE NUM=?");
					stmt.setInt(1, vo.getCt_d());
					stmt.setString(2, vo.getTitle());
					stmt.setString(3, vo.getContent());
					stmt.setString(4, vo.getZipcode());
					stmt.setString(5, vo.getAddress());
					stmt.setString(6, vo.getTraffic());
					stmt.setString(7, vo.getPrice());
					stmt.setString(8, vo.getOpen_day());
					stmt.setString(9, vo.getTel());
					stmt.setString(10, vo.getUri());
					stmt.setString(11, vo.getUpdater());
					stmt.setString(12, vo.getFilepath());
					stmt.setInt(13, vo.getNum());
					
				} else { // 먹거리
					
					System.out.println("boardDAO - 게시글 수정 메서드 - 이미지수정O, 먹거리");
					
					stmt = conn.prepareStatement("UPDATE T_BOARD "
							                   + "SET CT_U=2, CT_D=?, TITLE=?, CONTENT=?, ZIPCODE=?, ADDRESS=?, TRAFFIC=?, OPEN_DAY=?, TEL=?, BESTMENU=?, UPDATER=?, FILEPATH=?, UPDATE_DAY=SYSDATE "
							                   + "WHERE NUM=?");
					stmt.setInt(1, vo.getCt_d());
					stmt.setString(2, vo.getTitle());
					stmt.setString(3, vo.getContent());
					stmt.setString(4, vo.getZipcode());
					stmt.setString(5, vo.getAddress());
					stmt.setString(6, vo.getTraffic());
					stmt.setString(7, vo.getOpen_day());
					stmt.setString(8, vo.getTel());
					stmt.setString(9, vo.getBestmenu());
					stmt.setString(10, vo.getUpdater());
					stmt.setString(11, vo.getFilepath());
					stmt.setInt(12, vo.getNum());
					
				}

			}
			
			stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	
	/*
		1. 전체 게시글 수 - 검색 X
	*/
	@Override
	public int getBoardCount(t_boardVO vo) {
		
		System.out.println("boardDAO - 1. 전체 게시글 수 - 검색 X 실행");
		
		int x = 0;
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			if(vo.getCt_d()!=9) {				
				stmt = conn.prepareStatement("SELECT COUNT(*) FROM T_BOARD WHERE CT_U=? AND CT_D=? AND DELETE_YN='N'");
				stmt.setInt(1, vo.getCt_u());
				stmt.setInt(2, vo.getCt_d());
			} else {
				stmt = conn.prepareStatement("SELECT COUNT(*) FROM T_BOARD WHERE CT_U=? AND DELETE_YN='N'");
				stmt.setInt(1, vo.getCt_u());
			}
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return x;
	
	} // end getBoardCount(int ct_u, int ct_d) 
	
	/*
		2. 전체 게시글 수 - 검색 O (키워드 검색)
	*/
	@Override
	public int getBoardCount(t_boardVO vo, String searchKeyword) {
		
		System.out.println("boardDAO - 2. 전체 게시글 수 - 검색 O (키워드 검색) 실행");
		
		int x = 0;
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			if(vo.getCt_d()!=9) {				
				stmt = conn.prepareStatement("SELECT COUNT(*) FROM T_BOARD WHERE CT_U=? AND CT_D=? AND DELETE_YN='N' AND "
										   + "TITLE LIKE '%" + searchKeyword + "%'");
				stmt.setInt(1, vo.getCt_u());
				stmt.setInt(2, vo.getCt_d());
			} else {
				stmt = conn.prepareStatement("SELECT COUNT(*) FROM T_BOARD WHERE CT_U=? AND DELETE_YN='N' AND "
						                   + "TITLE LIKE '%" + searchKeyword + "%'");
				stmt.setInt(1, vo.getCt_u());
			}
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return x;
		
	} // end getBoardCount(int ct_u, int ct_d, String searchKeyword)
	
	/*
		3. 전체 게시글 수 - 검색 O (기간 검색)
	*/
	@Override
	public int getBoardCount(t_boardVO vo, String date_start, String date_end) {
		
		System.out.println("boardDAO - 3. 전체 게시글 수 - 검색 O (기간 검색) 실행");
		
		int x = 0;
		
		try {
			
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement("SELECT COUNT(*) FROM T_BOARD WHERE CT_U=? AND CT_D=? AND DELETE_YN='N' AND "
					                   + "(? <= TO_CHAR(TIME_S, 'YYYY-MM-DD') OR ? >= TO_CHAR(TIME_E, 'YYYY-MM-DD'))");
			stmt.setInt(1, vo.getCt_u());
			stmt.setInt(2, vo.getCt_d());
			stmt.setString(3, date_start);
			stmt.setString(4, date_end);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return x;
		
	} // end getBoardCount(int ct_u, int ct_d, String date_start, String date_end)
	
	
	/*
		1. 게시글 리스트 - 검색 X
	*/
	@Override
	public List<t_boardVO> getBoardList(t_boardVO vo, int startRow, int endRow) {
		
		System.out.println("boardDAO - 1. 게시글 리스트 - 검색 X 실행");
		
		List<t_boardVO> boardList = null;
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			if(vo.getCt_d()!=9) {				
				if(vo.getCt_u()==0) {				
					stmt = conn.prepareStatement("SELECT * "
											   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, TIME_S, TIME_E, FILEPATH FROM "
											   + "(SELECT * FROM T_BOARD WHERE CT_U=? AND CT_D=? AND DELETE_YN='N' ORDER BY NUM DESC)) "
											   + "WHERE RNUM>=? AND RNUM<=?");
				} else {
					stmt = conn.prepareStatement("SELECT * "
											   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, FILEPATH FROM "
											   + "(SELECT * FROM T_BOARD WHERE CT_U=? AND CT_D=? AND DELETE_YN='N' ORDER BY NUM DESC)) "
											   + "WHERE RNUM>=? AND RNUM<=?");
				}
				
				stmt.setInt(1, vo.getCt_u());
				stmt.setInt(2, vo.getCt_d());
				stmt.setInt(3, startRow);
				stmt.setInt(4, endRow);
				
			} else {
				stmt = conn.prepareStatement("SELECT * "
						                   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, FILEPATH FROM "
										   + "(SELECT * FROM T_BOARD WHERE CT_U=? AND DELETE_YN='N' ORDER BY NUM DESC)) "
										   + "WHERE RNUM>=? AND RNUM<=?");
				
				stmt.setInt(1, vo.getCt_u());
				stmt.setInt(2, startRow);
				stmt.setInt(3, endRow);
			}
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				boardList = new ArrayList<t_boardVO>(endRow - startRow +1);
				
				do {
					t_boardVO t_vo = new t_boardVO();
					
					if(vo.getCt_u()==0) {
						t_vo.setNum(rs.getInt("num"));
						t_vo.setTitle(rs.getString("title"));
						t_vo.setContent(rs.getString("content"));
						t_vo.setTime_s(rs.getTimestamp("time_s"));
						t_vo.setTime_e(rs.getTimestamp("time_e"));
						t_vo.setFilepath(rs.getString("filepath"));
					} else {
						t_vo.setNum(rs.getInt("num"));
						t_vo.setTitle(rs.getString("title"));
						t_vo.setContent(rs.getString("content"));
						t_vo.setFilepath(rs.getString("filepath"));
					}
					
					boardList.add(t_vo);
					
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return boardList;
	
	} // end getBoardList(int ct_u, int ct_d, int startRow, int endRow)
	
	/*
		2. 게시글 리스트 - 키워드 검색O
	*/
	@Override
	public List<t_boardVO> getBoardList(t_boardVO vo, String searchKeyword, int startRow, int endRow){
		
		System.out.println("boardDAO - 2. 게시글 리스트 - 키워드 검색O 실행");
		
		List<t_boardVO> boardList = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			if(vo.getCt_u()==0) { // 축제&행사
				
				if(vo.getCt_d()==0) { // 진행중
					stmt = conn.prepareStatement("SELECT * "
											   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, TIME_S, TIME_E, FILEPATH FROM "
											   + "(SELECT * FROM T_BOARD WHERE CT_U=0 AND CT_D=0 AND DELETE_YN='N' "
											   + "AND TITLE LIKE '%" + searchKeyword + "%' ORDER BY NUM DESC)) "
											   + "WHERE RNUM>=? AND RNUM<=?");
				}else if(vo.getCt_d()==1) { // 진행 예정
					stmt = conn.prepareStatement("SELECT * "
											   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, TIME_S, TIME_E, FILEPATH FROM "
											   + "(SELECT * FROM T_BOARD WHERE CT_U=0 AND CT_D=1 AND DELETE_YN='N' "
											   + "AND TITLE LIKE '%" + searchKeyword + "%' ORDER BY NUM DESC)) "
											   + "WHERE RNUM>=? AND RNUM<=?");
				}else { // 진행 완료
					stmt = conn.prepareStatement("SELECT * "
											   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, TIME_S, TIME_E, FILEPATH FROM "
											   + "(SELECT * FROM T_BOARD WHERE CT_U=0 AND CT_D=2 AND DELETE_YN='N' "
											   + "AND TITLE LIKE '%" + searchKeyword + "%' ORDER BY NUM DESC)) "
											   + "WHERE RNUM>=? AND RNUM<=?");
				}
				
			}else if(vo.getCt_u()==1) {// 볼거리
				
				if(vo.getCt_d()==9) { // 전체
					stmt = conn.prepareStatement("SELECT * "
											   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, FILEPATH FROM "
											   + "(SELECT * FROM T_BOARD WHERE CT_U=1 AND DELETE_YN='N' "
											   + "AND TITLE LIKE '%" + searchKeyword + "%' ORDER BY NUM DESC)) "
											   + "WHERE RNUM>=? AND RNUM<=?");
				} else if(vo.getCt_d()==3) { // 명소
					stmt = conn.prepareStatement("SELECT * "
											   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, FILEPATH FROM "
											   + "(SELECT * FROM T_BOARD WHERE CT_U=1 AND CT_D=3 AND DELETE_YN='N' "
											   + "AND TITLE LIKE '%" + searchKeyword + "%' ORDER BY NUM DESC)) "
											   + "WHERE RNUM>=? AND RNUM<=?");
				} else if(vo.getCt_d()==4) { // 자연&경관
					stmt = conn.prepareStatement("SELECT * "
											   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, FILEPATH FROM "
											   + "(SELECT * FROM T_BOARD WHERE CT_U=1 AND CT_D=4 AND DELETE_YN='N' "
											   + "AND TITLE LIKE '%" + searchKeyword + "%' ORDER BY NUM DESC)) "
											   + "WHERE RNUM>=? AND RNUM<=?");
				} else { // 엔터테인먼트
					stmt = conn.prepareStatement("SELECT * "
											   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, FILEPATH FROM "
											   + "(SELECT * FROM T_BOARD WHERE CT_U=1 AND CT_D=5 AND DELETE_YN='N' "
											   + "AND TITLE LIKE '%" + searchKeyword + "%' ORDER BY NUM DESC)) "
											   + "WHERE RNUM>=? AND RNUM<=?");
				}
				
			// 먹거리
			}else {				
				
				if(vo.getCt_d()==9) { // 전체			
					stmt = conn.prepareStatement("SELECT * "
											   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, FILEPATH FROM "
											   + "(SELECT * FROM T_BOARD WHERE CT_U=2 AND DELETE_YN='N' "
											   + "AND TITLE LIKE '%" + searchKeyword + "%' ORDER BY NUM DESC)) "
											   + "WHERE RNUM>=? AND RNUM<=?");
				} else if(vo.getCt_d()==6) { // 카페&디저트
					stmt = conn.prepareStatement("SELECT * "
											   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, FILEPATH FROM "
											   + "(SELECT * FROM T_BOARD WHERE CT_U=2 AND CT_D=6 AND DELETE_YN='N' "
											   + "AND TITLE LIKE '%" + searchKeyword + "%' ORDER BY NUM DESC)) "
											   + "WHERE RNUM>=? AND RNUM<=?");
				} else if(vo.getCt_d()==7) { // 식사
					stmt = conn.prepareStatement("SELECT * "
											   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, FILEPATH FROM "
											   + "(SELECT * FROM T_BOARD WHERE CT_U=2 AND CT_D=7 AND DELETE_YN='N' "
											   + "AND TITLE LIKE '%" + searchKeyword + "%' ORDER BY NUM DESC)) "
											   + "WHERE RNUM>=? AND RNUM<=?");
				} else { // 주점
					stmt = conn.prepareStatement("SELECT * "
											   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, FILEPATH FROM "
											   + "(SELECT * FROM T_BOARD WHERE CT_U=2 AND CT_D=8 AND DELETE_YN='N' "
											   + "AND TITLE LIKE '%" + searchKeyword + "%' ORDER BY NUM DESC)) "
											   + "WHERE RNUM>=? AND RNUM<=?");
				}
				
			}
			
			stmt.setInt(1, startRow);
			stmt.setInt(2, endRow);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				boardList = new ArrayList<t_boardVO>(endRow - startRow + 1);
				
				do {
					t_boardVO t_vo = new t_boardVO();
					
					if(vo.getCt_u()==0) {
						t_vo.setNum(rs.getInt("num"));
						t_vo.setTitle(rs.getString("title"));
						t_vo.setContent(rs.getString("content"));
						t_vo.setTime_s(rs.getTimestamp("time_s"));
						t_vo.setTime_e(rs.getTimestamp("time_e"));
						t_vo.setFilepath(rs.getString("filepath"));
					}else {
						t_vo.setNum(rs.getInt("num"));
						t_vo.setTitle(rs.getString("title"));
						t_vo.setContent(rs.getString("content"));
						t_vo.setFilepath(rs.getString("filepath"));
					}
					
					boardList.add(t_vo);
				}while(rs.next());
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return boardList;
		
	} // end getBoardList(int ct_u, int ct_d, String searchKeyword, int startRow, int endRow)
	
	
	/*
		3. 게시글 리스트 - 기간 검색O(축제&행사) 
	*/
	@Override
	public List<t_boardVO> getBoardList(t_boardVO vo, String date_start, String date_end, int startRow, int endRow) {
		
		System.out.println("boardDAO - 3. 게시글 리스트 - 기간 검색O(축제&행사) 실행");
		
		List<t_boardVO> boardList = null;
		
		try {
			conn = JDBCUtil.getConnection();
			if(vo.getCt_d()==0) {
				stmt = conn.prepareStatement("SELECT * "
						                   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, TIME_S, TIME_E, FILEPATH FROM "
						                   + "(SELECT * FROM T_BOARD WHERE CT_U=0 AND CT_D=0 AND DELETE_YN='N' AND "
						                   + "(? <= TO_CHAR(TIME_S, 'YYYY-MM-DD') OR ? >= TO_CHAR(TIME_E, 'YYYY-MM-DD')) "
						                   + "ORDER BY NUM DESC)) "
						                   + "WHERE RNUM>=? AND RNUM<=?");
			} else if(vo.getCt_d()==1) {
				stmt = conn.prepareStatement("SELECT * "
						                   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, TIME_S, TIME_E, FILEPATH FROM "
						                   + "(SELECT * FROM T_BOARD WHERE CT_U=0 AND CT_D=1 AND DELETE_YN='N' AND "
						                   + "(? <= TO_CHAR(TIME_S, 'YYYY-MM-DD') OR ? >= TO_CHAR(TIME_E, 'YYYY-MM-DD')) "
						                   + "ORDER BY NUM DESC)) "
						                   + "WHERE RNUM>=? AND RNUM<=?");
			} else {
				stmt = conn.prepareStatement("SELECT * "
						                   + "FROM (SELECT ROWNUM RNUM, NUM, TITLE, CONTENT, TIME_S, TIME_E, FILEPATH FROM "
						                   + "(SELECT * FROM T_BOARD WHERE CT_U=0 AND CT_D=2 AND DELETE_YN='N' AND "
						                   + "(? <= TO_CHAR(TIME_S, 'YYYY-MM-DD') OR ? >= TO_CHAR(TIME_E, 'YYYY-MM-DD')) "
						                   + "ORDER BY NUM DESC)) "
						                   + "WHERE RNUM>=? AND RNUM<=?");
			}
			
			stmt.setString(1, date_start);
			stmt.setString(2, date_end);
			stmt.setInt(3, startRow);
			stmt.setInt(4, endRow);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {				
				boardList = new ArrayList<t_boardVO>(endRow - startRow + 1);
				
				do {
					t_boardVO t_vo = new t_boardVO();
					t_vo.setNum(rs.getInt("num"));
					t_vo.setTitle(rs.getString("title"));
					t_vo.setContent(rs.getString("content"));
					t_vo.setTime_s(rs.getTimestamp("time_s"));
					t_vo.setTime_e(rs.getTimestamp("time_e"));
					t_vo.setFilepath(rs.getString("filepath"));
					boardList.add(t_vo);
					
				}while(rs.next());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return boardList;
		
	} // end getBoardList(int ct_d, String date_start, String date_end, int startRow, int endRow)
	
	
	/*
		해당 게시글 조회
	*/
	@Override
	public t_boardVO getBoard(t_boardVO vo) {
		
		System.out.println("boardDAO - 해당 게시글 조회 실행");
		
		t_boardVO board = null;
		
		try {
			
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM T_BOARD WHERE NUM=?");
			stmt.setInt(1, vo.getNum());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				board = new t_boardVO();
				board.setCt_u(rs.getInt("ct_u"));
				board.setCt_d(rs.getInt("ct_d"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setZipcode(rs.getString("zipcode"));
				board.setAddress(rs.getString("address"));
				board.setTraffic(rs.getString("traffic"));
				board.setPrice(rs.getString("price"));
				board.setTime_s(rs.getTimestamp("time_s"));
				board.setTime_e(rs.getTimestamp("time_e"));
				board.setOpen_day(rs.getString("open_day"));
				board.setTel(rs.getString("tel"));
				board.setUri(rs.getString("uri"));
				board.setBestmenu(rs.getString("bestmenu"));
				board.setWriter(rs.getString("writer"));
				board.setWrite_day(rs.getDate("write_day"));
				board.setUpdate_day(rs.getDate("update_day"));
				board.setFilepath(rs.getString("filepath"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return board;
		
	} // end getBoard(int num)
	
	
}
