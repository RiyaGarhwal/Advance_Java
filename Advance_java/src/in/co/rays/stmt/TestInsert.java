package in.co.rays.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance","root", "root");
		Statement stmt = conn.createStatement();
		String sql = "insert into emp values(11,'Shreya',11000)";
		int i = stmt.executeUpdate(sql);
		System.out.println("Data Inserted=" + i);
	}

}
