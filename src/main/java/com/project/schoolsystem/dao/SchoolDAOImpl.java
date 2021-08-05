package com.project.schoolsystem.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


import com.project.schoolsystem.model.School;
import com.project.schoolsystem.util.DBUtil;

public class SchoolDAOImpl implements SchoolDAO {
	//static Logger logger=Logger.getLogger("SchoolDAOImpl.class");
	
		public void addSchoolDetails(School school) {
			   //logger.info("In School DAO");
			   //logger.info("In Add School Details Method");
		       try (Connection con=DBUtil.getConnection()){
		    	    String insertQuery="insert into School values(?,?,?)";
					PreparedStatement pst=con.prepareStatement(insertQuery);
					pst.setInt(1, school.getSchool_id());
					pst.setString(2,school.getSchool_name());
					pst.setString(3,school.getSchool_address());
					pst.executeUpdate();
					System.out.println("School Details Inserted");
				} 
		       catch (Exception e) {
					e.printStackTrace();
				}	
			}
		 public School readSchoolDetails() {
			//logger.info("In  School DAO");
			//logger.info("In Read All School Details Method");
			School school =new School();
			try (Connection con=DBUtil.getConnection()){
				Statement st=con.createStatement();
				String selectQuery="select* from School";
				ResultSet resultSet=st.executeQuery(selectQuery);
				while(resultSet.next()) {
					school.setSchool_id(resultSet.getInt(1));
					school.setSchool_name(resultSet.getString(2));
					school.setSchool_address(resultSet.getString(3));		
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("School Details Retrieved");
			return school;
			
		  }
				
}
