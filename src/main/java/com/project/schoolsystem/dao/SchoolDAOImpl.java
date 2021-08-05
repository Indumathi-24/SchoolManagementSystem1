package com.project.schoolsystem.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.schoolsystem.model.School;
import com.project.schoolsystem.util.DBUtil;

public class SchoolDAOImpl implements SchoolDAO {
    static Logger logger=Logger.getLogger("SchoolDAOImpl.class");

	public void addSchoolDetails(School school) {
		 logger.info("In School DAO");
		 logger.info("In Add School Details Method");
		try (Connection con = DBUtil.getConnection()) {
			String query = "insert into School values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, school.getSchoolId());
			pst.setString(2, school.getSchoolName());
			pst.setString(3, school.getSchoolAddress());
			pst.executeUpdate();
			System.out.println("School Details Inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public School readSchoolDetails() {
		 logger.info("In School DAO");
		 logger.info("In Read All School Details Method");
		School school = new School();
		try (Connection con = DBUtil.getConnection()) {
			Statement st = con.createStatement();
			String query = "select* from School";
			ResultSet resultSet = st.executeQuery(query);
			while (resultSet.next()) {
				school.setSchoolId(resultSet.getInt(1));
				school.setSchoolName(resultSet.getString(2));
				school.setSchoolAddress(resultSet.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("School Details Retrieved");
		return school;

	}

}
