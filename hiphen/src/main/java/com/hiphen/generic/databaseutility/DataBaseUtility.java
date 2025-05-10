package com.hiphen.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
 public void getConnection(String url,String username,String password) throws SQLException
 { try {
	 Driver driver =new Driver();
	 DriverManager.registerDriver(driver);
	 con = DriverManager.getConnection(url, username, password);
	 
 }catch(Exception e) { }
 }
 public void getConnection() throws SQLException
 { 
	 Driver driver =new Driver();
	 DriverManager.registerDriver(driver);
	 con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
	 
 
 }
public void closeConnection() throws SQLException
{
	con.close();
}
public ResultSet executeSelectquery( String query) throws SQLException
{
	ResultSet result=null;
	try {
	Statement stat = con.createStatement();
	 result = stat.executeQuery(query);
	}catch(Exception e) { } 
	return result;
	
}
public int executeNonSelectquery( String query) throws SQLException
{
	int result=0;
	try {
	Statement stat = con.createStatement();
	 result = stat.executeUpdate(query);
	}catch(Exception e) { } 
	return result;
	
}
 
}
