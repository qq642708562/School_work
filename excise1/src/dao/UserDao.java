package dao;

import vo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;

public class UserDao extends HttpServlet {
	public User get(String userName){
		User user = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/excise?useunicode=true&character=utf-8",
					"root","123456");
			String sql = "select * from t_user where username = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			ResultSet rs =  pst.executeQuery();
			System.out.printf(con + "---------" + pst + "------------" + rs);
			if(rs.next()){
				user = new User(rs.getString("userName"),
						rs.getString("password"),
						rs.getString("chrName"));
				System.out.printf(rs.getString("userName"));
			}
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}

}
