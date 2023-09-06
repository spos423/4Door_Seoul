package com.globalin.login.model;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.globalin.biz.common.JDBCUtil;

public class MembershipDAO {

	private static MembershipDAO instance = null;
	private MembershipDAO() {	}
	
	public static MembershipDAO getInstance() {
	
		if(instance == null) {
			synchronized(MembershipDAO.class) {
				instance= new MembershipDAO();
			}
		}
		return instance;
	}
	
	
	private Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup(
					"java:/comp/env/jdbc/myoracle");
			conn = ds.getConnection();
			
		}catch(NamingException ne) {
			System.out.println("Connection 생성 실패 !!!!");
			ne.printStackTrace();
		}catch(SQLException s) {
			System.out.println("Connection 생성 실패 !!!!");
			s.printStackTrace();
		}
		
		return conn;
	}// 여기까지 데이터베이스 연결
	
	public int getyn(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
				conn = JDBCUtil.getConnection();
			
			String sql = "select adminyn from membership where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) result= rs.getInt(1);//첫번째 인덱스			
		}catch(SQLException ss){
			ss.printStackTrace();
	    	System.out.println("sql Exception....");
	    }catch(Exception ee){
	    	System.out.println("Exception....");
	    }finally {
	    	
	    	if(rs != null) 
	    		try {rs.close();}catch(SQLException s){}
	    	
	    	if(pstmt != null) 
	    		try {pstmt.close();}catch(SQLException s){}
	    	
	    	if(conn != null) 
	    		try {conn.close();}catch(SQLException s){}
	    	
	    }
		
		return result;
	}
	
	// 아이디가 존재하는지 체크
		public boolean idCheck(String id) {
			
			boolean result = true;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = JDBCUtil.getConnection();
				
				String sql = "select * from membership where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(!rs.next()) result= false;
				
			}catch(SQLException ss){
				ss.printStackTrace();
		    	System.out.println("sql Exception....");
		    }catch(Exception ee){
		    	System.out.println("Exception....");
		    }finally {
		    	
		    	if(rs != null) 
		    		try {rs.close();}catch(SQLException s){}
		    	
		    	if(pstmt != null) 
		    		try {pstmt.close();}catch(SQLException s){}
		    	
		    	if(conn != null) 
		    		try {conn.close();}catch(SQLException s){}
		    	
		    }
			
			return result;
		}// end idCheck
		
		
		
		public boolean memberInsert(MembershipVO vo) {
			
			boolean flag = false;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				
				conn = JDBCUtil.getConnection();
				
				String sql ="insert into membership values(?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPass());
				pstmt.setString(3, vo.getName());
				pstmt.setString(4, vo.getPhone1());
				pstmt.setString(5,vo.getPhone2());
				pstmt.setString(6,vo.getPhone3());
				pstmt.setString(7, vo.getEmail());
				pstmt.setString(8, vo.getAdminyn());
		
				
			
				int count = pstmt.executeUpdate();
				if(count > 0) flag =true;
				
			}catch(SQLException ss){
		    	ss.printStackTrace();
				System.out.println("sql Exception....");
		    }catch(Exception ee){
		    	System.out.println("Exception....");
		    }finally {
		    	
		    	if(rs != null) 
		    		try {rs.close();}catch(SQLException s){}
		    	
		    	if(pstmt != null) 
		    		try {pstmt.close();}catch(SQLException s){}
		    	
		    	if(conn != null) 
		    		try {conn.close();}catch(SQLException s){}
		    	
		    }
			
			return flag;
		}// end memberInsert
		
		/*   로그인 버튼을 클릭하면 입력한 id/pass 를 테이터베이스에 저장되어 있는
		 *    id/pass와 비교해서 같으면 로그인 성공, 다르면 로그인 실패처리를 함
		 *     로그인 성공 : 1,   비밀번호 오류 : 0, 아이디가 존재하지 않을 경우 : -1
		 */
		
		public int loginCheck(String id, String pass) {
			
			
			int check = -1;// 아이디가 없음
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			 try {
				 conn = JDBCUtil.getConnection();
					
					String sql = "select pass from membership where id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						
						String dbPass = rs.getString("pass");
						if(pass.equals(dbPass)) check =1;
						else check = 0;
					}
				
			 }catch(SQLException ss){
			    	ss.printStackTrace();
					System.out.println("sql Exception....");
			    }catch(Exception ee){
			    	System.out.println("Exception....");
			    }finally {
			    	
			    	if(rs != null) 
			    		try {rs.close();}catch(SQLException s){}
			    	
			    	if(pstmt != null) 
			    		try {pstmt.close();}catch(SQLException s){}
			    	
			    	if(conn != null) 
			    		try {conn.close();}catch(SQLException s){}
			    	
			    }
			
			    return check; 
		}//loginCheck
		
		
		// 아이디를 이용하여 회원정보를 가져오는 메소드 구현
		public MembershipVO getMember(String id) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			MembershipVO vo = null;
			
			try {
				conn = JDBCUtil.getConnection();
				String sql ="select * from membership where id=?";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {// 해당 아이디에 대한 회원이 존재하면
					vo = new MembershipVO();
					
					vo.setId(rs.getString("id"));
					vo.setPass(rs.getString("pass"));
					vo.setName(rs.getString("name"));
					vo.setPhone1(rs.getString("phone1"));
					vo.setPhone2(rs.getString("phone2"));
					vo.setPhone3(rs.getString("phone3"));
					vo.setEmail(rs.getString("email"));
					vo.setAdminyn(rs.getString("adminyn"));
					
				}
				
			}catch(SQLException ss){
		    	ss.printStackTrace();
				System.out.println("sql Exception....");
		    }catch(Exception ee){
		    	System.out.println("Exception....");
		    }finally {
		    	
		    	if(rs != null) 
		    		try {rs.close();}catch(SQLException s){}
		    	
		    	if(pstmt != null) 
		    		try {pstmt.close();}catch(SQLException s){}
		    	
		    	if(conn != null) 
		    		try {conn.close();}catch(SQLException s){}
		    	
		    }
		
			return vo;
		}// end getMember
		
		private Object getString(String string) {
			// TODO Auto-generated method stub
			return null;
		}

		private Object getString1(String string) {
			// TODO Auto-generated method stub
			return null;
		}

		private Object getint(String string) {
			// TODO Auto-generated method stub
			return null;
		}

		// 정보수정 버튼을 클릭했을때 데이터베이스에 update를 수행
		// 정보를 수정하는 메소드를 처리해야함
		public void updateMember(MembershipVO vo) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = JDBCUtil.getConnection();
				
				String sql =
			"update membership set pass=?, phone1=?, phone2=?, phone3=?, "
			+ "email=? where id=?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, vo.getPass());
				pstmt.setString(2, vo.getPhone1());
				pstmt.setString(3,vo.getPhone2());
				pstmt.setString(4,vo.getPhone3());
				pstmt.setString(5, vo.getEmail());
				pstmt.setString(6, vo.getId());
				
				
				pstmt.executeUpdate();
				
			}catch(SQLException ss){
		    	ss.printStackTrace();
				System.out.println("sql Exception....");
		    }catch(Exception ee){
		    	System.out.println("Exception....");
		    }finally {
		    	
		    	if(pstmt != null) 
		    		try {pstmt.close();}catch(SQLException s){}
		    	
		    	if(conn != null) 
		    		try {conn.close();}catch(SQLException s){}
		    	
		    }
		}// end updateMember
		
		// 회원탈퇴
		// 본인이 맞으면 회원탈퇴 성공  : 1 , 본인이 맞지 않으면 회원탈퇴 실패 : 0
		// 회원이 아닌경우 -1;
		@SuppressWarnings("resource")
		public int deleteMember(String id, String pass) {
			
			
			int result = -1;// 아이디가 없음
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			 try {
				 conn = JDBCUtil.getConnection();
					
					String sql = "select pass from membership where id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						
						String dbPass = rs.getString("pass");
						if(pass.equals(dbPass)) { 
							  sql="delete from membership where id=?";
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, id);
							pstmt.executeUpdate();
							result = 1; // 회원탈퇴 성공
						}else {// 본인 확인실패 : 비밀번호 오류
							result = 0;
						}
					}
				
			 }catch(SQLException ss){
			    	ss.printStackTrace();
					System.out.println("sql Exception....");
			    }catch(Exception ee){
			    	System.out.println("Exception....");
			    }finally {
			    	
			    	if(rs != null) 
			    		try {rs.close();}catch(SQLException s){}
			    	
			    	if(pstmt != null) 
			    		try {pstmt.close();}catch(SQLException s){}
			    	
			    	if(conn != null) 
			    		try {conn.close();}catch(SQLException s){}
			    	
			    }
			
			    return result; 


		/*
		 * public String findPw(String id, String email, String name) {
		 * 
		 * String pw=null; try {
		 * 
		 * String sql ="select pass"+"where id=? and"+"email = ? and" + "name=?";
		 * PreparedStatement pstmt = conn.prepareStatement(sql); pstmt.setString(1,id);
		 * pstmt.setString(2,email); pstmt.setString(3,name);
		 * 
		 * ResultSet rs = pstmt.executeQuery();
		 * 
		 * String sql2="select pw"+"where id=? and" + "email=? and" + "name=?";0
		 * PreparedStatement pstmt2 =conn.prepareStatement(sql2);
		 * pstmt2.setString(1,id); pstmt2.setString(1,email); pstmt2.setString(1,name);
		 * 
		 * ResultSet rs2=pstmt2.executeQuery(); 0 if(rs.next()) pw=rs.getString("pw");
		 * if(rs2.next()) pw=rs2.getString()
		 * 
		 * 
		 * }
		 */
			
		}

	
}