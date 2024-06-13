package in.co.rays.user;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.model.MarksheetModel;
import in.co.rays.model.Marksheetbean;

public class TestUser {
	
	public static void main(String[] args) throws Exception {
		testAdd();
//		testSearch();
//		testUpdate();
	}
    
	public static void testAdd() throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
		
		UserBean bean = new UserBean();
//		bean.setId(2);
		bean.setFirstName("riya");
		bean.setLastName("garhwal");
		bean.setLoginId("");
		
		
		bean.setPassword("xyz");
		bean.setDob(sdf.parse("13-04-24"));
		bean.setAddress("Indore");
		
		UserModel model = new UserModel();
		
		model.add(bean);
	}
	
	public static void testSearch() throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		UserBean bean = new UserBean();
		
		bean.setId(1);
		bean.setFirstName("");
		bean.setLastName("5");
		bean.setDob(sdf.parse("02-11-2024"));
		
		UserModel model = new UserModel();
		
		List list = model.search(bean,1,5);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			
			bean = (UserBean) it.next();
			
			System.out.println(bean.getId());
			System.out.println("\t\t" + bean.getFirstName());
			System.out.println("\t\t" + bean.getLastName());
			System.out.println("\t\t" + bean.getLoginId());
			System.out.println("\t\t" + bean.getPassword());
			System.out.println("\t\t" + bean.getDob());
			System.out.println("\t\t" + bean.getAddress());
			
		}
	}
	
	public static void testUpdate() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat ("dd-MM-yyyy");
		
	UserBean bean = new UserBean();		
	
	    bean.setId(1);
	    bean.setFirstName("Riya");
	    bean.setLastName("Garhwal");
	    bean.setLoginId("kajukatli");
	    bean.setPassword("8790");
	    bean.setDob(sdf.parse("06-12-1995"));
	
		UserModel model = new UserModel();

		model.update(bean);
	}

}
