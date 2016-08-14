package com.eMarine.service;

import java.util.List;

import com.eMarine.entity.Company;

public interface ICompanyManage {
	public void addCompany(Company company);
	public void modifyCompany(Company company);
	public void deleteCompany(Company company);
	public void deleteCompanyById(int id);
	public Company getCompanyById(int id);
	public List<Company> listCompany();
	public PageBean<Company> listCompanyByPage(int currentPage,int pagesize);
}
