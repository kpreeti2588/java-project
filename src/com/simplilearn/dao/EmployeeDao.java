package com.simplilearn.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.simplilearn.exception.EMSException;
import com.simplilearn.model.EmployeeDetails;
import com.simplilearn.util.ConnectionUtil;

public class EmployeeDao {

	private EmployeeDao() {
		// TODO Auto-generated constructor stub
	}
    
	static Logger logger = Logger.getLogger(EmployeeDao.class); 
	
	private static EmployeeDao employeeDao=null;
	public static EmployeeDao getEmpDao(){
		if(employeeDao==null){
			
			employeeDao=new EmployeeDao();
			
			logger.info("Employee Object created");
		}
		return employeeDao;
		
	}
	
	

	public int deleteEmpDetails(int id) throws EMSException{	
		int flag=0;
		String query="delete from employee where id=?";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
			try{	
		 connection=	ConnectionUtil.getConnection();
		
		 //start
		 connection.setAutoCommit(false);
		 preparedStatement=	   connection.prepareStatement(query);
		
		preparedStatement.setInt(1, id);
		
		flag=preparedStatement.executeUpdate();
		
		connection.commit();
		//end transaction
	//	System.out.println("deleted="+flag);
		logger.info("deleted="+flag);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage(), e);
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
			//	System.out.println("error while closing");
				logger.error(e.getMessage(), e);
			// rollback transaction
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
				throw new EMSException(e1.getMessage());
			}
			
			}
			
		}
				
		return flag;
	}
	
	
	public int updateEmpDetails(EmployeeDetails employeeDetails) throws EMSException {
		
		int flag=0;
		String query="update employee set phone=? ,salary=? where id=?";
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
			try{	
		 connection=	ConnectionUtil.getConnection();
		 preparedStatement=	   connection.prepareStatement(query);
		
		preparedStatement.setString(1, employeeDetails.getPhone());
		preparedStatement.setFloat(2, employeeDetails.getSalary());
		preparedStatement.setInt(3, employeeDetails.getId());
		
		flag=preparedStatement.executeUpdate();
		
		
		System.out.println("updated="+flag);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error(e.getMessage(), e);
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
				logger.error(e.getMessage(), e);
				System.out.println("error while closing");
				
				throw new EMSException(e.getMessage());
			}
			
		}
		return flag;
	}
	
	
     public  ResultSet getEmpDetails1(String name) throws EMSException{

		String query="select * from employee where name = ?";
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
			logger.error(e.getMessage(), e);
			throw new EMSException(e.getMessage());
		}
		return resultSet;
	}
	
	
	public List<EmployeeDetails> getEmpDetails() throws EMSException {
		
		List<EmployeeDetails > emmpList=new ArrayList<EmployeeDetails>();
		int status=0;
		String query="select * from employee";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try{	
			 connection=	ConnectionUtil.getConnection();
			 preparedStatement=	   connection.prepareStatement(query);
             
			 resultSet = preparedStatement.executeQuery();
			
			 while(resultSet.next()){
				//getting user name db given after select executed
				int id= resultSet.getInt("id");
				String name=resultSet.getString("name");
				float salary=resultSet.getFloat("salary");

				String phone=resultSet.getString("phone");
				char gender=resultSet.getString("gender").charAt(0);
				String dob=resultSet.getString("dob");
				
				String designation=resultSet.getString("designation");
				int dep_id = resultSet.getInt("dep_id");
				
				EmployeeDetails details=new EmployeeDetails(id, name, salary, phone, gender, dob, designation, dep_id);
				emmpList.add(details);		
				
			}
		
			//System.out.println("inserted="+flag);
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage(), e);
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
					logger.error(e.getMessage(), e);
					System.out.println("error while closing");
					throw new EMSException(e.getMessage());
				}
				
			}
			
		return emmpList;
	}
	
	
	
	
	public int validateUserDetails(String username,String password) throws EMSException {
		int status=0;
		String query="select username,password from login where username=? and password=?";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try{	
			 connection=	ConnectionUtil.getConnection();
			 preparedStatement=	   connection.prepareStatement(query);
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
// execute select qury
			
			 resultSet= preparedStatement.executeQuery();
			//select qury is retutn only 1 recored becuse username is unique
			// if query returns multiplle records
			 //then while loop comes other wise if stmt comes
			 //above select return 2 column username and password
			 if(resultSet.next()){
				//getting user name db given after select executed
				//String name=resultSet.getString("ussername");
				//String password=resultSet.getString("password");
				  // we dont need user andm passwird we dont want to share
				// we return 0 or 1
				 
				 status=1;
				
				
				
				
				
				
			}
			 
			 
			
			//System.out.println("inserted="+flag);
			
			
			
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage(), e);
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
					logger.error(e.getMessage(), e);
					System.out.println("error while closing");
					throw new EMSException(e.getMessage());
				}
				
			}

		return status;
	
	}
	
	
	
	public int saveEmpDetails(EmployeeDetails employeeDetails) throws EMSException{
		int flag=0;
		String query="insert into employee(name, salary, gender, phone, dob, designation, dep_id) values(?,?,?,?,?,?,?)";
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
		try{	
	 connection=	ConnectionUtil.getConnection();
	 preparedStatement=	   connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	preparedStatement.setString(1, employeeDetails.getName());
	preparedStatement.setFloat(2, employeeDetails.getSalary());
	preparedStatement.setString(3, ""+employeeDetails.getGender());
	preparedStatement.setString(4, employeeDetails.getPhone());		
	preparedStatement.setObject(5, employeeDetails.getDob());
	preparedStatement.setString(6, employeeDetails.getDesignation());
	preparedStatement.setInt(7, employeeDetails.getDep_id());
	logger.info(query);
	flag=preparedStatement.executeUpdate();
	
	 resultSet=preparedStatement.getGeneratedKeys();
	
	System.out.println("inserted="+flag);
	logger.info("inserted="+flag);
	
	if(resultSet.next()){
		
	flag=	resultSet.getInt(1);
		
	}
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		logger.error(e.getMessage(), e);
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
			logger.error(e.getMessage(), e);
			System.out.println("error while closing");
			throw new EMSException(e.getMessage());
		}
		
	}
	
		return flag;
		
		
	}
	
	
}
