package com.project.schoolsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.schoolsystem.exceptions.InvalidIdException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Subjects;
import com.project.schoolsystem.util.DBUtil;

public class SubjectsDAOImpl implements SubjectsDAO {
	public void addSubjectsDetails(Subjects Subjects) {
		   //logger.info("In Subjects DAO");
		   //logger.info("In Add Subjects Details Method");
	       try (Connection con=DBUtil.getConnection()){
	    	    String insertQuery="insert into Subjects values(?,?)";
				PreparedStatement pst=con.prepareStatement(insertQuery);
				pst.setInt(1, Subjects.getSubject_id());
				pst.setString(2,Subjects.getSubject_name());
				pst.executeUpdate();
				System.out.println("Subjects Details Inserted");
			} 
	       catch (Exception e) {
				e.printStackTrace();
			}	
		}
	 public List<Subjects> readAllSubjectsDetails() {
		//logger.info("In  Subjects DAO");
		//logger.info("In Read All Subjects Details Method");
		List<Subjects> subjectsList = new ArrayList<Subjects>();
		try (Connection con=DBUtil.getConnection()){
			Statement st = con.createStatement();
			String selectQuery ="select* from Subjects";
			ResultSet resultSet=st.executeQuery(selectQuery);
			while(resultSet.next()) {
				Subjects subjects=new Subjects();
				subjects.setSubject_id(resultSet.getInt(1));
				subjects.setSubject_name(resultSet.getString(2));
				subjectsList.add(subjects);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Subjects Details Retrieved");
		return subjectsList;
		
	  }
			
	 public Subjects readSubjectsDetailsBySubjectId() {
		    //logger.info("In  Subjects DAO");
			//logger.info("In Read Subjects Details Method");
		    System.out.print("Enter the id of the Subjects to be retrieved:");
		    Scanner sc=new Scanner(System.in);
		    int id=sc.nextInt();
		    Subjects subjects=new Subjects();
			try (Connection con=DBUtil.getConnection()){
				PreparedStatement st=con.prepareStatement("select* from Subjects where subject_id=?");
				st.setInt(1,id);
				ResultSet resultSet=st.executeQuery();
				while(resultSet.next()) {
					subjects.setSubject_id(resultSet.getInt(1));
					subjects.setSubject_name(resultSet.getString(2));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Subjects Details Retrieved");
			return subjects;
			
		  }
	 public void updateSubjectsDetails() throws InvalidIdException,InvalidUserChoiceException{
		    //logger.info("In  Subjects DAO");
			//logger.info("In Update Subjects Details Method");
	    	try (Connection con=DBUtil.getConnection()){
	    		PreparedStatement pst=null;
	    		Scanner scanner=new Scanner(System.in);
	    		System.out.print("Enter the id of the Subjects to be modified:");
	    		int id=scanner.nextInt();
	    		if(id<1) {
	    			throw new InvalidIdException("Id is Invalid");
	    		}
	    		System.out.println("1. Update subject_name");
	    		System.out.println("Enter user choice");
	    		int userChoice=scanner.nextInt();
	    		switch(userChoice) {
	    		case 1:{
	    			   System.out.println("Enter the standard of the Subjects to be updated:");
	    		       scanner.nextLine();
	    			   String updateSubjectName=scanner.nextLine();
	    		       pst=con.prepareStatement("update Subjects set subject_name=? where subject_id=?");
	    		       pst.setString(1, updateSubjectName);
	    		       pst.setInt(2,id);
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
	 public void deleteSubjectsDetails() throws InvalidIdException {
		    //logger.info("In  Subjects DAO");
			//logger.info("In Delete Subjects Details Method");
			try(Connection con=DBUtil.getConnection()){
				PreparedStatement pst=null;
				System.out.print("Enter the id of the Subjects to be deleted:");
				Scanner scanner=new Scanner(System.in);
				int id=scanner.nextInt();
				if(id<1) {
					throw new InvalidIdException("Id is Invalid");
				}
				String deleteQuery="delete from Subjects where subject_id=?";
				pst=con.prepareStatement(deleteQuery);
				pst.setInt(1,id);
				pst.execute();
				System.out.println("Rows Deleted");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
}
