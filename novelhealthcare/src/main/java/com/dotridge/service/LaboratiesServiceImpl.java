package com.dotridge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotridge.bean.LaboratiesBean;
import com.dotridge.dao.LaboratiesDao;
import com.dotridge.domain.Laboraties;
@Service
public class LaboratiesServiceImpl implements LaboratiesService{

	@Autowired
	private LaboratiesDao labDao;
	
	public LaboratiesBean mapDomainToBean(Laboraties labDomain) {
		// TODO Auto-generated method stub
		
		LaboratiesBean labBean=new LaboratiesBean();
		
		labBean.setLabId(labDomain.getId());
		labBean.setFirstName(labDomain.getFirstName());
		labBean.setMiddleName(labDomain.getMiddleName());
		labBean.setLastName(labDomain.getLastName());
		labBean.setEmail(labDomain.getEmail());
		labBean.setPhone(labDomain.getPhone());
		labBean.setFax(labDomain.getFax());
		labBean.setAddress(labDomain.getAddress());
		labBean.setState(labDomain.getState());
		labBean.setCity(labDomain.getCity());
		labBean.setPinCode(labDomain.getZipCode());
		labBean.setStatus(labDomain.getStatus());
		labBean.setLogo(labDomain.getLogo());
		labBean.setRegistrationDocument(labDomain.getRegistrationDocument());
		
		return labBean;
	}

	public Laboraties mapBeanToDomain(LaboratiesBean labBean) {
		// TODO Auto-generated method stub
		Laboraties labDomain=new Laboraties();
		if(labBean.getLabId()>0){
			labDomain.setId(labBean.getLabId());
		}
		labDomain.setFirstName(labBean.getFirstName());
		labDomain.setMiddleName(labBean.getMiddleName());
		labDomain.setLastName(labBean.getLastName());
		labDomain.setEmail(labBean.getEmail());
		labDomain.setPhone(labBean.getPhone());
		labDomain.setFax(labBean.getFax());
		labDomain.setAddress(labBean.getAddress());
		labDomain.setState(labBean.getState());
		labDomain.setCity(labBean.getCity());
		labDomain.setZipCode(labBean.getPinCode());
		labDomain.setStatus(labBean.getStatus());
		labDomain.setLogo(labBean.getLogo());
		labDomain.setRegistrationDocument(labBean.getRegistrationDocument());
		labDomain.setCreatedBy("Admin");
		labDomain.setModifiedBy("admin");
		Date date=new Date();
		labDomain.setCreatedDate(date);
		labDomain.setModifiedDate(date);
		
		return labDomain;
	}

	public LaboratiesBean createLaboraties(LaboratiesBean labBean) {
		// TODO Auto-generated method stub
		Laboraties beanToDomain=mapBeanToDomain(labBean);
		
		Laboraties createLab = labDao.createLab(beanToDomain);
		
		LaboratiesBean DomainToBean=mapDomainToBean(createLab);
		return DomainToBean;
	}

	public List<LaboratiesBean> getAllLaboraties() {
		// TODO Auto-generated method stub
		
		List<Laboraties> Labs = labDao.getAllLabs();
		List<LaboratiesBean> laboratiesBeans=null;
		
		if(Labs!=null && !Labs.isEmpty())
		{
			laboratiesBeans=new ArrayList<LaboratiesBean>();
			for (Laboraties labDomain : Labs) {
				LaboratiesBean mapDomainToBean = mapDomainToBean(labDomain);
				laboratiesBeans.add(mapDomainToBean);
				
				
			}return laboratiesBeans;
		}else {
			throw new RuntimeException("no Labs Available");
		}
	}

	public LaboratiesBean getLaboratiesById(int id) {
		// TODO Auto-generated method stub
		Laboraties byId = labDao.getLabById(id);
		LaboratiesBean lb=mapDomainToBean(byId);
		return lb;
	}

	public LaboratiesBean updateLaboraties(LaboratiesBean lab) {
		// TODO Auto-generated method stub
		Laboraties beanToDomain=mapBeanToDomain(lab);
		Laboraties updateLab = labDao.updateLab(beanToDomain);
		LaboratiesBean domainToBean=mapDomainToBean(updateLab);
		return domainToBean;
	}

	public boolean deleteLaboraties(int pId) {
		// TODO Auto-generated method stub
		boolean deleteLabs = labDao.deleteLabs(pId);

		return deleteLabs;
	}

	public List<LaboratiesBean> getLaboratiesByName(String lname) {
		// TODO Auto-generated method stub
		List<Laboraties> labsByName = labDao.getLabsByName(lname);
		List<LaboratiesBean> laboratiesBeans=null;
		
		if(labsByName!= null&& !labsByName.isEmpty())
		{
			laboratiesBeans=new ArrayList<LaboratiesBean>();
			for (Laboraties lab : labsByName) {
				LaboratiesBean labbean=mapDomainToBean(lab);
				laboratiesBeans.add(labbean);
				
			}
		}
		
		return laboratiesBeans;
	}

	public List<LaboratiesBean> getLaboratiesByEmail(String email) {
		// TODO Auto-generated method stub
		List<Laboraties> labDomain=labDao.getLabsByEmail(email);
		
		List<LaboratiesBean> list=null;
		
		if(labDomain!=null&& !labDomain.isEmpty())
		{
			list=new ArrayList<LaboratiesBean>();
			for (Laboraties labs : labDomain) {
			LaboratiesBean laboratiesBean=	mapDomainToBean(labs);
			list.add(laboratiesBean);
				
			}
		}
		return list;
	}

	public List<LaboratiesBean> getLaboratiesByPhone(long phone) {
		// TODO Auto-generated method stub
	List<Laboraties> labDomain=labDao.getLabsByPhone(phone);
		
		List<LaboratiesBean> list=null;
		
		if(labDomain!=null&& !labDomain.isEmpty())
		{
			list=new ArrayList<LaboratiesBean>();
			for (Laboraties labs : labDomain) {
			LaboratiesBean laboratiesBean=	mapDomainToBean(labs);
			list.add(laboratiesBean);
				
			}
		}
		return list;	
		}

	public List<LaboratiesBean> getAllLaboratiesByPagination(int currentPage, int NoOfRecPerPage) {
		// TODO Auto-generated method stub
		List<Laboraties> byPagination = labDao.getAllLabsByPagination(currentPage, NoOfRecPerPage);
		List<LaboratiesBean> laboratiesBeans=null;
		
		if(byPagination!=null && !byPagination.isEmpty())
		{
			laboratiesBeans=new ArrayList<LaboratiesBean>();
			for (Laboraties labDomain : byPagination) {
				LaboratiesBean domainToBean = mapDomainToBean(labDomain);
				laboratiesBeans.add(domainToBean);
			}
		}
		
		return laboratiesBeans;
	}

}
