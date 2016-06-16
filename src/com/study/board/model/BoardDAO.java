package com.study.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//for logic but only CRUD !! ( web, android, application)
public class BoardDAO {
	
	public List selectAll(){
		
		//pure native jdbc skill....
		Connection con=null; // connection inforamtion, not try~~!!
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Board> list = new ArrayList<Board>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //driver loading...
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String id="spring";
			String pwd="spring";
			
			con=DriverManager.getConnection(url, id, pwd); //try connecting....
			if(con !=null){ // go head!!
				String sql="select * from board order by board_id desc";
				pstmt=con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				//rs --->  commons collection framework object....
				while(rs.next()){
					Board board = new Board();
					
					board.setBoard_id(rs.getInt("board_id")); // �⺻Ű
					board.setTitle(rs.getString("title")); //���� ��� 
					board.setWriter(rs.getString("writer"));
					board.setContent(rs.getString("content"));
					board.setRegdate(rs.getString("regdate"));
					board.setHit(rs.getInt("hit"));
					
					//list �� add ����!!
					list.add(board);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
		return list;
	}
	
	
	
}




