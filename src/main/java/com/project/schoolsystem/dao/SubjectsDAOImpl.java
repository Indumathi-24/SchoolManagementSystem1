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

import com.project.schoolsystem.exceptions.InvalidIdException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Subjects;
import com.project.schoolsystem.util.DBUtil;

public class SubjectsDAOImpl implements SubjectsDAO {
	static Logger logger = Logger.getLogger("SubjectsDAOImpl.class");

	public void addSubjectsDetails(Subjects subjects) {
		logger.info("In Subjects DAO");
		logger.info("In Add Subjects Details Method");
		try (Connection con = DBUtil.getConnection()) {
			String query = "insert into Subjects values(?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, subjects.getSubjectId());
			pst.setString(2, subjects.getSubjectName());
			pst.executeUpdate();
			System.out.println("Subjects Details Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Subjects> readAllSubjectsDetails() {
		logger.info("In Subjects DAO");
		logger.info("In Read All Subjects Details Method");
		List<Subjects> subjectsList = new ArrayList<Subjects>();
		try (Connection con = DBUtil.getConnection()) {
			Statement st = con.createStatement();
			String query = "select* from Subjects";
			ResultSet resultSet = st.executeQuery(query);
			while (resultSet.next()) {
				Subjects subjects = new Subjects();
				subjects.setSubjectId(resultSet.getInt(1));
				subjects.setSubjectName(resultSet.getString(2));
				subjectsList.add(subjects);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Subjects Details Retrieved");
		return subjectsList;

	}

	public Subjects readSubjectsDetailsBySubjectId() {
		logger.info("In Subjects DAO");
		logger.info("In Read Subjects Details Method");
		System.out.print("Enter the id of the Subjects to be retrieved:");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		Subjects subjects = new Subjects();
		try (Connection con = DBUtil.getConnection()) {
			if (id < 1) {
				throw new InvalidIdException("Id is invalid");
			}
			PreparedStatement st = con.prepareStatement("select* from Subjects where subject_id=?");
			st.setInt(1, id);
			ResultSet resultSet = st.executeQuery();
			while (resultSet.next()) {
				subjects.setSubjectId(resultSet.getInt(1));
				subjects.setSubjectName(resultSet.getString(2));
			}
		} catch (SQLException | InvalidIdException e) {
			logger.warn(e.getMessage());
		}
		System.out.println("Subjects Details Retrieved");
		return subjects;

	}

	public void updateSubjectsDetails() {
		logger.info("In Subjects DAO");
		logger.info("In Update Subjects Details Method");
		try (Connection con = DBUtil.getConnection()) {
			PreparedStatement pst = null;
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the id of the Subjects to be modified:");
			int id = scanner.nextInt();
			if (id < 1) {
				throw new InvalidIdException("Id is Invalid");
			}
			System.out.println("1. Update subject_name");
			System.out.println("Enter user choice");
			int userChoice = scanner.nextInt();
			switch (userChoice) {
			case 1: {
				System.out.println("Enter the standard of the Subjects to be updated:");
				scanner.nextLine();
				String subjectName = scanner.nextLine();
				pst = con.prepareStatement("update Subjects set subject_name=? where subject_id=?");
				pst.setString(1, subjectName);
				pst.setInt(2, id);
				pst.executeUpdate();
				System.out.println("Rows Updated");
				break;
			}
			default:
				throw new InvalidUserChoiceException("User choice is Invaild");

			}
		} catch (SQLException | InvalidUserChoiceException | InvalidIdException e) {
			logger.warn(e.getMessage());
		}
	}

	public void deleteSubjectsDetails() {
		logger.info("In Subjects DAO");
		logger.info("In Delete Subjects Details Method");
		try (Connection con = DBUtil.getConnection()) {
			PreparedStatement pst = null;
			System.out.print("Enter the id of the Subjects to be deleted:");
			Scanner scanner = new Scanner(System.in);
			int id = scanner.nextInt();
			if (id < 1) {
				throw new InvalidIdException("Id is Invalid");
			}
			String query = "delete from Subjects where subject_id=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.execute();
			System.out.println("Rows Deleted");
		} catch (SQLException | InvalidIdException e) {
			logger.warn(e.getMessage());
		}
	}
}
