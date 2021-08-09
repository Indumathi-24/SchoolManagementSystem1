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
import com.project.schoolsystem.model.Marks;
import com.project.schoolsystem.util.DBUtil;

public class MarksDAOImpl implements MarksDAO {
	
	static Logger logger = Logger.getLogger("MarksDAOImpl.class");
	public static int getTotalMarks(int tamilMark,int englishMark,int mathsMark,int scienceMark,int socialScienceMark,int evsMark) {
		return tamilMark+englishMark+mathsMark+scienceMark+socialScienceMark+evsMark;
	}
	public void addMarksDetails(Marks marks) {
		logger.info("In Marks DAO");
		logger.info("In Add Marks Details Method");
		try (Connection con = DBUtil.getConnection()) {
			String query = "insert into Marks(student_rollNo,tamil,english,maths,science,social_science,evs,totalMarks) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, marks.getStudentRollNo());
			pst.setInt(2, marks.getTamil());
			pst.setInt(3, marks.getEnglish());
			pst.setInt(4, marks.getMaths());
			pst.setInt(5, marks.getScience());
			pst.setInt(6, marks.getSocialScience());
			pst.setInt(7, marks.getEvs());
			int totalMarks = getTotalMarks(marks.getTamil(),marks.getEnglish(),marks.getMaths(),marks.getScience(),marks.getSocialScience(),marks.getEvs());
			pst.setInt(8, totalMarks);
			pst.executeUpdate();
			System.out.println("Marks Details Inserted");
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
	}

	public List<Marks> readAllMarksDetails() {
		logger.info("In Marks DAO");
		logger.info("In Read All Marks Details Method");
		List<Marks> marksList = new ArrayList<Marks>();
		try (Connection con = DBUtil.getConnection()) {
			Statement st = con.createStatement();
			String query = "select* from Marks";
			ResultSet resultSet = st.executeQuery(query);
			while (resultSet.next()) {
				Marks marks = new Marks();
				marks.setStudentRollNo(resultSet.getInt(1));
				marks.setTamil(resultSet.getInt(2));
				marks.setEnglish(resultSet.getInt(3));
				marks.setMaths(resultSet.getInt(4));
				marks.setScience(resultSet.getInt(5));
				marks.setSocialScience(resultSet.getInt(6));
				marks.setEvs(resultSet.getInt(7));
				marks.setTotalMarks(resultSet.getInt(8));
				marksList.add(marks);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Marks Details of all the students are Retrieved");
		return marksList;

	}

	public Marks readMarksDetailsByStudentRollNo() {
		logger.info("In Marks DAO");
		logger.info("In Read Marks Details Method");
		System.out.print("Enter the roll No of the Student whose Marks has to be retrieved:");
		Scanner sc = new Scanner(System.in);
		Marks marks = new Marks();
		try (Connection con = DBUtil.getConnection()) {
			int rollNo = sc.nextInt();
			if (rollNo < 1) {
				throw new InvalidRollNoException("Roll No is Invalid");
			}
			PreparedStatement st = con.prepareStatement("select* from Marks where student_rollNo=?");
			st.setInt(1, rollNo);
			ResultSet resultSet = st.executeQuery();
			while (resultSet.next()) {
				marks.setStudentRollNo(resultSet.getInt(1));
				marks.setTamil(resultSet.getInt(2));
				marks.setEnglish(resultSet.getInt(3));
				marks.setMaths(resultSet.getInt(4));
				marks.setScience(resultSet.getInt(5));
				marks.setSocialScience(resultSet.getInt(6));
				marks.setEvs(resultSet.getInt(7));
				marks.setTotalMarks(resultSet.getInt(8));
			}
		} catch (SQLException | InvalidRollNoException e) {
			logger.warn(e.getMessage());
		}
		System.out.println("Marks Details of the student Retrieved");
		return marks;

	}

	public void updateMarksDetails() {
		logger.info("In Marks DAO");
		logger.info("In Update Marks Details Method");
		try (Connection con = DBUtil.getConnection()) {
			PreparedStatement pst = null;
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the rollNo of the Student Marks to be modified:");
			int rollNo = scanner.nextInt();
			if (rollNo < 1) {
				throw new InvalidRollNoException("Roll No is Invalid");
			}
			System.out.println("1. Update Tamil");
			System.out.println("2. Update English");
			System.out.println("3. Update Maths");
			System.out.println("4. Update Science");
			System.out.println("5. Update Social Science");
			System.out.println("6. Update EVS");
			System.out.print("Enter user choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.print("Enter the Tamil Marks to be updated:");
				scanner.nextLine();
				String tamil = scanner.nextLine();
				pst = con.prepareStatement("update Marks set tamil=? where student_rollNo=?");
				pst.setString(1, tamil);
				pst.setInt(2, rollNo);
				pst.executeUpdate();
				System.out.println("Rows Updated");
				break;
			}

			case 2: {
				System.out.print("Enter the English Marks to be updated:");
				scanner.nextLine();
				String english = scanner.nextLine();
				pst = con.prepareStatement("update Marks set english=? where student_rollNo=?");
				pst.setString(1, english);
				pst.setInt(2, rollNo);
				pst.executeUpdate();
				System.out.println("Rows Updated");
				break;
			}
			case 3: {
				System.out.println("Enter the Maths Marks to be updated:");
				scanner.nextLine();
				String maths = scanner.nextLine();
				pst = con.prepareStatement("update Marks set maths=? where student_rollNo=?");
				pst.setString(1, maths);
				pst.setInt(2, rollNo);
				pst.executeUpdate();
				System.out.println("Rows Updated");
				break;
			}
			case 4: {
				System.out.print("Enter the Science Marks to be updated:");
				scanner.nextLine();
				String science = scanner.nextLine();
				pst = con.prepareStatement("update Marks set science=? where student_rollNo=?");
				pst.setString(1, science);
				pst.setInt(2, rollNo);
				pst.executeUpdate();
				System.out.println("Rows Updated");
				break;
			}
			case 5: {
				System.out.print("Enter the Social Science Marks to be updated:");
				scanner.nextLine();
				String socialScience = scanner.nextLine();
				pst = con.prepareStatement("update Marks set social_science=? where student_rollNo=?");
				pst.setString(1, socialScience);
				pst.setInt(2, rollNo);
				pst.executeUpdate();
				System.out.println("Rows Updated");
				break;
			}
			case 6: {
				System.out.print("Enter the EVS Marks to be updated:");
				scanner.nextLine();
				String evs = scanner.nextLine();
				pst = con.prepareStatement("update Marks set evs=? where student_rollNo=?");
				pst.setString(1, evs);
				pst.setInt(2, rollNo);
				pst.executeUpdate();
				System.out.println("Rows Updated");
				break;
			}

			default:
				throw new InvalidUserChoiceException("User choice is Invaild");

			}
			int tamil = 0;
			int english = 0;
			int maths = 0;
			int science = 0;
			int socialScience = 0;
			int evs = 0;
			pst=con.prepareStatement("select tamil,english,maths,science,social_science,evs from Marks where student_rollNo=?");
			pst.setInt(1, rollNo);
			ResultSet rs=pst.executeQuery();
            while(rs.next()) {
            	tamil = rs.getInt(1);
				english = rs.getInt(2);
				maths = rs.getInt(3);
				science = rs.getInt(4);
				socialScience = rs.getInt(5);
				evs = rs.getInt(6);
            }
            int totalMarks=getTotalMarks(tamil,english,maths,science,socialScience,evs);
            pst = con.prepareStatement("update marks set totalMarks=? where student_rollNo=?");
			pst.setInt(1, totalMarks);
			pst.setInt(2, rollNo);
			pst.execute();
			System.out.println("Total Marks Updated");
            
		} catch (SQLException | InvalidRollNoException | InvalidUserChoiceException e) {
			logger.warn(e.getMessage());
			e.printStackTrace();
		}
	}

	public void deleteMarksDetails() {
		logger.info("In Marks DAO");
		logger.info("In Delete Marks Details Method");
		try (Connection con = DBUtil.getConnection()) {
			PreparedStatement pst = null;
			System.out.print("Enter the roll no of the Student to be deleted:");
			Scanner scanner = new Scanner(System.in);
			int rollNo = scanner.nextInt();
			if (rollNo < 1) {
				throw new InvalidRollNoException("Roll No is Invalid");
			}
			String query = "delete from Marks where student_rollNo=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, rollNo);
			pst.execute();
			System.out.println("Rows Deleted");
		} catch (SQLException | InvalidRollNoException e) {
			logger.warn(e.getMessage());
		}
	}
}
