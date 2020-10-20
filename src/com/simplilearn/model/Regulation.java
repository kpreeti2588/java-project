package com.simplilearn.model;

public class Regulation {

	public Regulation() {
		// TODO Auto-generated constructor stub
	}
	
	private int regId;
	private String regName;
	private String regDescription;
	private DepartmentDetails dep=new DepartmentDetails();
	private int rdep_id;
	
	
	@Override
	public String toString() {
		return "Regulation [regId=" + regId + ", regName=" + regName + ", regDescription=" + regDescription
				+ ", rdep_id=" + rdep_id + "]";
	}
	public int getRdep_id() {
		return rdep_id;
	}
	public void setRdep_id(int rdep_id) {
		this.rdep_id = rdep_id;
	}
	
	public DepartmentDetails getDep() {
		return dep;
	}
	public void setDep(DepartmentDetails dep) {
		this.dep = dep;
	}
	
	
	public int getRegId() {
		return regId;
	}
	public void setRegId(int regId) {
		this.regId = regId;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getRegDescription() {
		return regDescription;
	}
	public void setRegDescription(String regDescription) {
		this.regDescription = regDescription;
	}
	
	public Regulation(int regId, String regName, String regDescription, int rdep_id) {
		super();
		this.regId = regId;
		this.regName = regName;
		this.regDescription = regDescription;
		this.rdep_id = rdep_id;
	}
	
	public Regulation(String regName, String regDescription, int rdep_id) {
		super();
		this.regName = regName;
		this.regDescription = regDescription;
		this.rdep_id = rdep_id;
	}
	public Regulation(int regId, String regName, String regDescription) {
		super();
		this.regId = regId;
		this.regName = regName;
		this.regDescription = regDescription;
	}
	
	public Regulation(String regName, String regDescription) {
		super();
		this.regName = regName;
		this.regDescription = regDescription;
	}
	
	
	
	
	
	
	
}
