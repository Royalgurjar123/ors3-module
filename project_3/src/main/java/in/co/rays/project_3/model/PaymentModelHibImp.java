package in.co.rays.project_3.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.PaymentDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.util.HibDataSource;

public class PaymentModelHibImp implements PaymentModelInt {
	public long save(PaymentDTO dto) {
		Session session = HibDataSource.getSession();
		Transaction tx = session.beginTransaction();
		session.save(dto);

		dto.getId();
		tx.commit();
		session.close();
		return dto.getId();
	}

	public void update(PaymentDTO dto) {
		Session session = HibDataSource.getSession();
		Transaction tx = session.beginTransaction();
		session.update(dto);
		tx.commit();
		session.close();

	}

	public void delete(PaymentDTO dto) {
		Session session = HibDataSource.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(dto);
		tx.commit();
		session.close();

	}

	public PaymentDTO findByPk(long pk) {
		Session session = HibDataSource.getSession();
		PaymentDTO dto = (PaymentDTO) session.get(PaymentDTO.class, pk);
		return dto;
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	public List list(int pageNo, int pageSize) throws ApplicationException {
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(PaymentDTO.class);
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);

			}
			list = criteria.list();

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in  payment list");
		} finally {
			session.close();
		}

		return list;

	}

	@Override
	public List search(PaymentDTO dto, int pageNo, int pageSize) throws ApplicationException {

		Session session = null;

		ArrayList<PaymentDTO> list = null;
		try {

			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(PaymentDTO.class);

			if (dto != null) {
				if (dto.getId() != null) {
					criteria.add(Restrictions.like("id", dto.getId()));
				}
				if (dto.getName() != null && dto.getName().length() > 0) {
					criteria.add(Restrictions.like("name", dto.getName() + "%"));
				}

				if (dto.getType() != null && dto.getType().length() > 0) {
					criteria.add(Restrictions.like("type", dto.getType() + "%"));
				}
				if (dto.getAmount()  >0){
					criteria.add(Restrictions.eq("amount", dto.getAmount() ));
				}
				if (dto.getAddress() != null && dto.getAddress().length()>0) {
					criteria.add(Restrictions.like("address", dto.getAddress() + "%"));
				}
				if (dto.getMob() != null   && dto.getMob().length() > 0) {
					criteria.add(Restrictions.like("mob", dto.getMob() + "%"));
				}


				
				
				
				
			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
		list =	(ArrayList<PaymentDTO>) criteria.list();
		
		} catch (HibernateException e) {
			throw new ApplicationException("Exception in payment search");
		} finally {
			session.close();
		}
		return list;

	
	}

	@Override
	public List search(PaymentDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
}
