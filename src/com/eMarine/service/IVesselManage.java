package com.eMarine.service;

import java.util.List;

import com.eMarine.entity.Vessel;

public interface IVesselManage {
	public void addVessel(Vessel vessel);
	public void modifyVessel(Vessel vessel);
	public void deleteVessel(Vessel vessel);
	public void deleteVesselById(int id);
	public Vessel getVesselById(int id);
	public List<Vessel> listVessel();
	public PageBean<Vessel> listVesselByPage(int currentPage,int pagesize);
}
