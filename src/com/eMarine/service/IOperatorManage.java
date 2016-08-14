package com.eMarine.service;

import java.util.List;

import com.eMarine.entity.Operator;

public interface IOperatorManage {
	public void addOperator(Operator operator);
	public void modifyOperator(Operator operator);
	public void deleteOperator(Operator operator);
	public void deleteOperatorById(int id);
	public Operator getOperatorById(int id);
	public List<Operator> listOperator();
	public PageBean<Operator> listOperatorByPage(int currentPage,int pagesize);
}
