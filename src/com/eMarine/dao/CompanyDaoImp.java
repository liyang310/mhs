package com.eMarine.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eMarine.entity.Company;

public class CompanyDaoImp implements ICompanyDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void AddCompany(Company company) {
		getSession().save(company);
	}

	@Override
	public void modifyCompany(Company company) {
		getSession().update(company);
	}

	@Override
	public void deleteCompany(Company company) {
		getSession().delete(company);
	}

	@Override
	public List<Company> listCompany() {
		// TODO Auto-generated method stub
		List<Company> list = getSession().createCriteria(Company.class).list();
		return list;
	}

	@Override
	public Company get(int id) {
		// TODO Auto-generated method stub
		Company company = (Company) getSession().get(Company.class,id);
		return company;
	}

	@Override
	public int getAllRowCount() {
		// TODO Auto-generated method stub
		List<Company> list = getSession().createCriteria(Company.class).list();
		return list.size();
	}

	@Override
	public List<Company> listCompanyByPage(String hql, int offset, int pageSize) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public void deleteCompanyById(int id) {
		// TODO Auto-generated method stub
		Query q = getSession().createQuery("delete from Company where id = "+id);
		q.executeUpdate();
	}

}
