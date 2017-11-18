package com.dotridge.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:novelhealthcare-servlet.xml","classpath:applicationContext.xml"})
public class HospitalControllerTest {

	@Autowired
	private HospitalController hospController;
	Model model;
	@Before
	public void setUp(){
    model=new BindingAwareModelMap();
	}
	
	@Test
	@Ignore
	public void testGetAllHospitals(){
		
		
		String viewHospitals=hospController.viewAllHospitals(model);
		Assert.assertNotNull(viewHospitals);
		Assert.assertEquals("getHospitalBoard", viewHospitals);
		
	}
	@Before
	public void setup(){
		model=new BindingAwareModelMap();
	}
	
	
}
