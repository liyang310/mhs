package com.eMarine.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.eMarine.dao.IOperatorDao;
import com.eMarine.entity.Operator;

public class OperatorManageImp implements IOperatorManage {
	
	@Resource  
	private IOperatorDao operatorDao;
	
	public IOperatorDao getOperatorDao() {
		return operatorDao;
	}

	public void setOperatorDao(IOperatorDao operatorDao) {
		this.operatorDao = operatorDao;
	}

	@Override
	public void addOperator(Operator operator) {
		operatorDao.AddOperator(operator);
		
	}

	@Override
	public void modifyOperator(Operator operator) {
		operatorDao.modifyOperator(operator);

	}

	@Override
	public void deleteOperator(Operator operator) {
		operatorDao.deleteOperator(operator);
	}

	@Override
	public List<Operator> listOperator() {
		return operatorDao.listOperator();
	}

	@Override
	public PageBean<Operator> listOperatorByPage(int currentPage,int pagesize) {
		// TODO Auto-generated method stub
		PageBean<Operator> page = new PageBean<Operator>();
		page.setCurrentPage(currentPage);
		int allRows = operatorDao.getAllRowCount();
		page.setAllRows(allRows);
		page.setTotalPage(allRows/10+1);
		String hql = "from Operator";
		List<Operator> operatorList = operatorDao.listOperatorByPage(hql, currentPage*10, page.getPagesize());
		page.setList(operatorList);
		
		return page;
	}

	@Override
	public void deleteOperatorById(int id) {
		// TODO Auto-generated method stub
		operatorDao.deleteOperatorById(id);
	}

	@Override
	public Operator getOperatorById(int id) {
		// TODO Auto-generated method stub
		return operatorDao.get(id);
	}
}
