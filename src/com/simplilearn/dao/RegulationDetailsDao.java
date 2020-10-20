package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.exception.EMSException;
import com.simplilearn.model.RegulationDetails;
import com.simplilearn.util.ConnectionUtil;

public class RegulationDetailsDao {

	public RegulationDetailsDao() {
		// TODO Auto-generated constructor stub
	}

	
	private static RegulationDetailsDao regulationDao=null;
	public static RegulationDetailsDao getRegulationDao(){
		if(regulationDao==null){
			
			regulationDao=new RegulationDetailsDao();
		}
		return regulationDao;
		
	}
		
	public int deleteRegDetailsbyEmp(int id) throws EMSException{	
		int flag=0;
		String query="delete from regulationdetails where id=?";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
			try{	
		 connection=	ConnectionUtil.getConnection();

		 connection.setAutoCommit(false);
		 preparedStatement=	   connection.prepareStatement(query);		
		preparedStatement.setInt(1, id);		
		flag=preparedStatement.executeUpdate();
		
		connection.commit();
		//end transaction
		System.out.println("deleted="+flag);		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new EMSException(e.getMessage());
		}finally{			
			
			try {
		
				if(connection!=null){				
				connection.close();
				}
				if(preparedStatement!=null){				
					preparedStatement.close();
				}
				if(resultSet!=null){				
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error while closing");
			// rollback transaction
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				throw new EMSException(e1.getMessage());
			}
			
			}
			
		}
		
		return flag;
	}

	
	public int updateRegDetailsByEmp(RegulationDetails regDetails) throws EMSException {
		
		int flag=0;
		String query="update regulationdetails set description=? where id=?";
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
			try{	
		 connection=	ConnectionUtil.getConnection();
		 preparedStatement=	   connection.prepareStatement(query);
		
		preparedStatement.setString(1, regDetails.getDescription());
		preparedStatement.setInt(2, regDetails.getId());
		
		
		flag=preparedStatement.executeUpdate();
				
		System.out.println("updated="+flag);
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new EMSException(e.getMessage());
		}finally{			
			try {
		
				if(connection!=null){				
				connection.close();
				}
				if(preparedStatement!=null){				
					preparedStatement.close();
				}
				if(resultSet!=null){				
					resultSet.close();
				}
			} catch (SQLException e) {
				
				System.out.println("error while closing");
				throw new EMSException(e.getMessage());
			}
			
		}
		
		return flag;
	}
	
	
     public  ResultSet getRegulationDetails1ByEmp(int id) throws EMSException{

		String query="select * from regulationdetails where id = ?";
		System.out.println("Query   "+ query);
	
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=	ConnectionUtil.getConnection();
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setInt(1,id);
			
			resultSet= preparedStatement.executeQuery();	
		}
		catch(SQLException e) {
			throw new EMSException(e.getMessage());
		}
		
		return resultSet;
	}
	
	
	
	public List<RegulationDetails> getRegulationDetailsByEmp() throws EMSException {
		
		List<RegulationDetails > regList=new ArrayList<RegulationDetails>();
		int status=0;
		String query="select * from regulationdetails";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try{	
			 connection=	ConnectionUtil.getConnection();
			 preparedStatement=	   connection.prepareStatement(query);
			
			 resultSet= preparedStatement.executeQuery();

			 while(resultSet.next()){
				int id= resultSet.getInt("id");

				int empid=resultSet.getInt("emp_id");
				String description=resultSet.getString("description");
				int regid=resultSet.getInt("reg_id");
				
				RegulationDetails details=new RegulationDetails(id, empid, regid, description);
				regList.add(details);
			}
			 			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new EMSException(e.getMessage());
			}finally{				
				try {
			
					if(connection!=null){				
					connection.close();
					}
					if(preparedStatement!=null){				
						preparedStatement.close();
					}
					if(resultSet!=null){				
						resultSet.close();
					}
				} catch (SQLException e) {				
					System.out.println("error while closing");
					throw new EMSException(e.getMessage());
				}
				
			}
			
		return regList;
	}
	
		
	public int saveRegulationDetailsByEmp(RegulationDetails regulationDetails) throws EMSException {
		int flag=0;
		String query="insert into regulationdetails(description, emp_id, reg_id) values(?,?,?)";
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
		try{	
	 connection=	ConnectionUtil.getConnection();
	 preparedStatement=	   connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	preparedStatement.setString(1,  regulationDetails.getDescription());
	preparedStatement.setInt(2, regulationDetails.getEmp_id());
	preparedStatement.setInt(3, regulationDetails.getReg_id());

	
	flag=preparedStatement.executeUpdate();	
	 resultSet=preparedStatement.getGeneratedKeys();
	
	System.out.println("inserted="+flag);
	
	if(resultSet.next()){		
	flag=	resultSet.getInt(1);		
	}
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new EMSException(e.getMessage());
	}finally{		
		try {
			if(connection!=null){				
			connection.close();
			}
			if(preparedStatement!=null){				
				preparedStatement.close();
			}
			if(resultSet!=null){				
				resultSet.close();
			}
		} catch (SQLException e) {
			
			System.out.println("error while closing");
			throw new EMSException(e.getMessage());
		}		
	}
	
		return flag;

	}
}
