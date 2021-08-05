package com.project.schoolsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Student;
import com.project.schoolsystem.util.DBUtil;
public class StudentDAOImpl implements StudentDAO {
	//static Logger logger=Logger.getLogger("StudentDAOImpl.class");
	
	public void addStudentDetails(Student student) {
		   //logger.info("In Student DAO");
		   //logger.info("In Add Student Details Method");
	       try (Connection con=DBUtil.getConnection()){
	    	    String insertQuery="insert into Student values(?,?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(insertQuery);
				pst.setInt(1, student.getStudent_rollNo());
				pst.setString(2,student.getStudent_name() );
				pst.setString(3,student.getStudent_address());
				pst.setString(4, student.getStudent_dob());
				pst.setString(5, student.getStudent_standard());
				pst.setInt(6, student.getClasses_roomNo());
				pst.setInt(7, student.getSchool_id());
				pst.executeUpdate();
				System.out.println("Student Details Inserted");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	 public List<Student> readAllStudentDetails() {
		//logger.info("In  Student DAO");
		//logger.info("In Read All Student Details Method");
		List<Student>studentList=new ArrayList<Student>();
		try (Connection con=DBUtil.getConnection()){
			Statement st=con.createStatement();
			String selectQuery="select* from Student";
			ResultSet resultSet=st.executeQuery(selectQuery);
			while(resultSet.next()) {
				Student student=new Student();
				student.setStudent_rollNo(resultSet.getInt(1));
				student.setStudent_name(resultSet.getString(2));
				student.setStudent_address(resultSet.getString(3));
				student.setStudent_dob(resultSet.getString(4));
				student.setStudent_standard(resultSet.getString(5));
				student.setClasses_roomNo(resultSet.getInt(6));
				student.setSchool_id(resultSet.getInt(7));
				studentList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Student Details Retrieved");
		return studentList;
		
	  }
			
	 public Student readStudentDetailsById() {
		    //logger.info("In  Student DAO");
			//logger.info("In Read Student Details Method");
		    System.out.println("Enter the roll No of the student to be retrieved");
		    Scanner sc=new Scanner(System.in);
		    int rno=sc.nextInt();
		    Student student=new Student();
			try (Connection con=DBUtil.getConnection()){
				PreparedStatement st=con.prepareStatement("select* from Student where rollNo=?");
				st.setInt(1,rno);
				ResultSet resultSet=st.executeQuery();
				while(resultSet.next()) {
					student.setStudent_rollNo(resultSet.getInt(1));
					student.setStudent_name(resultSet.getString(2));
					student.setStudent_address(resultSet.getString(3));
					student.setStudent_dob(resultSet.getString(4));
					student.setStudent_standard(resultSet.getString(5));
					student.setClasses_roomNo(resultSet.getInt(6));
					student.setSchool_id(resultSet.getInt(7));
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Student Details Retrieved");
			return student;
			
		  }
	 public void updateStudentDetails() throws InvalidRollNoException,InvalidUserChoiceException{
		    //logger.info("In  Student DAO");
			//logger.info("In Update Student Details Method");
	    	try (Connection con=DBUtil.getConnection()){
	    		PreparedStatement pst=null;
	    		Scanner scanner=new Scanner(System.in);
	    		System.out.println("Enter the rollNo of the student to be modified");
	    		int rno=scanner.nextInt();
	    		if(rno<1) {
	    			throw new InvalidRollNoException("Roll No is Invalid");
	    		}
	    		System.out.println("1. Update name");
	    		System.out.println("2. Update address");
	    		System.out.println("3. Update dob");
	    		System.out.println("4. Update standard");
	    		System.out.println("Enter user choice");
	    		int userChoice=scanner.nextInt();
	    		switch(userChoice) {
	    		case 1:{
	    			   System.out.println("Enter the name of the student to be updated");
	    		       scanner.nextLine();
	    			   String updateName=scanner.nextLine();
	    		       pst=con.prepareStatement("update Student set student_name=? where student_rollNo=?");
	    		       pst.setString(1, updateName);
	    		       pst.setInt(2,rno);
	    		       pst.executeUpdate();
	    		       System.out.println("Rows Updated");
	    		       break;
	    		      }
	    		       
	    		case 2:{
	    			   System.out.println("Enter the Address of the student to be updated");
			           scanner.nextLine();
			           String updateAddress=scanner.nextLine();
			           pst=con.prepareStatement("update Student set student_address=? where student_rollNo=?");
			           pst.setString(1, updateAddress);
			           pst.setInt(2,rno);
			           pst.executeUpdate();
			       	   System.out.println("Rows Updated");
			       	   break;
	    		       }
	    		
	    		case 3:{
	    			   System.out.println("Enter the dob of the student to be updated");
		           	   scanner.nextLine();
		               String updateDob=scanner.nextLine();
		               pst=con.prepareStatement("update Student set student_dob=? where student_rollNo=?");
		               pst.setString(1, updateDob);
		               pst.setInt(2,rno);
		               pst.executeUpdate();
		       	       System.out.println("Rows Updated");
		       	       break;
	    		      }
		       	      
	    		case 4:{
	    			   System.out.println("Enter the standard of the student to be updated");
		               scanner.nextLine();
		               String updateStandard=scanner.nextLine();
		               pst=con.prepareStatement("update Student set student_standard=? where student_rollNo=?");
		               pst.setString(1, updateStandard);
		               pst.setInt(2,rno);
		               pst.executeUpdate();
		       	       System.out.println("Rows Updated");
		       	       break;
	    		      }
		       	       
		       default:throw new InvalidUserChoiceException("User choice is Invaild");
		               
	    		}
	    		
	    	}
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	 }
	 public void deleteStudentDetails() throws InvalidRollNoException {
		    //logger.info("In  Student DAO");
			//logger.info("In Delete Student Details Method");
			try(Connection con=DBUtil.getConnection()){
				PreparedStatement pst=null;
				System.out.println("Enter the roll no of the student to be deleted");
				Scanner scanner=new Scanner(System.in);
				int rno=scanner.nextInt();
				if(rno<1) {
					throw new InvalidRollNoException("Roll No is Invalid");
				}
				String deleteQuery="delete from Student where student_rollNo=?";
				pst=con.prepareStatement(deleteQuery);
				pst.setInt(1,rno);
				pst.execute();
				System.out.println("Rows Deleted");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
}
