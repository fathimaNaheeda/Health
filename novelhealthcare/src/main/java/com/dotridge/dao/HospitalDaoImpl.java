package com.dotridge.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dotridge.domain.Hospital;
import com.dotridge.util.SessionFactoryUtil;

@Repository
public class HospitalDaoImpl implements HospitalDao {
@Autowired
	private SessionFactory sessionFactory;

	public Hospital createHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		//SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		ses.save(hospital);
		tx.commit();
		return hospital;

	}

	public Hospital getHospitalById(int id) {
		// TODO Auto-generated method stub
		//SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		Hospital hs = (Hospital) ses.get(Hospital.class, id);
		return hs;
	}

	public Hospital updateHospital(Hospital hs) {
		// TODO Auto-generated method stub
		//SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		ses.saveOrUpdate(hs);
		tx.commit();
		return hs;
	}

	public boolean deleteHospital(int id) {
		// TODO Auto-generated method stub
		//SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		Hospital hId = (Hospital) ses.get(Hospital.class, id);
		ses.delete(hId);
		tx.commit();
		Hospital hs = (Hospital) ses.get(Hospital.class, id);
		return (hs == null ? true : false);
	}

	public List<Hospital> getAllHospitals() {
		// TODO Auto-generated method stub
		//SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		String hql = "from Hospital";
		Query query = ses.createQuery(hql);
		List<Hospital> hospitalsList = query.list();
		System.out.println("list of hosp"+hospitalsList.size());
		return hospitalsList;
	}

	public List<Hospital> getAllHospitalsByPagination(int currentPage, int NoOfRecPerPage) {
		// TODO Auto-generated method stub
	//SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		String hq = "from Hospital";
		Query query = ses.createQuery(hq);
		query.setFirstResult((currentPage - 1) * NoOfRecPerPage);
		query.setMaxResults(NoOfRecPerPage);
		List<Hospital> hospitalList = query.list();

		return hospitalList;
	}

	public List<Hospital> getHospitalByName(String hname) {
		// TODO Auto-generated method stub
		//SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		String hql = "from Hospital h where h.hospitalName like:HospitalName";
		Query query = ses.createQuery(hql);
		query.setParameter("HospitalName", "%" + hname + "%");
		List<Hospital> hospitalsList = query.list();
		return hospitalsList;
	}
	
	
	public Hospital getOnlyHospitalByName(String hname) {
		// TODO Auto-generated method stub
		//SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		String hql = "from Hospital h where h.hospitalName=:HospitalName";
		Query query = ses.createQuery(hql);
		query.setParameter("HospitalName", hname);
		Hospital hosp = (Hospital) query.uniqueResult();
		return hosp;
	}

	public List<Hospital> getHospitalByEmail(String email) {
		// TODO Auto-generated method stub

		//SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String hql = "from Hospital h where h.email like:email";
		Query query = session.createQuery(hql);
		query.setParameter("email", "%" + email + "%");
		List<Hospital> list = query.list();
		return list;
	}

	public List<Hospital> getHospitalByPhone(long phone) {
		// TODO Auto-generated method stub
		//SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String hql = "from Hospital h where h.phone=:phone";
		Query query = session.createQuery(hql);
		query.setParameter("Phone",  phone );
		List<Hospital> list = query.list();
		return list;
	}

}
