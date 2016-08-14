package com.eMarine.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eMarine.entity.Group;

public class GroupDaoImp implements IGroupDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void AddGroup(Group group) {
		getSession().save(group);
	}

	@Override
	public void modifyGroup(Group group) {
		getSession().update(group);
	}

	@Override
	public void deleteGroup(Group group) {
		getSession().delete(group);
	}

	@Override
	public List<Group> listGroup() {
		// TODO Auto-generated method stub
		List<Group> list = getSession().createCriteria(Group.class).list();
		return list;
	}

	@Override
	public Group get(int id) {
		// TODO Auto-generated method stub
		Group group = (Group) getSession().get(Group.class,id);
		return group;
	}

	@Override
	public int getAllRowCount() {
		// TODO Auto-generated method stub
		List<Group> list = getSession().createCriteria(Group.class).list();
		return list.size();
	}

	@Override
	public List<Group> listGroupByPage(String hql, int offset, int pageSize) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public void deleteGroupById(int id) {
		// TODO Auto-generated method stub
		Query q = getSession().createQuery("delete from Group where id = "+id);
		q.executeUpdate();
	}

}
