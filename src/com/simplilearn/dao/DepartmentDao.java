package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.exception.EMSException;
import com.simplilearn.model.DepartmentDetails;
import com.simplilearn.util.ConnectionUtil;

public class DepartmentDao {

	public DepartmentDao() {
		// TODO Auto-generated constructor stub
	}

	
	private static DepartmentDao departmentDao=null;
	public static DepartmentDao getDepartmentDao(){
		if(departmentDao==null){
			
			departmentDao=new DepartmentDao();
		}
		return departmentDao;
		
	}
		
	public int deleteDepDetails(int id) throws EMSException{	
		int flag=0;
		String query="delete from department where id=?";
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
		}catch (SQLException e) {
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

	
	public int updateDepDetails(DepartmentDetails depDetails) throws EMSException {
		
		int flag=0;
		String query="update department set name=? ,location=? where id=?";
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
			try{	
		 connection=	ConnectionUtil.getConnection();
		 preparedStatement=	   connection.prepareStatement(query);
		
		preparedStatement.setString(1, depDetails.getDepname());
		preparedStatement.setString(2, depDetails.getDeplocation());
		preparedStatement.setInt(3, depDetails.getDepid());
		
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
				// TODO Auto-generated catch block
				
				System.out.println("error while closing");
				throw new EMSException(e.getMessage());
			}
			
		}
		
		return flag;
	}
	
	
     public  ResultSet getDepartmentDetails1(String name) throws EMSException {

		String query="select * from department where name = ?";
		System.out.println("Query   "+ query);
	
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=	ConnectionUtil.getConnection();
			preparedStatement=	   connection.prepareStatement(query);
			
			preparedStatement.setString(1,name);
			
			resultSet= preparedStatement.executeQuery();					
		}
		catch(SQLException e) {
			throw new EMSException(e.getMessage());
		}
		return resultSet;
	}
	
	
	
	public List<DepartmentDetails> getDepartmentDetails() throws EMSException{
		
		List<DepartmentDetails > depList=new ArrayList<DepartmentDetails>();
		int status=0;
		String query="select * from department";
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
				String location=resultSet.getString("location");				
				DepartmentDetails details=new DepartmentDetails(id, name, location);
				depList.add(details);
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
		return depList;
	}
	
		
	public int saveDepDetails(DepartmentDetails departmentDetails) throws EMSException{
		int flag=0;
		String query="insert into department(name, location) values(?,?)";
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
		try{	
	 connection=	ConnectionUtil.getConnection();
	 preparedStatement=	   connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	preparedStatement.setString(1, departmentDetails.getDepname());
	preparedStatement.setString(2,  departmentDetails.getDeplocation());
	
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
