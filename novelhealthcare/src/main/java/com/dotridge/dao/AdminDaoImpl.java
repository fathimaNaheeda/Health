package com.dotridge.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dotridge.domain.Admin;
import com.dotridge.domain.Hospital;
import com.dotridge.util.SessionFactoryUtil;
@Repository
public class AdminDaoImpl implements AdminDao {

	private static final Class Hospital = null;

	public Admin createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		ses.save(admin);
		tx.commit();
		return admin;
	}

	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		Admin admin = (Admin) ses.get(Admin.class, id);
		tx.commit();
		return admin;
	}

	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		ses.update(admin);
		tx.commit();
		return admin;
	}

	public boolean deleteAdmin(int id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		Admin admin = (Admin) ses.get(Admin.class, id);
		admin.setHospital(null);
		ses.delete(admin);
		tx.commit();
		Admin admin1 = (Admin) ses.get(Admin.class, id);
		return (admin1 == null ? true : false);
	}

	public List<Admin> getAdminByName(String name) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		String hql = "from Admin a where a.firstName like:FirstName";
		Query query = ses.createQuery(hql);
		query.setParameter("FirstName", "%" + name + "%");
		List<Admin> adminList = query.list();
		return adminList;
	}

	public List<Admin> getAdminByEmail(String email) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		String hql = "from Admin a where a.email like:Email";
		Query query = ses.createQuery(hql);
		query.setParameter("Email", "%" + email + "%");
		List<Admin> adminList = query.list();
		return adminList;
	}
	
	public List<Admin> getAdminByPhone(Long phone) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		String hql = "from Admin a where a.phone=:phone";
		Query query = ses.createQuery(hql);
		query.setParameter("phone",phone );
		List<Admin> adminList = query.list();
		return adminList;	
		
	}
	
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		String hql = "from Admin";
		Query query = ses.createQuery(hql);
		List<Admin> adminList = query.list();
		return adminList;
	}

	public List<Admin> getAllAdminsByPagination(int currentPage, int NoOfRecPerPage) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		String hql = "from Admin";
		Query query = ses.createQuery(hql);
		query.setFirstResult((currentPage - 1) * NoOfRecPerPage);
		query.setMaxResults(NoOfRecPerPage);
		List<Admin> adminList = query.list();
		return adminList;
	}

	

}
