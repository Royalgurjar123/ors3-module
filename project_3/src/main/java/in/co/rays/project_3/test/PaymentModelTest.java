package in.co.rays.project_3.test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project_3.dto.PaymentDTO;
import in.co.rays.project_3.dto.UserDTO;
import in.co.rays.project_3.model.PaymentModelHibImp;

public class PaymentModelTest {
	public static void main(String[] args) throws Exception {
		// save();
		 update();
		// delete();
		// search();
	//	findbypk();

	}

	private static void findbypk() throws Exception {
		PaymentDTO dto = new PaymentDTO();
		PaymentModelHibImp model = new PaymentModelHibImp();

		dto = model.findByPk(1L);
		System.out.println(dto.getId());
		System.out.println(dto.getName());
		System.out.println(dto.getAmount());

	}

	private static void search() throws Exception {
		PaymentDTO dto = new PaymentDTO();
		PaymentModelHibImp model = new PaymentModelHibImp();

		List list = model.search(dto, 0, 0);
		Iterator<PaymentDTO> it = list.iterator();
		while (it.hasNext()) {
			dto = it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getName());
			System.out.println(dto.getAmount());
			System.out.println(dto.getType());
		}

	}

	private static void delete() throws Exception {
		PaymentDTO dto = new PaymentDTO();
		PaymentModelHibImp model = new PaymentModelHibImp();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		dto.setId(4L);

		/*
		 * dto.setName("rajesh"); dto.setType("phone pe"); dto.setAmount(2000);
		 */ model.delete(dto);
		System.out.println("data delete");

	}

	private static void update() throws Exception {
		// TODO Auto-generated method stub
		PaymentDTO dto = new PaymentDTO();
		PaymentModelHibImp model = new PaymentModelHibImp();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		dto.setId(1L);
		dto.setName("raj");
		dto.setType("phone pe");
		dto.setAmount(2000);
		dto.setAddress("indore");
		dto.setMob("9713120656");
		model.update(dto);
		System.out.println("data update");

	}

	private static void save() throws Exception {
		PaymentDTO dto = new PaymentDTO();
		PaymentModelHibImp model = new PaymentModelHibImp();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		dto.setName("rajesh");
		dto.setType("phone pe");
		dto.setAmount(2000);
		dto.setAddress("indore");
		dto.setMob("9713120656");
		model.save(dto);
		System.out.println("data added");

	}

}
