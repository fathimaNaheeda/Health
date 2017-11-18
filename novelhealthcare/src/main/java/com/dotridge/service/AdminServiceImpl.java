package com.dotridge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotridge.bean.AdminBean;
import com.dotridge.bean.HospitalBean;
import com.dotridge.dao.AdminDao;
import com.dotridge.dao.HospitalDao;
import com.dotridge.domain.Admin;
import com.dotridge.domain.Hospital;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired

	private AdminDao admindao;
	
	@Autowired
	private HospitalDao hospDao;

	public AdminBean mapDomainToBean(Admin adminDomain) {
		AdminBean adminBean = new AdminBean();
		adminBean.setAdminId(adminDomain.getId());
		adminBean.setFirstName(adminDomain.getFirstName());
		adminBean.setMiddleName(adminDomain.getMiddleName());
		adminBean.setLastName(adminDomain.getLastName());
		adminBean.setEmail(adminDomain.getEmail());
		adminBean.setPassword(adminDomain.getPassword());
		adminBean.setPhone(adminDomain.getPhone());
		adminBean.setProfileDocuments(adminDomain.getProfileDocuments());
		adminBean.setStatus(adminDomain.getStatus());
		
		Hospital hospDomain = adminDomain.getHospital();
		if(hospDomain != null)
			 adminBean.setHospName(hospDomain.getHospitalName());
		
		// TODO Auto-generated method stub
		return adminBean;
	}

	public Admin mapBeanToDomain(AdminBean adminBean) {
		// TODO Auto-generated method stub
		Admin adminDomain = new Admin();
		if (adminBean.getAdminId() > 0) {
			adminDomain.setId(adminBean.getAdminId());
		}
		adminDomain.setFirstName(adminBean.getFirstName());
		adminDomain.setMiddleName(adminBean.getMiddleName());
		adminDomain.setLastName(adminBean.getLastName());
		adminDomain.setEmail(adminBean.getEmail());
		adminDomain.setPassword(adminBean.getPassword());
		adminDomain.setPhone(adminBean.getPhone());
		adminDomain.setProfileDocuments(adminBean.getProfileDocuments());
		adminDomain.setStatus(adminBean.getStatus());
		
		/*String hospName = adminBean.getHospName();
		Hospital hospDomain = hospDao.getOnlyHospitalByName(hospName);
		adminDomain.setHospital(hospDomain);*/
		adminDomain.setHospital(hospDao.getOnlyHospitalByName(adminBean.getHospName()));
		
		return adminDomain;
	}

	public AdminBean createAdmin(AdminBean adminBean) {

		Admin beanToDomain = mapBeanToDomain(adminBean);
		Admin admin = admindao.createAdmin(beanToDomain);
		AdminBean domainToBean = mapDomainToBean(admin);

		return domainToBean;
		// TODO Auto-generated method stub

	}

	public AdminBean getAdminById(int id) {
		// TODO Auto-generated method stub
		Admin admin = admindao.getAdminById(id);
		return mapDomainToBean(admin);
	}

	public AdminBean updateAdmin(AdminBean admin) {
		// TODO Auto-generated method stub
		Admin beanToDomain = mapBeanToDomain(admin);
		Admin updateAdmin = admindao.updateAdmin(beanToDomain);
		AdminBean domainToBean = mapDomainToBean(updateAdmin);
		return domainToBean;
	}

	public boolean deleteAdmin(int pId) {
		// TODO Auto-generated method stub
		boolean deleteAdmin = admindao.deleteAdmin(pId);
		return deleteAdmin;
	}

	public List<AdminBean> getAdminByName(String adminname) {
		// TODO Auto-generated method stub
		List<Admin> adminByName = admindao.getAdminByName(adminname);
		List<AdminBean> adminListBeans = null;
		if (adminByName != null && !adminByName.isEmpty()) {
			adminListBeans = new ArrayList<AdminBean>();
			for (Admin admin : adminByName) {
				AdminBean domainToBean = mapDomainToBean(admin);
				adminListBeans.add(domainToBean);
			}
		}
		return adminListBeans;
	}

	public List<AdminBean> getAdminByEmail(String email) {
		// TODO Auto-generated method stub
		List<Admin> adminByEmail = admindao.getAdminByEmail(email);
		List<AdminBean> adminListBeans = null;
		if (adminByEmail != null && !adminByEmail.isEmpty()) {
			adminListBeans = new ArrayList<AdminBean>();
			for (Admin admin : adminByEmail) {
				AdminBean domainToBean = mapDomainToBean(admin);
				adminListBeans.add(domainToBean);
			}
		}
		return adminListBeans;
	}

	public List<AdminBean> getAdminByPhone(long phone) {
		List<Admin> adminByPhone = admindao.getAdminByPhone(phone);
		List<AdminBean> adminListBeans = null;
		if (adminByPhone != null && !adminByPhone.isEmpty()) {
			adminListBeans = new ArrayList<AdminBean>();
			for (Admin admin : adminByPhone) {
				AdminBean domainToBean = mapDomainToBean(admin);
				adminListBeans.add(domainToBean);
			}
		}
		return adminListBeans;
	}

	public List<AdminBean> getAllAdmins() {
		// TODO Auto-generated method stub
		List<Admin> allAdmins = admindao.getAllAdmins();
		List<AdminBean> adminbean = null;
		if (allAdmins != null && !allAdmins.isEmpty()) {
			adminbean = new ArrayList<AdminBean>();

			for (Admin admin : allAdmins) {
				AdminBean domainToBean = mapDomainToBean(admin);
				adminbean.add(domainToBean);
			}
			return adminbean;
		} else {
			throw new RuntimeException("no hospitals available");
		}
	}

	public List<AdminBean> getAllAdminsByPagination(int currentPage, int NoOfRecPerPage) {
		// TODO Auto-generated method stub
		List<Admin> adminByPage = admindao.getAllAdminsByPagination(currentPage, NoOfRecPerPage);
		List<AdminBean> adminListByPage = null;
		if (adminByPage != null && !adminByPage.isEmpty()) {
			adminListByPage = new ArrayList<AdminBean>();
			for (Admin admin : adminByPage) {
				AdminBean adminBean = mapDomainToBean(admin);
				adminListByPage.add(adminBean);
			}
		}
		return adminListByPage;
		}

}
