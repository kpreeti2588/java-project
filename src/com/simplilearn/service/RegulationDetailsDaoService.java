package com.simplilearn.service;

import java.sql.SQLException;
import java.util.List;

import com.simplilearn.dao.RegulationDao;
import com.simplilearn.dao.RegulationDetailsDao;
import com.simplilearn.exception.EMSException;
import com.simplilearn.model.Regulation;
import com.simplilearn.model.RegulationDetails;

public class RegulationDetailsDaoService implements IRegulationDetailsDao {

	public RegulationDetailsDaoService() {
		// TODO Auto-generated constructor stub
	}

	private RegulationDetailsDao regdao= RegulationDetailsDao.getRegulationDao();

	@Override
	public int deleteRegDetailsbyEmp(int id) throws EMSException {
		// TODO Auto-generated method stub
		return regdao.deleteRegDetailsbyEmp(id);
	}

	@Override
	public int updateRegDetailsbyEmp(RegulationDetails regDetails) throws EMSException {
		// TODO Auto-generated method stub
		return regdao.updateRegDetailsByEmp(regDetails);
	}

	@Override
	public List<RegulationDetails> getRegulationDetailsbyEmp() throws EMSException {
		// TODO Auto-generated method stub
		return regdao.getRegulationDetailsByEmp();
	}

	@Override
	public int saveRegDetailsbyEmp(RegulationDetails regDetails) throws EMSException {
		// TODO Auto-generated method stub
		return regdao.saveRegulationDetailsByEmp(regDetails);
	}
	
	
	

	
}
