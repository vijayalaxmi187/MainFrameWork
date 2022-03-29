package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class Sample_NonSelect_Sql_Query_Execution {
	public static void main(String[] args) throws Exception {
		Connection conn= null;
		int result= 0;
		try {
		
	//step1:load/register the database
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	
	//step2:connect to database
	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
	 System.out.println("connection is done");
	
	//step3:create query statement
	Statement stat = conn.createStatement();
	
	//step4:execute query
	String query = "insert into students_info values('5','deep','gowdu','h')";
	
	 result = stat.executeUpdate(query);
		}catch(Exception e) {
		}finally {
			//TODO:handle exception
	if(result==1) {
		System.out.println("inserted successfully==PASS");
	}else {
		System.out.println("failed to create==FAIL");
	}

	//step5:close the db connection
	conn.close();
	System.out.println("==========close db connection=============");
	}

}
}
