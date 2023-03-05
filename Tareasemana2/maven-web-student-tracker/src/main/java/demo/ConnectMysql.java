package demo;

import java.sql.*;
import java.util.Properties;


public class ConnectMysql {
	private static String db_url = "jdbc:mysql://localhost:3306/web_student_tracker?useSSL=false";
	private static String dbUser = "webstudent";
	private static String dbPwd = "webstudent";

	public static void main(String[] args) {
		System.out.println("Connecting to Mysql...");
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties props = new Properties();
			props.setProperty("user", dbUser);
			props.setProperty("password", dbPwd);
			con = DriverManager.getConnection(db_url, props);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from Coffee");
			while (rs.next()) {
				System.out.println(rs.getString("price"));

			}
			System.out.println("Demo Over...");

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
