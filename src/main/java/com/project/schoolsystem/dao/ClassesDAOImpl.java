package com.project.schoolsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidRoomNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Classes;
import com.project.schoolsystem.util.DBUtil;

public class ClassesDAOImpl implements ClassesDAO {
	static Logger logger=Logger.getLogger("ClassesDAOImpl.class");
	public void addClassesDetails(Classes classes) {
		logger.info("In classes DAO");
		logger.info("In Add classes Details Method");
		try (Connection con = DBUtil.getConnection()) {
			String query = "insert into Classes values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, classes.getClassesRoomNo());
			pst.setString(2, classes.getStandard());
			pst.setString(3, classes.getSection());
			pst.executeUpdate();
			System.out.println("Classes Details Inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Classes> readAllClassesDetails() {
		logger.info("In classes DAO");
		logger.info("In Read All classes Details Method");
		List<Classes> classesList = new ArrayList<Classes>();
		try (Connection con = DBUtil.getConnection()) {
			Statement st = con.createStatement();
			String query = "select* from Classes";
			ResultSet resultSet = st.executeQuery(query);
			while (resultSet.next()) {
				Classes classes = new Classes();
				classes.setClassesRoomNo(resultSet.getInt(1));
				classes.setStandard(resultSet.getString(2));
				classes.setSection(resultSet.getString(3));
				classesList.add(classes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Classes Details Retrieved");
		return classesList;

	}

	public Classes readClassesDetailsByRoomNo() {
		 logger.info("In classes DAO");
		 logger.info("In Read classes Details Method");
		System.out.print("Enter the room No of the classes to be retrieved:");
		Scanner sc = new Scanner(System.in);
		int roomNo = sc.nextInt();
		Classes classes = new Classes();
		try (Connection con = DBUtil.getConnection()) {
			PreparedStatement st = con.prepareStatement("select* from Classes where classesRoomNo=?");
			st.setInt(1, roomNo);
			ResultSet resultSet = st.executeQuery();
			while (resultSet.next()) {
				classes.setClassesRoomNo(resultSet.getInt(1));
				classes.setStandard(resultSet.getString(2));
				classes.setSection(resultSet.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("classes Details Retrieved");
		return classes;

	}

	public void updateClassesDetails() throws InvalidRoomNoException, InvalidUserChoiceException {
		logger.info("In classes DAO");
		logger.info("In Update classes Details Method");
		try (Connection con = DBUtil.getConnection()) {
			PreparedStatement pst = null;
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the roomNo of the classes to be modified:");
			int roomNo = scanner.nextInt();
			if (roomNo < 1) {
				throw new InvalidRoomNoException("Room No is Invalid");
			}
			System.out.println("1. Update standard");
			System.out.println("2. Update section");
			System.out.println("Enter user choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the standard of the classes to be updated:");
				scanner.nextLine();
				String standard = scanner.nextLine();
				pst = con.prepareStatement("update classes set standard=? where classesRoomNo=?");
				pst.setString(1, standard);
				pst.setInt(2, roomNo);
				pst.executeUpdate();
				System.out.println("Rows Updated");
				break;
			}

			case 2: {
				System.out.println("Enter the Section of the classes to be updated:");
				scanner.nextLine();
				String section = scanner.nextLine();
				pst = con.prepareStatement("update classes set section=? where classesRoomNo=?");
				pst.setString(1, section);
				pst.setInt(2, roomNo);
				pst.executeUpdate();
				System.out.println("Rows Updated");
				break;
			}

			default:
				throw new InvalidUserChoiceException("User choice is Invaild");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteClassesDetails(){
		logger.info("In classes DAO");
		logger.info("In Delete classes Details Method");
		try (Connection con = DBUtil.getConnection()) {
			PreparedStatement pst = null;
			System.out.print("Enter the room no of the classes to be deleted:");
			Scanner scanner = new Scanner(System.in);
			int roomNo = scanner.nextInt();
			if (roomNo < 1) {
				throw new InvalidRoomNoException("Room No is Invalid");
			}
			String query = "delete from classes where classesRoomNo=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, roomNo);
			pst.execute();
			System.out.println("Rows Deleted");
		} catch (SQLException | InvalidRoomNoException e) {
			System.out.println(e.getMessage());
		}
	}
}
