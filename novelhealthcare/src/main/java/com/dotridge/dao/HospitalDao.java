package com.dotridge.dao;

import java.util.List;

import com.dotridge.domain.Hospital;

public interface HospitalDao {
	public Hospital createHospital(Hospital hospital);

	public Hospital getHospitalById(int id);

	public Hospital updateHospital(Hospital hs);

	public boolean deleteHospital(int pId);

	public List<Hospital> getHospitalByName(String hname);

	public List<Hospital> getHospitalByEmail(String email);

	public List<Hospital> getHospitalByPhone(long phone);

	public List<Hospital> getAllHospitals();

	public List<Hospital> getAllHospitalsByPagination(int currentPage, int NoOfRecPerPage);

	Hospital getOnlyHospitalByName(String hname);
}
