package com.simplilearn.service;

import java.sql.SQLException;
import java.util.List;

import com.simplilearn.exception.EMSException;
import com.simplilearn.model.Regulation;
import com.simplilearn.model.RegulationDetails;

public interface IRegulationDetailsDao {
	
	public int deleteRegDetailsbyEmp(int id) throws EMSException ;
	public int updateRegDetailsbyEmp(RegulationDetails regDetails) throws EMSException;
	public List<RegulationDetails> getRegulationDetailsbyEmp() throws EMSException;
	public int saveRegDetailsbyEmp(RegulationDetails regDetails) throws EMSException;
}
