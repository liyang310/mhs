package com.eMarine.service;

import java.util.List;

import com.eMarine.entity.Group;

public interface IGroupManage {
	public void addGroup(Group group);
	public void modifyGroup(Group group);
	public void deleteGroup(Group group);
	public void deleteGroupById(int id);
	public Group getGroupById(int id);
	public List<Group> listGroup();
	public PageBean<Group> listGroupByPage(int currentPage,int pagesize);
}
