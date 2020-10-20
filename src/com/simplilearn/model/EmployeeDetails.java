package com.simplilearn.model;

public class EmployeeDetails {

	
	public EmployeeDetails() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String name;
	private float salary;
	private String phone;
	private char gender;
	private String dob;
	private String designation;
	private DepartmentDetails dep=new DepartmentDetails();
	private int dep_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public EmployeeDetails(String name, float salary, String phone, char gender, String dob, String designation) {
		super();
		this.name = name;
		this.salary = salary;
		this.phone = phone;
		this.gender = gender;
		this.dob = dob;
		this.designation = designation;
	}
	
	public EmployeeDetails(int id, String name, float salary, String phone, char gender, String dob,
			String designation) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.phone = phone;
		this.gender = gender;
		this.dob = dob;
		this.designation = designation;
	}
	
	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", name=" + name + ", salary=" + salary + ", phone=" + phone + ", gender="
				+ gender + ", dob=" + dob + ", designation=" + designation + ", dep_id=" + dep_id + "]";
	}
	public DepartmentDetails getDep() {
		return dep;
	}
	public void setDep(DepartmentDetails dep) {
		this.dep = dep;
	}
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public EmployeeDetails(int id, String name, float salary, String phone, char gender, String dob, String designation,
			int dep_id) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.phone = phone;
		this.gender = gender;
		this.dob = dob;
		this.designation = designation;
		this.dep_id = dep_id;
	}
	
	
	
	
	
	
	

}
