package com.eMarine.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.eMarine.entity.Group;
import com.eMarine.entity.Operator;
import com.eMarine.entity.Vessel;
import com.eMarine.service.IGroupManage;
import com.eMarine.service.IOperatorManage;
import com.eMarine.service.IVesselManage;
import com.eMarine.service.PageBean;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class VesselAction extends ActionSupport {
	
	private Vessel vessel;

	private List<Vessel> listVessel;
	
	private List<Operator> listOperator;
	
	private Operator operator;

	private List<Group> listGroup;
	
	private Group group;
	
	private PageBean<Vessel> pageBean;

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

	public PageBean<Vessel> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Vessel> pageBean) {
		this.pageBean = pageBean;
	}

	@Resource  
	private IVesselManage vesselManage;

	@Resource  
	private IOperatorManage operatorManage;

	@Resource  
	private IGroupManage groupManage;
	
	public void setVesselManage(IVesselManage vesselManage) {
		this.vesselManage = vesselManage;
	}
	
	public IVesselManage getVesselManage() {
		return vesselManage;
	}
	
	public IOperatorManage getOperatorManage() {
		return operatorManage;
	}

	public void setOperatorManage(IOperatorManage operatorManage) {
		this.operatorManage = operatorManage;
	}

	public IGroupManage getGroupManage() {
		return groupManage;
	}

	public void setGroupManage(IGroupManage groupManage) {
		this.groupManage = groupManage;
	}

	public Vessel getVessel() {
		return vessel;
	}

	public void setVessel(Vessel vessel) {
		this.vessel = vessel;
	}
	
	public String addVessel()
	{
		Operator operator = operatorManage.getOperatorById(vessel.getOperator().getId());
		vessel.setOperator(operator);
		Group group = groupManage.getGroupById(vessel.getGroup().getId());
		vessel.setGroup(group);
		vesselManage.addVessel(vessel);
		return "success";
	}
	public String listVessel()
	{
		listVessel = vesselManage.listVessel();
		return "success";
	}
	public String listVesselByPage()
	{
		pageBean = vesselManage.listVesselByPage(page, 10);
		listOperator = operatorManage.listOperator();
		listGroup = groupManage.listGroup();
		return "success";
	}

	public void getVesselById()
	{
		vessel = vesselManage.getVesselById(id);
		Gson gson=new Gson();
		String json=gson.toJson(vessel);
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
	
	public String modifyVessel()
	{
		Operator operator = operatorManage.getOperatorById(vessel.getOperator().getId());
		vessel.setOperator(operator);
		Group group = groupManage.getGroupById(vessel.getGroup().getId());
		vessel.setGroup(group);
		vesselManage.modifyVessel(vessel);
		return "success";
	}
	
	public String deleteVessel()
	{
		vesselManage.deleteVessel(vessel);
		return "success";
	}
	
	public String deleteVesselById()
	{
		String[] idArr = ids.split(",");
		for(String id : idArr){
			vesselManage.deleteVesselById(Integer.parseInt(id));
		}
		return "success";
	}

	public List<Vessel> getListVessel() {
		return listVessel;
	}

	public void setListVessel(List<Vessel> listVessel) {
		this.listVessel = listVessel;
	}

	public List<Operator> getListOperator() {
		return listOperator;
	}

	public void setListOperator(List<Operator> listOperator) {
		this.listOperator = listOperator;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public List<Group> getListGroup() {
		return listGroup;
	}

	public void setListGroup(List<Group> listGroup) {
		this.listGroup = listGroup;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	
}
