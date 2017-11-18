package com.dotridge.dao;

import java.util.List;

import com.dotridge.domain.Laboraties;

public interface LaboratiesDao {

	public Laboraties createLab(Laboraties lab);

	public Laboraties getLabById(int id);

	public Laboraties updateLab(Laboraties lab);

	public List<Laboraties> getLabsByName(String LabName);

	public List<Laboraties> getLabsByPhone(long Labphone);

	public List<Laboraties> getAllLabs();

	public boolean deleteLabs(int id);

	public List<Laboraties> getLabsByEmail(String email);

	public List<Laboraties> getAllLabsByPagination(int CurrentPage, int NoOfRecPerPage);
}
