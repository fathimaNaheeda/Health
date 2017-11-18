package com.dotridge.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dotridge.domain.Laboraties;
import com.dotridge.util.SessionFactoryUtil;
@Repository
public class LaboratiesDaoImpl implements LaboratiesDao {

	public Laboraties createLab(Laboraties lab) {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(lab);
		transaction.commit();
		return lab;
	}

	public Laboraties getLabById(int id) {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Laboraties laboraties = (Laboraties) session.get(Laboraties.class, id);
		transaction.commit();
		return laboraties;
	}

	public Laboraties updateLab(Laboraties lab) {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(lab);
		transaction.commit();

		return lab;
	}

	public List<Laboraties> getLabsByName(String LabName) {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "from Laboraties l where l.firstName like:FirstName";
		Query query = session.createQuery(hql);
		query.setParameter("FirstName", "%" + LabName + "%");
		List<Laboraties> lablist = query.list();
		return lablist;
	}

	public List<Laboraties> getLabsByEmail(String email) {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "from Laboraties l where l.email like l:Email";
		Query query = session.createQuery(hql);
		query.setParameter("Email", "%" + email + "%");

		List<Laboraties> lablist = query.list();
		return lablist;
	}

	public List<Laboraties> getLabsByPhone(long Labphone) {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "from Laboraties l where l.phone=Phone";
		Query query = session.createQuery(hql);
		query.setParameter("Phone", "%" + Labphone + "%");

		List<Laboraties> lablist = query.list();
		return lablist;
	}

	public List<Laboraties> getAllLabs() {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "from Laboraties";
		Query query = session.createQuery(hql);
		List<Laboraties> lablist = query.list();

		return lablist;
	}

	public boolean deleteLabs(int id) {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Laboraties laboraties = (Laboraties) session.get(Laboraties.class, id);
		session.delete(laboraties);
		transaction.commit();
		Laboraties laboraties2 = (Laboraties) session.get(Laboraties.class, id);

		return (laboraties2 ==null ? true : false);
	}

	public List<Laboraties> getAllLabsByPagination(int CurrentPage, int NoOfRecPerPage) {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		String hq = "from Laboraties";
		Query query = session.createQuery(hq);
		query.setFirstResult((CurrentPage - 1) * NoOfRecPerPage);
		query.setMaxResults(NoOfRecPerPage);
		List<Laboraties> labList = query.list();


		return labList;
	}

}
