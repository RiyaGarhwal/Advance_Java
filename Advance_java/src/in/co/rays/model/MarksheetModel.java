package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {
	
	public void add(Marksheetbean bean)throws Exception{
		//com.mysql.cj.jdbc.Driver obj=new com.mysql.cj.jdbc.Driver();
		
	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

	String sql = "insert into marksheet values(?, ?, ?, ?, ?, ?)";

	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.setInt(1,bean.getId());
	pstmt.setInt(2,bean.getRollNo());
	pstmt.setString(3,bean.getName());
	pstmt.setInt(4,bean.getPhysics());
	pstmt.setInt(5,bean.getChemistry());
	pstmt.setInt(6,bean.getMaths());
	
	int i = pstmt.executeUpdate();
	System.out.println("Data Inserted =" + i);
	
	}
	public void update(Marksheetbean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		String sql = "update marksheet set roll_no = ?, name = ?, physics = ?, chemistry = ?, maths = ? where id = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		pstmt.setInt(2,bean.getRollNo());
		pstmt.setString(3,bean.getName());
		pstmt.setInt(4,bean.getPhysics());
		
		pstmt.setInt(5,bean.getChemistry());
		pstmt.setInt(6,bean.getMaths());
		pstmt.setInt(1,bean.getId());
		
		int i = pstmt.executeUpdate();
		System.out.println("Data Updated =" + i);
		
	}
	
	public void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		String sql = "delete from marksheet where id = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("Data Deleted = " + i);
	}
	
	public Marksheetbean findByPk(int id) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");
		
        String sql = "Select * from marksheet where id = ?";
        
        PreparedStatement pstmt= conn.prepareStatement(sql);
        
        pstmt.setInt(1,id);
        
        ResultSet rs = pstmt.executeQuery();
        
        Marksheetbean bean = null;
        
        while (rs.next()) {
        	
        	bean = new Marksheetbean();
        	bean.setId(rs.getInt(1));
        	bean.setRollNo(rs.getInt(2));
        	bean.setName(rs.getString(3));
        	bean.setPhysics(rs.getInt(4));
        	bean.setChemistry(rs.getInt(5));
        	bean.setMaths(rs.getInt(6));
        	
        }
        return bean;
        
        
        
        
		
	}
	
	
	
	
	public List search(Marksheetbean bean, int pageNo, int pageSize) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		StringBuffer sql = new StringBuffer ("select * from marksheet where 1=1");

		if(bean != null) {
			
			if (bean.getId()>0) {
				sql.append(" and id = " + bean.getId());
			}
			
			if (bean.getRollNo()>0) {
				sql.append(" and RollNo = " + bean.getRollNo());
			}
			
			if (bean.getName() != null && bean.getName().length()>0) {
				sql.append(" and name like '" + bean.getName()+ "%'");
			}
			
			
			
		}	
			
		if (pageSize > 0) {
			
			pageNo = (pageNo - 1)*pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
			
		}
			
		
		System.out.println("sql => " + sql);
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();
		
		List list = new ArrayList();
		

		while (rs.next()) {
			 bean = new Marksheetbean();
//			System.out.print(rs.getInt(1));
//			System.out.print("\t" + rs.getInt(2));
//			System.out.print("\t" + rs.getString(3));
//			System.out.print("\t" + rs.getInt(4));
//			System.out.print("\t" + rs.getInt(5));
//			System.out.println("\t" + rs.getInt(6));
			
			bean.setId(rs.getInt(1));
        	bean.setRollNo(rs.getInt(2));
        	
        	bean.setName(rs.getString(3));
        	bean.setPhysics(rs.getInt(4));
        	bean.setChemistry(rs.getInt(5));
        	bean.setMaths(rs.getInt(6));
        	list.add(bean);
        	
			
		}
		return list;

}
}