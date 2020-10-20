package com.simplilearn.model;

public class RegulationDetails {

	public RegulationDetails() {
		// TODO Auto-generated constructor stub
	}
	
	private int id;
	private int emp_id;
	private int reg_id;
	private String description;
	private Regulation reg=new Regulation();
	private EmployeeDetails emp = new EmployeeDetails();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Regulation getReg() {
		return reg;
	}
	public void setReg(Regulation reg) {
		this.reg = reg;
	}
	public EmployeeDetails getEmp() {
		return emp;
	}
	public void setEmp(EmployeeDetails emp) {
		this.emp = emp;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getReg_id() {
		return reg_id;
	}
	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}
	
	
	@Override
	public String toString() {
		return "RegulationDetails [id=" + id + ", emp_id=" + emp_id + ", reg_id=" + reg_id + ", description="
				+ description + "]";
	}
	
	public RegulationDetails(int id, int emp_id, int reg_id,String description) {
		super();
		this.id = id;
		this.description = description;
		this.emp_id = emp_id;
		this.reg_id = reg_id;
	}
	
	
}
