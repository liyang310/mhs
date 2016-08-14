package com.eMarine.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.eMarine.dao.IGroupDao;
import com.eMarine.entity.Group;

public class GroupManageImp implements IGroupManage {
	
	@Resource  
	private IGroupDao groupDao;
	
	public IGroupDao getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}

	@Override
	public void addGroup(Group group) {
		groupDao.AddGroup(group);
		
	}

	@Override
	public void modifyGroup(Group group) {
		groupDao.modifyGroup(group);

	}

	@Override
	public void deleteGroup(Group group) {
		groupDao.deleteGroup(group);
	}

	@Override
	public List<Group> listGroup() {
		return groupDao.listGroup();
	}

	@Override
	public PageBean<Group> listGroupByPage(int currentPage,int pagesize) {
		// TODO Auto-generated method stub
		PageBean<Group> page = new PageBean<Group>();
		page.setCurrentPage(currentPage);
		int allRows = groupDao.getAllRowCount();
		page.setAllRows(allRows);
		page.setTotalPage(allRows/10+1);
		String hql = "from Group";
		List<Group> groupList = groupDao.listGroupByPage(hql, currentPage*10, page.getPagesize());
		page.setList(groupList);
		
		return page;
	}

	@Override
	public void deleteGroupById(int id) {
		// TODO Auto-generated method stub
		groupDao.deleteGroupById(id);
	}

	@Override
	public Group getGroupById(int id) {
		// TODO Auto-generated method stub
		return groupDao.get(id);
	}
}
