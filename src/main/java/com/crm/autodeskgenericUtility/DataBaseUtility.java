package com.crm.autodeskgenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection connection;
	/**
	 * This method will establish the connection between java and database
	 * @throws SQLException
	 */
	public void connectToDB() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection(IPathConstants.DATABASE_URL, IPathConstants.DB_USERNAME,IPathConstants.DB_PASSWORD);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public void closeDB() throws SQLException {
	connection.close();
	
}
/**
 * This method will return all the data from database
 * @param query
 * @return
 */
public ResultSet getAllData(String query) {

	try {
		ResultSet result = connection.createStatement().executeQuery(query);
		return result;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	return null;
	}	
	
}
/**
 * this method will return true if data is added to database 
 * @param query
 * @return
 */
public boolean insertData(String query ) {
	boolean flag=false;
	
	try {
	int	result = connection.createStatement().executeUpdate(query);
	if(result==1) {
		System.out.println("data is added");
		flag= true;
		return flag;
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("data is not added");
		return flag;
	}
	return flag;
}
}
