package in.co.rays.project_3.test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project_3.dto.BankDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.BankModelHibImp;

public class BankModelTest {

	public static void main(String[] args) throws ApplicationException, DuplicateRecordException {
	//	add();
//	update();
//	delete();
//	findbypk();\
	search();
		
		
	}

	private static void search() throws ApplicationException {
		BankDTO dto=new BankDTO();
		BankModelHibImp model=new BankModelHibImp();
		List list=model.search(dto, 0, 0);
		Iterator<BankDTO>it=list.iterator();
		while(it.hasNext()) {
			dto=(BankDTO)it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getcName());
			System.out.println(dto.getAccount());
			System.out.println(dto.getAmount());
		}
		
	}

	private static void findbypk() throws ApplicationException {
		BankModelHibImp model=new BankModelHibImp();
		BankDTO dto=model.findByPK(1);
		System.out.println(dto.getId());
		System.out.println(dto.getcName());
		System.out.println(dto.getAccount());
		System.out.println(dto.getAmount());
		
		
	}

	private static void delete() throws ApplicationException {
		BankDTO dto=new BankDTO();
		BankModelHibImp model=new BankModelHibImp();

		dto.setId(3L);
		model.delete(dto);
		System.out.println("data delete");
		


		
	}

	private static void update() throws ApplicationException, DuplicateRecordException {
		BankDTO dto=new BankDTO();
		BankModelHibImp model=new BankModelHibImp();

		dto.setId(1L);
		dto.setcName("yash");
		dto.setAccount("909090890");
		dto.setAmount("5456");
		model.update(dto);
		System.out.println("data updated");

		
	}

	private static void add() throws ApplicationException, DuplicateRecordException {
		BankDTO dto = new BankDTO();
		BankModelHibImp model = new BankModelHibImp();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		dto.setcName("raj");
		dto.setAccount("9090908978");
		dto.setAmount("500007");
		model.add(dto);
		System.out.println("data added");

	}
}
