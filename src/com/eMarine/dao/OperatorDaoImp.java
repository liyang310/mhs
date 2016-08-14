package com.eMarine.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eMarine.entity.Operator;

public class OperatorDaoImp implements IOperatorDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void AddOperator(Operator operator) {
		getSession().save(operator);
	}

	@Override
	public void modifyOperator(Operator operator) {
		getSession().update(operator);
	}

	@Override
	public void deleteOperator(Operator operator) {
		getSession().delete(operator);
	}

	@Override
	public List<Operator> listOperator() {
		// TODO Auto-generated method stub
		List<Operator> list = getSession().createCriteria(Operator.class).list();
		return list;
	}

	@Override
	public Operator get(int id) {
		// TODO Auto-generated method stub
		Operator operator = (Operator) getSession().get(Operator.class,id);
		return operator;
	}

	@Override
	public int getAllRowCount() {
		// TODO Auto-generated method stub
		List<Operator> list = getSession().createCriteria(Operator.class).list();
		return list.size();
	}

	@Override
	public List<Operator> listOperatorByPage(String hql, int offset, int pageSize) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public void deleteOperatorById(int id) {
		// TODO Auto-generated method stub
		Query q = getSession().createQuery("delete from Operator where id = "+id);
		q.executeUpdate();
	}

}
