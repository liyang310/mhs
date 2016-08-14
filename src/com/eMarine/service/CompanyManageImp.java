package com.eMarine.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.eMarine.dao.ICompanyDao;
import com.eMarine.entity.Company;

public class CompanyManageImp implements ICompanyManage {
	
	@Resource  
	private ICompanyDao companyDao;
	
	public ICompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyDao(ICompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	public void addCompany(Company company) {
		companyDao.AddCompany(company);
		
	}

	@Override
	public void modifyCompany(Company company) {
		companyDao.modifyCompany(company);

	}

	@Override
	public void deleteCompany(Company company) {
		companyDao.deleteCompany(company);
	}

	@Override
	public List<Company> listCompany() {
		return companyDao.listCompany();
	}

	@Override
	public PageBean<Company> listCompanyByPage(int currentPage,int pagesize) {
		// TODO Auto-generated method stub
		PageBean<Company> page = new PageBean<Company>();
		page.setCurrentPage(currentPage);
		int allRows = companyDao.getAllRowCount();
		page.setAllRows(allRows);
		page.setTotalPage(allRows/10+1);
		String hql = "from Company";
		List<Company> companyList = companyDao.listCompanyByPage(hql, currentPage*10, page.getPagesize());
		page.setList(companyList);
		
		return page;
	}

	@Override
	public void deleteCompanyById(int id) {
		// TODO Auto-generated method stub
		companyDao.deleteCompanyById(id);
	}

	@Override
	public Company getCompanyById(int id) {
		// TODO Auto-generated method stub
		return companyDao.get(id);
	}
}
