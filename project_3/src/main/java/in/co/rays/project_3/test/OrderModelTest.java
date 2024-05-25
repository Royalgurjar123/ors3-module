package in.co.rays.project_3.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.project_3.dto.OrderDTO;
import in.co.rays.project_3.model.OrderModelHibImp;

public class OrderModelTest {
	public static void main(String[] args)  throws Exception{
    //	add();
	//	update();
	//	delete();
	//	findbypk();
		search();
		
		
	}

	private static void search()throws Exception {
		OrderDTO dto=new OrderDTO();
		OrderModelHibImp model=new OrderModelHibImp();
		List list=model.search(dto, 0, 0);
		Iterator<OrderDTO>it=list.iterator();
		while(it.hasNext()) {
			dto=(OrderDTO)it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getsName());
			System.out.println(dto.getOrderTyp());
			System.out.println(dto.getQuantity());
			System.out.println(dto.getAddress());
			System.out.println(dto.getPrice());
		}

		
	}

	private static void findbypk() throws Exception{
		OrderModelHibImp model=new OrderModelHibImp();
		OrderDTO dto=model.findByPk(1L);
		System.out.println(dto.getId());
		System.out.println(dto.getsName());
		System.out.println(dto.getOrderTyp());
		System.out.println(dto.getQuantity());
		System.out.println(dto.getAddress());
		System.out.println(dto.getPrice());
		
	
		
	}

	private static void delete() throws Exception{
		OrderDTO dto=new OrderDTO();
		OrderModelHibImp model=new OrderModelHibImp();

		dto.setId(2L);
		model.delete(dto);
		System.out.println("data delete");

		
		
	}

	private static void update() throws Exception{
		OrderDTO dto=new OrderDTO();
		dto.setId(1L);
		dto.setsName("rahul");
		dto.setOrderTyp("food");
		dto.setQuantity(5);
		dto.setAddress("iNDORE");
		dto.setPrice(3400);
		OrderModelHibImp model=new OrderModelHibImp();
		model.update(dto);
		System.out.println("data UPDATED");

		
		
		
	}

	private static void add() throws Exception{
		OrderDTO dto=new OrderDTO();
		//dto.setId(1L);
		dto.setsName("rahul");
		dto.setOrderTyp("food");
		dto.setQuantity(5);
		dto.setAddress("OON");
		dto.setPrice(3400);
		OrderModelHibImp model=new OrderModelHibImp();
		model.add(dto);
		System.out.println("data added");
		
		

		

		
	}

}
