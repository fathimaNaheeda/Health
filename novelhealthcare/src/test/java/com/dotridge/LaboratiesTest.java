package com.dotridge;

import java.util.Date;


import com.dotridge.dao.LaboratiesDao;
import com.dotridge.dao.LaboratiesDaoImpl;
import com.dotridge.domain.Laboraties;

public class LaboratiesTest {

	
	public static void main(String[] args) {
		
		
		LaboratiesDao dao = new LaboratiesDaoImpl();

		Laboraties lab = new Laboraties();
		
		lab.setFirstName("labname");
		lab.setMiddleName("vmhjv");
		lab.setLastName("bkj");
		lab.setEmail("lab@gmail.com");
		lab.setPhone(789451312);
		lab.setFax(789456);
		lab.setAddress("kbj");
		lab.setState("jbhk");
		lab.setCity("jhadbs");
		lab.setZipCode(78964);
		lab.setCreatedBy("admin");
		lab.setModifiedBy("Admin");
		Date date=new Date();
		lab.setCreatedDate(date);
		lab.setModifiedDate(date);
		lab.setRegistrationDocument("reg");
		lab.setStatus("active");
		lab.setLogo("Log");
		
		Laboraties createLab = dao.createLab(lab);
		System.out.println(createLab);
	}
}
