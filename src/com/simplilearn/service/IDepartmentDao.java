package com.simplilearn.service;

import java.sql.SQLException;
import java.util.List;

import com.simplilearn.exception.EMSException;
import com.simplilearn.model.DepartmentDetails;

public interface IDepartmentDao {
	
	public int deleteDepDetails(int id) throws EMSException ;
	public int updateDepDetails(DepartmentDetails depDetails) throws EMSException;
	public List<DepartmentDetails> getDepartmentDetails() throws EMSException;
	public int saveDepDetails(DepartmentDetails depDetails) throws EMSException;
}
