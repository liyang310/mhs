package com.eMarine.dao;

import java.util.List;
import com.eMarine.entity.Operator;

public interface IOperatorDao {
	public void AddOperator(Operator operator);
	public void modifyOperator(Operator operator);
	public void deleteOperator(Operator operator);
	public void deleteOperatorById(int id);
	public Operator get(int id);
	public List<Operator> listOperator();
	public List<Operator> listOperatorByPage(String hql, int offset, int pageSize);
	public int getAllRowCount();
}
