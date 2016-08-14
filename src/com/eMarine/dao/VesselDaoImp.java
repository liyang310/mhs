package com.eMarine.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eMarine.entity.Vessel;

public class VesselDaoImp implements IVesselDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void AddVessel(Vessel vessel) {
		getSession().save(vessel);
	}

	@Override
	public void modifyVessel(Vessel vessel) {
		getSession().update(vessel);
	}

	@Override
	public void deleteVessel(Vessel vessel) {
		getSession().delete(vessel);
	}

	@Override
	public List<Vessel> listVessel() {
		// TODO Auto-generated method stub
		List<Vessel> list = getSession().createCriteria(Vessel.class).list();
		return list;
	}

	@Override
	public Vessel get(int id) {
		// TODO Auto-generated method stub
		Vessel vessel = (Vessel) getSession().get(Vessel.class,id);
		return vessel;
	}

	@Override
	public int getAllRowCount() {
		// TODO Auto-generated method stub
		List<Vessel> list = getSession().createCriteria(Vessel.class).list();
		return list.size();
	}

	@Override
	public List<Vessel> listVesselByPage(String hql, int offset, int pageSize) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public void deleteVesselById(int id) {
		// TODO Auto-generated method stub
		Query q = getSession().createQuery("delete from Vessel where id = "+id);
		q.executeUpdate();
	}

}
