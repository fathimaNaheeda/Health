package com.dotridge.dao;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dotridge.domain.Hospital;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class HospitalDaoTest {

	@Autowired
	private HospitalDao dao;
	
	@Test
	@Ignore
	public void testGetAllHospitals() {
		List<Hospital> hospList = dao.getAllHospitals();
		Assert.assertNotNull(hospList);
		Assert.assertEquals(9, hospList.size());

	}
	@Test
	@Ignore
	public void testAddHospitals() throws CloneNotSupportedException {
		Hospital hs = new Hospital();
		hs.setHospitalName("Nimra");
		hs.setEmail("Nim@gmail.com");
		hs.setFax(412359);
		hs.setAddress("Ibhrm");
		hs.setAddress1("Gntr");
		hs.setCity("Vjwd");
		hs.setPhone(991234531);
		hs.setCreatedBy("Fathima");
		hs.setModifiedBy("SuperAdmin");
		Date date = new Date();
		hs.setCreatedDate(date);
		hs.setModifiedDate(date);
		hs.setLogo("log");
		hs.setRegistrationDocument("registrationDocument");
		hs.setZipcode(5000861);
		hs.setState("Telng");
		hs.setStatus("active");
	 Hospital createHospital = dao.createHospital(hs);
     Hospital hospital=(Hospital)hs.clone();
		Assert.assertNotNull(createHospital);

		Assert.assertNotEquals(hospital, createHospital);
		//Assert.assertNotEquals("hyd", createHospital.getCity());
	}
	
	@After
	public void tearDao() {
		dao = null;
	}
	
	
	
	
}
