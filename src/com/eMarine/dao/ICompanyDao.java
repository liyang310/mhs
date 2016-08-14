package com.eMarine.dao;

import java.util.List;
import com.eMarine.entity.Company;

public interface ICompanyDao {
	public void AddCompany(Company company);
	public void modifyCompany(Company company);
	public void deleteCompany(Company company);
	public void deleteCompanyById(int id);
	public Company get(int id);
	public List<Company> listCompany();
	public List<Company> listCompanyByPage(String hql, int offset, int pageSize);
	public int getAllRowCount();
}
