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
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Parents;
import com.project.schoolsystem.util.DBUtil;

public class ParentsDAOImpl implements ParentsDAO {
	static Logger logger = Logger.getLogger("ParentsDAOImpl.class");

	public void addParentsDetails(Parents Parents) {
		logger.info("In Parents DAO");
		logger.info("In Add Parents Details Method");
		try (Connection con = DBUtil.getConnection()) {
			String query = "insert into Parents values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, Parents.getStudentRollNo());
			pst.setString(2, Parents.getMotherName());
			pst.setString(3, Parents.getFatherName());
			pst.executeUpdate();
			System.out.println("Parents Details Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Parents> readAllParentsDetails() {
		logger.info("In Parents DAO");
		logger.info("In Read All Parents Details Method");
		List<Parents> parentsList = new ArrayList<Parents>();
		try (Connection con = DBUtil.getConnection()) {
			Statement st = con.createStatement();
			String query = "select* from Parents";
			ResultSet resultSet = st.executeQuery(query);
			while (resultSet.next()) {
				Parents parents = new Parents();
				parents.setStudentRollNo(resultSet.getInt(1));
				parents.setMotherName(resultSet.getString(2));
				parents.setFatherName(resultSet.getString(3));
				parentsList.add(parents);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Parents Details Retrieved");
		return parentsList;

	}

	public Parents readParentsDetailsByStudentRollNo() {
		logger.info("In Parents DAO");
		logger.info("In Read Parents Details Method");
		System.out.println("Enter the roll No of the student whose Parents has to be retrieved");
		Scanner sc = new Scanner(System.in);
		int rno = sc.nextInt();
		Parents parents = new Parents();
		try (Connection con = DBUtil.getConnection()) {
			if (rno < 1) {
				throw new InvalidRollNoException("Roll No is Invalid");
			}
			PreparedStatement st = con.prepareStatement("select* from Parents where student_rollNo=?");
			st.setInt(1, rno);
			ResultSet resultSet = st.executeQuery();
			while (resultSet.next()) {
				parents.setStudentRollNo(resultSet.getInt(1));
				parents.setMotherName(resultSet.getString(2));
				parents.setFatherName(resultSet.getString(3));

			}
		} catch (SQLException | InvalidRollNoException e) {
			logger.info(e.getMessage());
		}
		System.out.println("Parents Details Retrieved");
		return parents;

	}

	public void updateParentsDetails() {
		logger.info("In Parents DAO");
		logger.info("In Update Parents Details Method");
		try (Connection con = DBUtil.getConnection()) {
			PreparedStatement pst = null;
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the rollNo of the Parents to be modified");
			int rno = scanner.nextInt();
			if (rno < 1) {
				throw new InvalidRollNoException("Roll No is Invalid");
			}
			System.out.println("1. Update mother name");
			System.out.println("2. Update father name");
			System.out.println("Enter user choice");
			int userChoice = scanner.nextInt();
			switch (userChoice) {
			case 1: {
				System.out.println("Enter the mother name to be updated");
				scanner.nextLine();
				String motherName = scanner.nextLine();
				pst = con.prepareStatement("update Parents set mother_name=? where student_rollNo=?");
				pst.setString(1, motherName);
				pst.setInt(2, rno);
				pst.executeUpdate();
				System.out.println("Rows Updated");
				break;
			}

			case 2: {
				System.out.println("Enter the Father name to be updated");
				scanner.nextLine();
				String fatherName = scanner.nextLine();
				pst = con.prepareStatement("update Parents set father_name=? where student_rollNo=?");
				pst.setString(1, fatherName);
				pst.setInt(2, rno);
				pst.executeUpdate();
				System.out.println("Rows Updated");
				break;
			}
			default:
				throw new InvalidUserChoiceException("User choice is Invaild");

			}

		} catch (SQLException | InvalidRollNoException | InvalidUserChoiceException e) {
			logger.warn(e.getMessage());
		}
	}

	public void deleteParentsDetails() {
		logger.info("In Parents DAO");
		logger.info("In Delete Parents Details Method");
		try (Connection con = DBUtil.getConnection()) {
			PreparedStatement pst = null;
			System.out.println("Enter the roll no of the student whose parents has to be deleted");
			Scanner scanner = new Scanner(System.in);
			int rno = scanner.nextInt();
			if (rno < 1) {
				throw new InvalidRollNoException("Roll No is Invalid");
			}
			String query = "delete from Parents where student_rollNo=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, rno);
			pst.execute();
			System.out.println("Rows Deleted");
		} catch (SQLException | InvalidRollNoException e) {
			logger.warn(e.getMessage());
		}
	}

}
