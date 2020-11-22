package dao;

import vo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

public class UserDao extends HttpServlet {
	private static final String URL = "jdbc:mysql://localhost:3306/excise";
	private static final String userName1 = "root";
	private static final String pwd = "123";

	public User get(String userName) {
		User user = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, userName1, pwd);
			String sql = "select * from t_user where username = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("userName"),
						rs.getString("password"), rs.getString("chrName"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public Boolean add(String userName, String password, String charName) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, userName1, pwd);
			String sql = "insert into t_user value(?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, password);
			pst.setString(3, charName);

			int result = pst.executeUpdate();
			if (result > 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<User> getAll(){
		ArrayList<User> list = new ArrayList<User>();
		User user = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, userName1, pwd);
			String sql = "select * from t_user";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString("userName"),
				  rs.getString("password"),rs.getString("chrName"));
				list.add(user);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
