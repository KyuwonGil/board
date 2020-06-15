package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

import DTO.UsersEntity;
import DataBase.DBConnector;

class DataAcessObject {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public Queue select(String sql, String[] columns) {
		Queue<UsersEntity> attribute = new LinkedList<UsersEntity>();
		
		try {
			conn = DBConnector.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			if(columns != null)
				for(int i = 0, length = columns.length; i < length; i++)
					pstmt.setString(i+1, columns[i]);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				UsersEntity users = new UsersEntity();
				
				users.setId(rs.getString(1));
				users.setPw(rs.getString(2));
				users.setName(rs.getString(3));
				users.setBirthday(rs.getString(4));
				users.setGender(rs.getString(5));
				users.setPnum(rs.getString(6));
				users.setEmail(rs.getString(7));
				
				attribute.offer(users);
			}
			
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return attribute;
	}

	public boolean insert(String sql, String[] columns) {
		boolean result = false;
		
		try {
			conn = DBConnector.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i < columns.length; i++)
				pstmt.setString(i+1, columns[i]);
			
			if(result = pstmt.execute())
				conn.commit();
			
			close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int update(String sql, String[] columns) {
		int updateRow = 0;
		
		try {
			conn = DBConnector.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i < columns.length; i++)
				pstmt.setString(i+1, columns[i]);
			
			if((updateRow = pstmt.executeUpdate()) != 0)
				conn.commit();
			
			close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return updateRow;
	}

	public int delete(String sql, String[] columns) {
		int deleteRow = 0;
		
		try {
			conn = DBConnector.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i < columns.length; i++)
				pstmt.setString(i+1, columns[i]);

			if((deleteRow = pstmt.executeUpdate()) != 0)
				conn.commit();
			
			close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return deleteRow;
	}
	
	public void close() throws SQLException {
		if(conn != null) conn.close();
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
	}
}
