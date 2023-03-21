package empapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.*;

public class EmployeeImpl implements EmployeeInterface{
	Connection connection;
	
	
	//----------------create employee method------------
	@Override
	public void createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		connection=DBConnection.createDBConnection();
		String query="insert into employee values(?,?,?,?)";
		
		try {
			PreparedStatement pstm=connection.prepareStatement(query);
			pstm.setInt(1,emp.getId());
			pstm.setString(2,emp.getName());
			pstm.setDouble(3,emp.getSalary());
			pstm.setInt(4,emp.getAge());
			int cnt=pstm.executeUpdate();
			if(cnt!=0) {
				System.out.println("Employee inserted successfully");
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
}
		}
		
	
	    //-------------------show all employees method-----------------                                                
	@Override
	public void showAllEmployee() {
		// TODO Auto-generated method stub
		
		connection=DBConnection.createDBConnection();
		String query="select * from employee";
		System.out.println("\nEmployee Details:");
		System.out.println("------------------------------------");	
		System.out.format("%s\t%s\t%s\t%s\n","ID","NAME","SALARY","\tAGE");
		System.out.println("------------------------------------");	
		
		try {
		Statement stmt=connection.createStatement();
		ResultSet result=stmt.executeQuery(query);
		while(result.next()) {
			
			System.out.format("%d\t%s\t%f\t%d\n",
					result.getInt(1),
					result.getString(2),
					result.getDouble(3),
					result.getInt(4));
		}
		
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
//-------------------------show all employees based on id---------------------
	@Override
	public void showEmployeeBasedOnId(int id) {
		// TODO Auto-generated method stub
		
		connection=DBConnection.createDBConnection();
			     //eid column in employee table 
				//which is created in main method to accept id from user 
		String query="select * from employee where id="+id;
		 
		try {
			Statement stmt=connection.createStatement();
			ResultSet result=stmt.executeQuery(query);
			while(result.next()) {
				
				System.out.format("%d\t%s\t%f\t%d\n",
						result.getInt(1),
						result.getString(2),
						result.getDouble(3),
						result.getInt(4));
			}
			
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
	}
	
//--------------------------update employee details-----------------------------

	@Override
	public void updateEmployee(int id, String name) {
		// TODO Auto-generated method stub
		
		connection=DBConnection.createDBConnection();
		String query="update employee set name=? where id=?";
		try {
			PreparedStatement pstm=connection.prepareStatement(query);
			pstm.setString(1,name);
			pstm.setInt(2,id);
			int cnt=pstm.executeUpdate();
			if(cnt!=0) {
				System.out.println("Employee details updated successfully");
			}else 
				System.out.println("record not found!");
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	//--------------------------update employee details-----------------------------
	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		connection=DBConnection.createDBConnection();
		String query="delete from employee where id=?";
		try {
			PreparedStatement pstm=connection.prepareStatement(query);
			pstm.setInt(1,id);
			int cnt=pstm.executeUpdate();
			if(cnt!=0) {
				System.out.println("Employee deleted  successfully");
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	
	
}