package com.simplilearn.service;

import java.sql.SQLException;
import java.util.List;

import com.simplilearn.exception.EMSException;
import com.simplilearn.model.EmployeeDetails;

public interface IEmployeeDao {
	public int deleteEmpDetails(int id) throws EMSException ;
	public int updateEmpDetails(EmployeeDetails employeeDetails) throws EMSException;
	public List<EmployeeDetails> getEmpDetails() throws EMSException;
	public int validateUserDetails(String username, String password) throws EMSException;
	public int saveEmpDetails(EmployeeDetails employeeDetails) throws EMSException;
}
