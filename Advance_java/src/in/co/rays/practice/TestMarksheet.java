package in.co.rays.practice;

import in.co.rays.model.MarksheetModel;
import in.co.rays.model.Marksheetbean;

public class TestMarksheet {
public static void main(String[] args) throws Exception {
		
//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();
		
	}
	public static void testAdd() throws Exception {
		Marksheetbean bean = new Marksheetbean();
		bean.setId(12);
		bean.setRollNo(112);
		bean.setName("kanak");
		bean.setPhysics(90);
		bean.setChemistry(34);
		bean.setMaths(67);
		
		MarksheetModel model = new MarksheetModel();
		
		model.add(bean);
		
		}
	public static void testUpdate() throws Exception {
		Marksheetbean bean = new Marksheetbean();
		bean.setId(12);
		bean.setRollNo(112);
		bean.setName("rahul");
		bean.setPhysics(90);
		bean.setChemistry(34);
		bean.setMaths(67);
		
		MarksheetModel model = new MarksheetModel();
		
		model.update(bean);
	}
	public static void testDelete() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.delete(12);
	}
	public static void testSearch() throws Exception {

		MarksheetModel model = new MarksheetModel();

		model.search();

	}
		
	}



}
