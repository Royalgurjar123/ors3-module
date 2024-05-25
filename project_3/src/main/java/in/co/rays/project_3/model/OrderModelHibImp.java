package in.co.rays.project_3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.BankDTO;
import in.co.rays.project_3.dto.OrderDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.util.HibDataSource;

public class OrderModelHibImp implements OrderModelInt{
	public long add(OrderDTO dto) {
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		session.save(dto);
		tx.commit();
		dto.getId();
		session.close();
		
		return dto.getId();
	}

	
	public void update(OrderDTO dto) {
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		session.update(dto);
		tx.commit();
		session.close();

	
		
	}

	
	public void delete(OrderDTO dto) {
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		session.delete(dto);
		tx.commit();
		session.close();
		
		
	}


	public OrderDTO findByPk(long pk) {
		Session session=HibDataSource.getSession();
		Transaction tx=session.beginTransaction();
		OrderDTO dto=(OrderDTO)session.get(OrderDTO.class, pk);
		
		return dto;
	
	}

	
	public List search(OrderDTO dto, int pageNo, int pageSize) {
		
		Session session=HibDataSource.getSession();
		Criteria criteria=session.createCriteria(OrderDTO.class);
		if(dto !=null) {
			if(dto.getOrderTyp() !=null && dto.getOrderTyp().length()>0) {
				criteria.add(Restrictions.like("orderTyp", dto.getOrderTyp()+ "%"));
				System.out.println("data ayayayyayaayayayayayyayayya ordertype");
			}
			if(dto.getsName()!=null && dto.getsName().length()>0) {
				criteria.add(Restrictions.like("sName", dto.getsName()+ "%"));
			}
			
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
	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list (0,0);
	}
	public List list(int pageNo, int pageSize) throws ApplicationException {
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(BankDTO.class);
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);

			}
			list = criteria.list();

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in  bank list");
		} finally {
			session.close();
		}

		return list;


	}


}
