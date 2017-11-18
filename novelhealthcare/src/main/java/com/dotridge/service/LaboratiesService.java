package com.dotridge.service;

import java.util.List;

import com.dotridge.bean.LaboratiesBean;
import com.dotridge.domain.Laboraties;

public interface LaboratiesService {

	public LaboratiesBean mapDomainToBean(Laboraties labDomain);

	public Laboraties mapBeanToDomain(LaboratiesBean labBean);

	public LaboratiesBean createLaboraties(LaboratiesBean labBean);

	public List<LaboratiesBean> getAllLaboraties();

	public LaboratiesBean getLaboratiesById(int id);

	public LaboratiesBean updateLaboraties(LaboratiesBean lab);

	public boolean deleteLaboraties(int pId);

	public List<LaboratiesBean> getLaboratiesByName(String lname);

	public List<LaboratiesBean> getLaboratiesByEmail(String email);

	public List<LaboratiesBean> getLaboratiesByPhone(long phone);

	public List<LaboratiesBean> getAllLaboratiesByPagination(int currentPage, int NoOfRecPerPage);
}
