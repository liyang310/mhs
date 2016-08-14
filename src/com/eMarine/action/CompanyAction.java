package com.eMarine.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import net.sf.json.JSONObject;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.eMarine.entity.Company;
import com.eMarine.service.ICompanyManage;
import com.eMarine.service.PageBean;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyAction extends ActionSupport {
	
	private Company company;

	private List<Company> listCompany;
	
	private PageBean<Company> pageBean;

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

	public PageBean<Company> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Company> pageBean) {
		this.pageBean = pageBean;
	}

	@Resource  
	private ICompanyManage companyManage;
	

	public void setCompanyManage(ICompanyManage companyManage) {
		this.companyManage = companyManage;
	}
	
	public ICompanyManage getCompanyManage() {
		return companyManage;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public String addCompany()
	{
		companyManage.addCompany(company);
		return "success";
	}
	public String listCompany()
	{
		listCompany = companyManage.listCompany();
		return "success";
	}
	public String listCompanyByPage()
	{
		pageBean = companyManage.listCompanyByPage(page, 10);
		return "success";
	}

	public void getCompanyById()
	{
		company = companyManage.getCompanyById(id);
		Gson gson=new Gson();
		String json=gson.toJson(company);
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
	
	public String modifyCompany()
	{
		companyManage.modifyCompany(company);
		return "success";
	}
	
	public String deleteCompany()
	{
		companyManage.deleteCompany(company);
		return "success";
	}
	
	public String deleteCompanyById()
	{
		String[] idArr = ids.split(",");
		for(String id : idArr){
			companyManage.deleteCompanyById(Integer.parseInt(id));
		}
		return "success";
	}

	public List<Company> getListCompany() {
		return listCompany;
	}

	public void setListCompany(List<Company> listCompany) {
		this.listCompany = listCompany;
	}
	
	
}
