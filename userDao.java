package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.entity.userEntity;

public class userDao {
	GetDBConnection getDB = new GetDBConnection();
	
	Connection conn = getDB.getDBConnection();

	PreparedStatement ps = null;

	ResultSet rs = null;
	
	
	public userEntity findByuserName(String userName,String passWord){
		
		String sql = "select * from user where userName='"+userName+"' and passWord = '"+passWord+"'";
		userEntity user=new userEntity();
		try {
			ps=conn.prepareStatement(sql);

			rs=ps.executeQuery();
			while (rs.next()){
				
				user.setUserName(rs.getString("userName"));
				user.setPassWord(rs.getString("passWord"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}
	
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		userDao user = new userDao();
//		userEntity s=user.findByuserName("111", "111");
//		System.err.println(s);
//		if(s.getUserName()!=null) {
//			System.err.println("登陆成功");
//		}
//		else{
//		System.err.println("登陆失败");
//		}	
//	}
	
	
	
	public void Zhuce(userEntity user){
		String sql="insert into user values(?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getUserName());
			ps.setString(3,user.getPassWord());

			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				if (ps!=null)
				ps.close();
				if (conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		
	}
//	public static void main(String[] args) {
//		userDao user = new userDao();
//		userEntity users = new userEntity();
//		users.setUserId("4");
//		users.setUserName("444");
//		users.setPassWord("444");
//		user.Zhuce(users);
//		}
//		
		
}
