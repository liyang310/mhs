package com.eMarine.dao;

import java.util.List;
import com.eMarine.entity.Group;

public interface IGroupDao {
	public void AddGroup(Group group);
	public void modifyGroup(Group group);
	public void deleteGroup(Group group);
	public void deleteGroupById(int id);
	public Group get(int id);
	public List<Group> listGroup();
	public List<Group> listGroupByPage(String hql, int offset, int pageSize);
	public int getAllRowCount();
}
