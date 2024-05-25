package in.co.rays.project_3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.BankDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

public class BankModelHibImp  implements BankModelInt{

	@Override
	public long add(BankDTO dto) throws ApplicationException, DuplicateRecordException {
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		session.save(dto);
		tx.commit();

		dto.getId();
		session.close();
		return dto.getId();

	}

	@Override
	public void delete(BankDTO dto) throws ApplicationException {
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		System.out.println("in model data records"+dto.getId());
		session.delete(dto);
		tx.commit();
		session.close();

		
	}

	@Override
	public void update(BankDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		System.out.println("dto data "+dto.getAccount()+""+dto.getAmount()+""+dto.getId());
		session.update(dto);
		tx.commit();
		
		//tx.rollback();
		session.close();

		
	}

	@Override
	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list (0,0);
	}

	@Override
	public List list(int pageNo, int pageSize) throws ApplicationException {
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(BankDTO.class);
//			if (pageSize > 0) {
//				pageNo = (pageNo - 1) * pageSize;
//				criteria.setFirstResult(pageNo);
//				criteria.setMaxResults(pageSize);
//
//			}
			list = criteria.list();

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in  bank list");
		} finally {
			session.close();
		}

		return list;


	}

	/*
	 * @Override public List list throws ApplicationException {
	 * 
	 * return list(0,0); }
	 */
	@Override
	public List search(BankDTO dto, int pageNo, int pageSize) throws ApplicationException {
		Session session =HibDataSource.getSession();
		Criteria criteria=session.createCriteria(BankDTO.class);
		if (dto != null) {
			
			
			
			if (dto.getcName() != null && dto.getcName().length() > 0) {
				criteria.add(Restrictions.like("cName", dto.getcName() + "%"));
			}
			if (dto.getAccount() != null && dto.getAccount().length() > 0) {
				criteria.add(Restrictions.like("account", dto.getAccount() + "%"));
			}
			
			
			System.out.println("model me yayayyyayayyaa");
			
			
		}
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		List list=criteria.list();
		session.close();
		return list;

	
	}

	@Override
	public BankDTO findByPK(long pk) throws ApplicationException {
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		BankDTO dto=(BankDTO)session.get(BankDTO.class, pk);
		
		return dto;


	}

	@Override
	public BankDTO fingByName(String name) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List search(BankDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}

	



}
