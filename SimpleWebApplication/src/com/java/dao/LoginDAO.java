package com.java.dao;

import java.sql.*;

import com.java.model.User;

public class LoginDAO {
	Connection conn;
	PreparedStatement ps;
	public  LoginDAO() throws Exception {
		try {
			
			Class.forName("org.h2.Driver");
			conn=DriverManager.getConnection("jdbc:h2:~/test","sa","vishal");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isValid(User user) throws Exception {
			ps=conn.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
		}
	}

}
