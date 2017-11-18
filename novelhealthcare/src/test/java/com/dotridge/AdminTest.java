package com.dotridge;

import com.dotridge.dao.AdminDao;
import com.dotridge.dao.AdminDaoImpl;
import com.dotridge.dao.HospitalDao;
import com.dotridge.dao.HospitalDaoImpl;
import com.dotridge.domain.Admin;
import com.dotridge.domain.Hospital;

public class AdminTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDao dao = new AdminDaoImpl();
		Admin admin = new Admin();
		HospitalDao hsDao=new HospitalDaoImpl();
		admin.setFirstName("Fathima");
		admin.setMiddleName("Mohammad");
		admin.setLastName("Naheed");
		admin.setEmail("fathima@gmail.com");
		admin.setPassword("nannu123");
		admin.setPhone(995919329);
		admin.setProfileDocuments("file");
		admin.setStatus("active");
	Hospital hospitalById = hsDao.getHospitalById(1);
	admin.setHospital(hospitalById);
		Admin createAdmin = dao.createAdmin(admin);
		System.out.println(createAdmin);
		
		
		
		
		//Hospital byId = hsDao.getHospitalById(2);
		/*Admin adminById = dao.getAdminById(3);
		//adminById.getHospital();
		//System.out.println(adminById);
		adminById.setEmail("raj@gmail.com");
		Admin updateAdmin = dao.updateAdmin(adminById);
		System.out.println(updateAdmin);*/
		
		
		
	}

}
