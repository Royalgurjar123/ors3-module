package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.BankDTO;
import in.co.rays.project_3.dto.PaymentDTO;
import in.co.rays.project_3.exception.ApplicationException;

public interface PaymentModelInt {
	public long save(PaymentDTO dto);
	public void update(PaymentDTO dto);
	public void delete(PaymentDTO dto);
	public PaymentDTO findByPk(long pk);
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(PaymentDTO dto)throws ApplicationException;
	public List search(PaymentDTO dto,int pageNo,int pageSize)throws ApplicationException;


}
