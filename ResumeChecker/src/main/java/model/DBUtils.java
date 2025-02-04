package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public Connection makeConnection() {
		String PATH = "jdbc:mysql://localhost:3306/course_project";
		String USERNAME = "root";
		String PASSWORD = "Canh274013!";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(PATH, USERNAME, PASSWORD);
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
