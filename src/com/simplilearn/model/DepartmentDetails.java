package com.simplilearn.model;

public class DepartmentDetails {

	public DepartmentDetails() {
		// TODO Auto-generated constructor stub
	}
	

	private int depid;
	private String depname;
	private String deplocation;
	
	public int getDepid() {
		return depid;
	}
	public void setDepid(int depid) {
		this.depid = depid;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public String getDeplocation() {
		return deplocation;
	}
	public void setDeplocation(String deplocation) {
		this.deplocation = deplocation;
	}
	
	public DepartmentDetails(String depname, String deplocation) {
		super();
		this.depname = depname;
		this.deplocation = deplocation;
	}
	
	public DepartmentDetails(int depid, String depname, String deplocation) {
		super();
		this.depid = depid;
		this.depname = depname;
		this.deplocation = deplocation;
	}
	
	@Override
	public String toString() {
		return "DepartmentDetails [depid=" + depid + ", depname=" + depname + ", deplocation=" + deplocation + "]";
	}
	
	
	
	
}
