package com.project.schoolsystem.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
public static  Connection getConnection()  throws Exception{
		
		FileInputStream fileStream = new FileInputStream("C:\\Users\\IndumathiK\\OneDrive - revature.com\\Desktop\\SchoolManagementSystem\\src\\main\\java\\jdbc.properties"); 
		Properties properties = new Properties(); 
		properties.load(fileStream);
		String url = properties.getProperty("url");	
		String id = properties.getProperty("id"); 
		String pwd = properties.getProperty("pwd"); 
	
		  Connection con = DriverManager.getConnection(url,id,pwd); 

	            
	            return con;
	}
}
