package com.eMarine.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.eMarine.entity.Company;
import com.eMarine.entity.Group;
import com.eMarine.service.ICompanyManage;
import com.eMarine.service.IGroupManage;
import com.eMarine.service.PageBean;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GroupAction extends ActionSupport {
	
	private Group group;

	private List<Group> listGroup;
	
	private List<Company> listCompany;
	
	private Company company;
	
	private PageBean<Group> pageBean;

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

	public PageBean<Group> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Group> pageBean) {
		this.pageBean = pageBean;
	}

	@Resource  
	private IGroupManage groupManage;

	@Resource  
	private ICompanyManage companyManage;
	
	public void setGroupManage(IGroupManage groupManage) {
		this.groupManage = groupManage;
	}
	
	public IGroupManage getGroupManage() {
		return groupManage;
	}
	
	public ICompanyManage getCompanyManage() {
		return companyManage;
	}

	public void setCompanyManage(ICompanyManage companyManage) {
		this.companyManage = companyManage;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public String addGroup()
	{
		Company company = companyManage.getCompanyById(group.getCompany().getId());
		group.setCompany(company);
		groupManage.addGroup(group);
		return "success";
	}
	public String listGroup()
	{
		listGroup = groupManage.listGroup();
		return "success";
	}
	public String listGroupByPage()
	{
		pageBean = groupManage.listGroupByPage(page, 10);
		listCompany = companyManage.listCompany();
		return "success";
	}

	public void getGroupById()
	{
		group = groupManage.getGroupById(id);
		Gson gson=new Gson();
		String json=gson.toJson(group);
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
	
	public String modifyGroup()
	{
		Company company = companyManage.getCompanyById(group.getCompany().getId());
		group.setCompany(company);
		groupManage.modifyGroup(group);
		return "success";
	}
	
	public String deleteGroup()
	{
		groupManage.deleteGroup(group);
		return "success";
	}
	
	public String deleteGroupById()
	{
		String[] idArr = ids.split(",");
		for(String id : idArr){
			groupManage.deleteGroupById(Integer.parseInt(id));
		}
		return "success";
	}

	public List<Group> getListGroup() {
		return listGroup;
	}

	public void setListGroup(List<Group> listGroup) {
		this.listGroup = listGroup;
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
