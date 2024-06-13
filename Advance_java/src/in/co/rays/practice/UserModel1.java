package in.co.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserModel1 {
	
	public Integer nextPk() throws Exception {
		
		int pk=0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");
		String sql = "select max(id) from test";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()){
			pk = rs.getInt(1);
		}
		return pk+1;
		}
	
	
	public void add(UserBean1 bean) throws Exception {
		
		int pk = nextPk();
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");
	String sql = "Insert into test values(?,?)";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.setInt(1,pk);
	pstmt.setString(2,bean.getName());
	
	int i = pstmt.executeUpdate();
	System.out.println("Data Inserted =" + 1);
	
	}
	}


