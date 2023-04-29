package in.jo.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	static Connection conn=null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/justorganic","root","root");
			System.out.println("connected to db");
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
}
