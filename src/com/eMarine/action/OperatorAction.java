package com.eMarine.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.eMarine.entity.Company;
import com.eMarine.entity.Operator;
import com.eMarine.service.ICompanyManage;
import com.eMarine.service.IOperatorManage;
import com.eMarine.service.PageBean;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class OperatorAction extends ActionSupport {
	
	private Operator operator;

	private List<Operator> listOperator;
	
	private List<Company> listCompany;
	
	private Company company;
	
	private PageBean<Operator> pageBean;

	private int page;

	private String ids;

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean<Operator> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Operator> pageBean) {
		this.pageBean = pageBean;
	}

	@Resource  
	private IOperatorManage operatorManage;

	@Resource  
	private ICompanyManage companyManage;
	
	public void setOperatorManage(IOperatorManage operatorManage) {
		this.operatorManage = operatorManage;
	}
	
	public IOperatorManage getOperatorManage() {
		return operatorManage;
	}
	
	public ICompanyManage getCompanyManage() {
		return companyManage;
	}

	public void setCompanyManage(ICompanyManage companyManage) {
		this.companyManage = companyManage;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	public String addOperator()
	{
		Company company = companyManage.getCompanyById(operator.getCompany().getId());
		operator.setCompany(company);
		operatorManage.addOperator(operator);
		return "success";
	}
	public String listOperator()
	{
		listOperator = operatorManage.listOperator();
		return "success";
	}
	public String listOperatorByPage()
	{
		pageBean = operatorManage.listOperatorByPage(page, 10);
		listCompany = companyManage.listCompany();
		return "success";
	}

	public void getOperatorById()
	{
		operator = operatorManage.getOperatorById(id);
		Gson gson=new Gson();
		String json=gson.toJson(operator);
		HttpServletResponse response = ServletActionContext.getResponse();  
        PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(json);  
	        writer.flush();  
	        writer.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
	}
	
	public String modifyOperator()
	{
		Company company = companyManage.getCompanyById(operator.getCompany().getId());
		operator.setCompany(company);
		operatorManage.modifyOperator(operator);
		return "success";
	}
	
	public String deleteOperator()
	{
		operatorManage.deleteOperator(operator);
		return "success";
	}
	
	public String deleteOperatorById()
	{
		String[] idArr = ids.split(",");
		for(String id : idArr){
			operatorManage.deleteOperatorById(Integer.parseInt(id));
		}
		return "success";
	}

	public List<Operator> getListOperator() {
		return listOperator;
	}

	public void setListOperator(List<Operator> listOperator) {
		this.listOperator = listOperator;
	}

	public List<Company> getListCompany() {
		return listCompany;
	}

	public void setListCompany(List<Company> listCompany) {
		this.listCompany = listCompany;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
