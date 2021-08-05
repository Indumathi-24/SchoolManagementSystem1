package com.project.schoolsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Parents;
import com.project.schoolsystem.util.DBUtil;

public class ParentsDAOImpl implements ParentsDAO {
	// static Logger logger=Logger.getLogger("ParentsDAOImpl.class");

	public void addParentsDetails(Parents Parents) {
		// logger.info("In Parents DAO");
		// logger.info("In Add Parents Details Method");
		try (Connection con = DBUtil.getConnection()) {
			String insertQuery = "insert into Parents values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(insertQuery);
			pst.setInt(1, Parents.getStudent_rollNo());
			pst.setString(2, Parents.getMother_name());
			pst.setString(3, Parents.getFather_name());
			pst.executeUpdate();
			System.out.println("Parents Details Inserted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Parents> readAllParentsDetails() {
		// logger.info("In Parents DAO");
		// logger.info("In Read All Parents Details Method");
		List<Parents> parentsList = new ArrayList<Parents>();
		try (Connection con = DBUtil.getConnection()) {
			Statement st = con.createStatement();
			String selectQuery = "select* from Parents";
			ResultSet resultSet = st.executeQuery(selectQuery);
			while (resultSet.next()) {
				Parents parents = new Parents();
				parents.setStudent_rollNo(resultSet.getInt(1));
				parents.setMother_name(resultSet.getString(2));
				parents.setFather_name(resultSet.getString(3));
				parentsList.add(parents);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Parents Details Retrieved");
		return parentsList;

	}

	public Parents readParentsDetailsByStudentRollNo() {
		// logger.info("In Parents DAO");
		// logger.info("In Read Parents Details Method");
		System.out.println("Enter the roll No of the student whose Parents has to be retrieved");
		Scanner sc = new Scanner(System.in);
		int rno = sc.nextInt();
		Parents parents = new Parents();
		try (Connection con = DBUtil.getConnection()) {
			PreparedStatement st = con.prepareStatement("select* from Parents where student_rollNo=?");
			st.setInt(1, rno);
			ResultSet resultSet = st.executeQuery();
			while (resultSet.next()) {
				parents.setStudent_rollNo(resultSet.getInt(1));
				parents.setMother_name(resultSet.getString(2));
				parents.setFather_name(resultSet.getString(3));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Parents Details Retrieved");
		return parents;

	}

	public void updateParentsDetails() throws InvalidRollNoException, InvalidUserChoiceException {
		// logger.info("In Parents DAO");
		// logger.info("In Update Parents Details Method");
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
				String updateMotherName = scanner.nextLine();
				pst = con.prepareStatement("update Parents set mother_name=? where student_rollNo=?");
				pst.setString(1, updateMotherName);
				pst.setInt(2, rno);
				pst.executeUpdate();
				System.out.println("Rows Updated");
				break;
			}

			case 2: {
				System.out.println("Enter the Father name to be updated");
				scanner.nextLine();
				String updateFatherName = scanner.nextLine();
				pst = con.prepareStatement("update Parents set father_name=? where student_rollNo=?");
				pst.setString(1, updateFatherName);
				pst.setInt(2, rno);
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

	public void deleteParentsDetails() throws InvalidRollNoException {
		// logger.info("In Parents DAO");
		// logger.info("In Delete Parents Details Method");
		try (Connection con = DBUtil.getConnection()) {
			PreparedStatement pst = null;
			System.out.println("Enter the roll no of the student whose parents has to be deleted");
			Scanner scanner = new Scanner(System.in);
			int rno = scanner.nextInt();
			if (rno < 1) {
				throw new InvalidRollNoException("Roll No is Invalid");
			}
			String deleteQuery = "delete from Parents where student_rollNo=?";
			pst = con.prepareStatement(deleteQuery);
			pst.setInt(1, rno);
			pst.execute();
			System.out.println("Rows Deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
