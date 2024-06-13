package in.co.rays.practice;

public class TestUser1 {
	
	public static void main(String[] args) throws Exception {
		testAdd();
		System.out.println("kc");

		
	}
	
	public static void testAdd() throws Exception{
		
		UserBean1 bean = new UserBean1();
		
//		bean.setId(1);
		bean.setName("Riya");
		
		UserModel1 model = new UserModel1();
		model.add(bean);
		
		
	}

}
