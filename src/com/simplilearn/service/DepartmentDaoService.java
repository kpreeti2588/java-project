package com.simplilearn.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.simplilearn.dao.DepartmentDao;
import com.simplilearn.exception.EMSException;
import com.simplilearn.model.DepartmentDetails;

public class DepartmentDaoService implements IDepartmentDao {

	public DepartmentDaoService() {
		// TODO Auto-generated constructor stub
	}

	private DepartmentDao depdao= DepartmentDao.getDepartmentDao();
	
	@Override
	public int deleteDepDetails(int id) throws EMSException {
		// TODO Auto-generated method stub
		return depdao.deleteDepDetails(id);
	}

	@Override
	public int updateDepDetails(DepartmentDetails depDetails) throws EMSException {
		// TODO Auto-generated method stub
		return depdao.updateDepDetails(depDetails);
	}

	@Override
	public List<DepartmentDetails> getDepartmentDetails() throws EMSException {
		// TODO Auto-generated method stub
		return depdao.getDepartmentDetails();
	}
	
	
	public ResultSet getDepartmentDetails1(String name) throws EMSException {
		// TODO Auto-generated method stub
		return depdao.getDepartmentDetails1(name);
	}

	@Override
	public int saveDepDetails(DepartmentDetails depDetails) throws EMSException {
		// TODO Auto-generated method stub
		return depdao.saveDepDetails(depDetails);
	}

	
}
