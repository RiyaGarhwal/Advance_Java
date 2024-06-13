package in.co.rays.model;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
//		testSearch();
		testFindByPk();
	
	}

	private static void testFindByPk() throws Exception {
		MarksheetModel model = new MarksheetModel();

		Marksheetbean bean = model.findByPk(1);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getRollNo());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getPhysics());
			System.out.println("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		} else {
			System.out.println("no record found..!!");
		}

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


		Marksheetbean bean = new Marksheetbean();
		
		bean.setRollNo(104);
		bean.setId(4);
		bean.setName("a");
		
		MarksheetModel model = new MarksheetModel();

		List list = model.search(null,1,5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

		 bean = (Marksheetbean) it.next();

			System.out.println(bean.getId());
			System.out.println("\t" + bean.getRollNo());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getPhysics());
			System.out.println("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		}

	}

}
