package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Sample_Select_Sql_Query_Execution1 {
	public static void main(String[] args) throws Exception {
		
	//step1:load/register the database
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	
	//step2:connect to database
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root", "root");
	
	//step3:create  query statement
	Statement stat = conn.createStatement();
	
	//step4:execute query
	String query = "select * from students_info";
	ResultSet result = stat.executeQuery(query);
	while(result.next()) {
		System.out.println(result.getInt(1)+ "\t" +result.getString(2)+ "/t" +result.getString(3)+ "\t" +result.getString(4));
	}
	//step5:close the db connection
	conn.close();
	}

}
