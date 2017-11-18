package com.dotridge.service;

import java.util.List;

import com.dotridge.bean.AdminBean;
import com.dotridge.bean.HospitalBean;
import com.dotridge.domain.Admin;

public interface AdminService {
	public AdminBean mapDomainToBean(Admin adminDomain);

	public Admin mapBeanToDomain(AdminBean adminBean);
	
	public AdminBean createAdmin(AdminBean adminBean);

	public AdminBean getAdminById(int id);

	public AdminBean updateAdmin(AdminBean admin);

	public boolean deleteAdmin(int pId);

	public List<AdminBean> getAdminByName(String adminname);

	public List<AdminBean> getAdminByEmail(String email);

	public List<AdminBean> getAdminByPhone(long phone);

	public List<AdminBean> getAllAdmins();

	public List<AdminBean> getAllAdminsByPagination(int currentPage, int NoOfRecPerPage);

}
