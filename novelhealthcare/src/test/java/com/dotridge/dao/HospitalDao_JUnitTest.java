package com.dotridge.dao;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.dotridge.domain.Hospital;

public class HospitalDao_JUnitTest {

	private HospitalDao hospDao;

	@Before
	public void setUp() {

		hospDao = new HospitalDaoImpl();

	}

	@Test
	@Ignore
	public void testGetAllHospitals() {
		List<Hospital> hospList = hospDao.getAllHospitals();
		Assert.assertNotNull(hospList);
		Assert.assertEquals(4, hospList.size());

	}

	@Test
	@Ignore
	public void testAddHospitals() throws CloneNotSupportedException {
		Hospital hs = new Hospital();
		hs.setHospitalName("Pd");
		hs.setEmail("po@gmail.com");
		hs.setFax(7045237);
		hs.setAddress("jara");
		hs.setAddress1("ja");
		hs.setCity("Wrgl");
		hs.setPhone(99588031);
		hs.setCreatedBy("Fathima");
		hs.setModifiedBy("SuperAdmin");
		Date date = new Date();
		hs.setCreatedDate(date);
		hs.setModifiedDate(date);
		hs.setLogo("log");
		hs.setRegistrationDocument("registrationDocument");
		hs.setZipcode(50710123);
		hs.setState("Telng");
		hs.setStatus("Inactive");
	 Hospital createHospital = hospDao.createHospital(hs);
     Hospital hospital=(Hospital)hs.clone();
		Assert.assertNotNull(createHospital);

		Assert.assertNotEquals(hospital, createHospital);
		//Assert.assertNotEquals("hyd", createHospital.getCity());
	}

	@Test
	@Ignore
	public void testUpdateHospital() {
		Hospital hospitalById = hospDao.getHospitalById(7);
		hospitalById.setStatus("active");
		hospDao.updateHospital(hospitalById);
		Assert.assertEquals("active", hospitalById.getStatus());

	}

	@Test
	@Ignore
	public void testDeleteHospital() {
		boolean deleteHospital = hospDao.deleteHospital(13);
		Assert.assertNotNull(deleteHospital);

		Assert.assertTrue(deleteHospital);
	}

	@After
	public void tearDao() {
		hospDao = null;
	}
}
