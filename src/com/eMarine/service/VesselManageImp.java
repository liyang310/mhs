package com.eMarine.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.eMarine.dao.IVesselDao;
import com.eMarine.entity.Vessel;

public class VesselManageImp implements IVesselManage {
	
	@Resource  
	private IVesselDao vesselDao;
	
	public IVesselDao getVesselDao() {
		return vesselDao;
	}

	public void setVesselDao(IVesselDao vesselDao) {
		this.vesselDao = vesselDao;
	}

	@Override
	public void addVessel(Vessel vessel) {
		vesselDao.AddVessel(vessel);
		
	}

	@Override
	public void modifyVessel(Vessel vessel) {
		vesselDao.modifyVessel(vessel);

	}

	@Override
	public void deleteVessel(Vessel vessel) {
		vesselDao.deleteVessel(vessel);
	}

	@Override
	public List<Vessel> listVessel() {
		return vesselDao.listVessel();
	}

	@Override
	public PageBean<Vessel> listVesselByPage(int currentPage,int pagesize) {
		// TODO Auto-generated method stub
		PageBean<Vessel> page = new PageBean<Vessel>();
		page.setCurrentPage(currentPage);
		int allRows = vesselDao.getAllRowCount();
		page.setAllRows(allRows);
		page.setTotalPage(allRows/10+1);
		String hql = "from Vessel";
		List<Vessel> vesselList = vesselDao.listVesselByPage(hql, currentPage*10, page.getPagesize());
		page.setList(vesselList);
		
		return page;
	}

	@Override
	public void deleteVesselById(int id) {
		// TODO Auto-generated method stub
		vesselDao.deleteVesselById(id);
	}

	@Override
	public Vessel getVesselById(int id) {
		// TODO Auto-generated method stub
		return vesselDao.get(id);
	}
}
