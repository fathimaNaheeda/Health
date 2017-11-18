package com.dotridge;

import java.util.Date;
import java.util.List;

import com.dotridge.dao.HospitalDao;
import com.dotridge.dao.HospitalDaoImpl;
import com.dotridge.domain.Hospital;

public class HospitalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HospitalDao dao = new HospitalDaoImpl();

		Hospital hospital = new Hospital();

		hospital.setHospitalName("Asian");
		hospital.setCity("Hyderabad");
		hospital.setAddress("Punjagutta");
		hospital.setAddress1("Ameerpet");
		hospital.setState("Telangana");
		hospital.setEmail("asian@gmail.com");
		hospital.setPhone(9959823l);
		hospital.setFax(7675231);
		hospital.setZipcode(500082);
		hospital.setCreatedBy("superAdmin");
		hospital.setModifiedBy("superAdmin");
		hospital.setStatus("active");
		Date date = new Date();
		hospital.setCreatedDate(date);
		hospital.setModifiedDate(date);
		hospital.setLogo("");
		hospital.setRegistrationDocument("");
		
		Hospital hospital2 = dao.createHospital(hospital);
		System.out.println(hospital2);

		/*
		 * Hospital hospitalById = dao.getHospitalById(3); //
		 * System.out.println(hospitalById); hospitalById.setLogo("abcd");
		 * Hospital updateHospital = dao.updateHospital(hospitalById);
		 * System.out.println(updateHospital);
		 */
		/*
		 * boolean deleteHospital = dao.deleteHospital(4);
		 * if(deleteHospital=true){ System.out.println("deleted success"); }
		 * else{ System.out.println("failed to delete"); }
		 */
		/*
		 * List<Hospital> allHospitals = dao.getAllHospitals(); for (Hospital
		 * hospital2 : allHospitals) { System.out.println(hospital2);
		 * 
		 * }
		 */
		/*
		 * List<Hospital> byName = dao.getHospitalByName("apollo"); 
		 * for(Hospital hospital2 : byName) { System.out.println(hospital2); }
		 */

		/*
		 * List<Hospital> byPagianation = dao.getAllHospitalsByPagianation(2,2);
		 * for (Hospital hospital2 : byPagianation) {
		 * System.out.println(hospital2); }
		 */

	}
}
