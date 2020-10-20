package com.simplilearn.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.simplilearn.dao.RegulationDao;
import com.simplilearn.exception.EMSException;
import com.simplilearn.model.Regulation;

public class RegulationDaoService implements IRegulationDao {

	public RegulationDaoService() {
		// TODO Auto-generated constructor stub
	}

	private RegulationDao regdao= RegulationDao.getRegulationDao();
	
	
	public int deleteRegDetails(int id) throws EMSException {
		// TODO Auto-generated method stub
		return regdao.deleteRegDetails(id);
	}

	public int updateRegDetails(Regulation regDetails) throws EMSException {
		// TODO Auto-generated method stub
		return regdao.updateRegDetails(regDetails);
	}

	@Override
	public List<Regulation> getRegulationDetails() throws EMSException {
		// TODO Auto-generated method stub
		return regdao.getRegulationDetails();
	}


	public  ResultSet getRegulationDetails1(String name) throws EMSException {
		// TODO Auto-generated method stub
		return regdao.getRegulationDetails1(name);
	}
	
	@Override
	public int saveRegDetails(Regulation regDetails) throws EMSException {
		// TODO Auto-generated method stub
		return regdao.saveRegulationDetails(regDetails);
	}

	
}
