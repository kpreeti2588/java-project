package com.simplilearn.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.simplilearn.dao.EmployeeDao;
import com.simplilearn.exception.EMSException;
import com.simplilearn.model.EmployeeDetails;

public class EmployeeDaoService implements IEmployeeDao {

	public EmployeeDaoService() {
		// TODO Auto-generated constructor stub
	}
    private EmployeeDao dao=EmployeeDao.getEmpDao();
	
	public int deleteEmpDetails(int id) throws EMSException {
		return dao.deleteEmpDetails(id);
	}

	public int updateEmpDetails(EmployeeDetails employeeDetails) throws EMSException {
		return  dao.updateEmpDetails(employeeDetails);
	}

	public List<EmployeeDetails> getEmpDetails() throws EMSException {
	    return dao.getEmpDetails();
	}
	
	public ResultSet getEmpDetails1(String name) throws EMSException {
	    return dao.getEmpDetails1(name);
	}

	public int validateUserDetails(String username, String password) throws EMSException {
		return dao.validateUserDetails(username, password);
	}

	public int saveEmpDetails(EmployeeDetails employeeDetails) throws EMSException {
	return dao.saveEmpDetails(employeeDetails);
	
	}


}
