package com.eMarine.dao;

import java.util.List;
import com.eMarine.entity.Vessel;

public interface IVesselDao {
	public void AddVessel(Vessel vessel);
	public void modifyVessel(Vessel vessel);
	public void deleteVessel(Vessel vessel);
	public void deleteVesselById(int id);
	public Vessel get(int id);
	public List<Vessel> listVessel();
	public List<Vessel> listVesselByPage(String hql, int offset, int pageSize);
	public int getAllRowCount();
}
