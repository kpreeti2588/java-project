package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.exception.EMSException;
import com.simplilearn.model.Regulation;
import com.simplilearn.util.ConnectionUtil;

public class RegulationDao {

	public RegulationDao() {
		// TODO Auto-generated constructor stub
	}

	
	private static RegulationDao regulationDao=null;
	public static RegulationDao getRegulationDao(){
		if(regulationDao==null){
			
			regulationDao=new RegulationDao();
		}
		return regulationDao;
		
	}
		
	public int deleteRegDetails(int id) throws EMSException{	
		int flag=0;
		String query="delete from regulation where id=?";
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

	
	public int updateRegDetails(Regulation regDetails) throws EMSException {
		
		int flag=0;
		String query="update regulation set name=? ,description=? where id=?";
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
			try{	
		 connection=	ConnectionUtil.getConnection();
		 preparedStatement=	   connection.prepareStatement(query);
		
		preparedStatement.setString(1, regDetails.getRegName());
		preparedStatement.setString(2, regDetails.getRegDescription());
		preparedStatement.setInt(3, regDetails.getRegId());
		
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
	
	
     public  ResultSet getRegulationDetails1(String name) throws EMSException{

		String query="select * from regulation where name = ?";
		System.out.println("Query   "+ query);
	
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=	ConnectionUtil.getConnection();
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1,name);
			
			resultSet= preparedStatement.executeQuery();	
		}
		catch(SQLException e) {
			throw new EMSException(e.getMessage());
		}
		
		return resultSet;
	}
	
	
	
	public List<Regulation> getRegulationDetails() throws EMSException {
		
		List<Regulation > regList=new ArrayList<Regulation>();
		int status=0;
		String query="select * from regulation";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try{	
			 connection=	ConnectionUtil.getConnection();
			 preparedStatement=	   connection.prepareStatement(query);
			
			 resultSet= preparedStatement.executeQuery();

			 while(resultSet.next()){
				int id= resultSet.getInt("id");

				String name=resultSet.getString("name");
				String description=resultSet.getString("description");
				int depid=resultSet.getInt("rdep_id");
				
				Regulation details=new Regulation(id, name, description, depid);
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
	
		
	public int saveRegulationDetails(Regulation regulationDetails) throws EMSException {
		int flag=0;
		String query="insert into regulation(name, description, rdep_id) values(?,?,?)";
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
		try{	
	 connection=	ConnectionUtil.getConnection();
	 preparedStatement=	   connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	preparedStatement.setString(1, regulationDetails.getRegName());
	preparedStatement.setString(2,  regulationDetails.getRegDescription());
	preparedStatement.setInt(3,  regulationDetails.getRdep_id());
	
	
	flag=preparedStatement.executeUpdate();	
	 resultSet=preparedStatement.getGeneratedKeys();
	
	System.out.println("inserted="+flag);
	
	if(resultSet.next()){		
	flag=resultSet.getInt(1);		
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
