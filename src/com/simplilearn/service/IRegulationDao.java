package com.simplilearn.service;

import java.sql.SQLException;
import java.util.List;

import com.simplilearn.exception.EMSException;
import com.simplilearn.model.Regulation;

public interface IRegulationDao {
	
	public int deleteRegDetails(int id) throws EMSException ;
	public int updateRegDetails(Regulation regDetails) throws EMSException;
	public List<Regulation> getRegulationDetails() throws EMSException;
	public int saveRegDetails(Regulation regDetails) throws EMSException;
}
