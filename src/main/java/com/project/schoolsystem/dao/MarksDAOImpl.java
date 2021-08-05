package com.project.schoolsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidRoomNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Marks;
import com.project.schoolsystem.util.DBUtil;

public class MarksDAOImpl implements MarksDAO{
	public void addMarksDetails(Marks marks) {
		   //logger.info("In Marks DAO");
		   //logger.info("In Add Marks Details Method");
	       try (Connection con=DBUtil.getConnection()){
	    	    String insertQuery="insert into Marks values(?,?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(insertQuery);
				pst.setInt(1, marks.getStudent_rollNo());
				pst.setInt(2, marks.getTamil());
				pst.setInt(3, marks.getEnglish());
				pst.setInt(4, marks.getMaths());
				pst.setInt(5, marks.getScience());
				pst.setInt(6, marks.getSocial_science());
				pst.setInt(7, marks.getEvs());
				pst.executeUpdate();
				System.out.println("Marks Details Inserted");
			} 
	       catch (Exception e) {
				e.printStackTrace();
			}	
		}
	 public List<Marks> readAllMarksDetails() {
		//logger.info("In  Marks DAO");
		//logger.info("In Read All Marks Details Method");
		List<Marks>marksList = new ArrayList<Marks>();
		try (Connection con=DBUtil.getConnection()){
			Statement st = con.createStatement();
			String selectQuery ="select* from Marks";
			ResultSet resultSet=st.executeQuery(selectQuery);
			while(resultSet.next()) {
				Marks marks=new Marks();
				marks.setStudent_rollNo(resultSet.getInt(1));
				marks.setTamil(resultSet.getInt(2));
				marks.setEnglish(resultSet.getInt(3));
				marks.setMaths(resultSet.getInt(4));
				marks.setScience(resultSet.getInt(5));
				marks.setSocial_science(resultSet.getInt(6));
				marks.setEvs(resultSet.getInt(7));
				marksList.add(marks);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Marks Details of all the students are Retrieved");
		return marksList;
		
	  }
			
	 public Marks readMarksDetailsByStudentRollNo() {
		    //logger.info("In  Marks DAO");
			//logger.info("In Read Marks Details Method");
		    System.out.print("Enter the roll No of the Student whose Marks has to be retrieved:");
		    Scanner sc=new Scanner(System.in);
		    int rollNo=sc.nextInt();
		    Marks marks=new Marks();
			try (Connection con=DBUtil.getConnection()){
				PreparedStatement st=con.prepareStatement("select* from Marks where student_rollNo=?");
				st.setInt(1,rollNo);
				ResultSet resultSet=st.executeQuery();
				while(resultSet.next()) {
					marks.setStudent_rollNo(resultSet.getInt(1));
					marks.setTamil(resultSet.getInt(2));
					marks.setEnglish(resultSet.getInt(3));
					marks.setMaths(resultSet.getInt(4));
					marks.setScience(resultSet.getInt(5));
					marks.setSocial_science(resultSet.getInt(6));
					marks.setEvs(resultSet.getInt(7));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Marks Details of the student Retrieved");
			return marks;
			
		  }
	 public void updateMarksDetails() throws InvalidRollNoException,InvalidUserChoiceException{
		    //logger.info("In  Marks DAO");
			//logger.info("In Update Marks Details Method");
	    	try (Connection con=DBUtil.getConnection()){
	    		PreparedStatement pst=null;
	    		Scanner scanner=new Scanner(System.in);
	    		System.out.print("Enter the rollNo of the Student Marks to be modified:");
	    		int rollNo=scanner.nextInt();
	    		if(rollNo<1) {
	    			throw new InvalidRoomNoException("Roll No is Invalid");
	    		}
	    		System.out.println("1. Update Tamil");
	    		System.out.println("2. Update English");
	    		System.out.println("3. Update Maths");
	    		System.out.println("4. Update Science");
	    		System.out.println("5. Update Social Science");
	    		System.out.println("6. Update EVS");
	    		System.out.print("Enter user choice:");
	    		int userChoice=scanner.nextInt();
	    		switch(userChoice) {
	    		case 1:{
	    			   System.out.print("Enter the Tamil Marks to be updated:");
	    		       scanner.nextLine();
	    			   String updateTamil=scanner.nextLine();
	    		       pst=con.prepareStatement("update Marks set tamil=? where student_rollNo=?");
	    		       pst.setString(1, updateTamil);
	    		       pst.setInt(2,rollNo);
	    		       pst.executeUpdate();
	    		       System.out.println("Rows Updated");
	    		       break;
	    		      }
	    		       
	    		case 2:{
	    			   System.out.print("Enter the English Marks to be updated:");
			           scanner.nextLine();
			           String updateEnglish=scanner.nextLine();
			           pst=con.prepareStatement("update Marks set english=? where student_rollNo=?");
			           pst.setString(1, updateEnglish);
			           pst.setInt(2,rollNo);
			           pst.executeUpdate();
			       	   System.out.println("Rows Updated");
			       	   break;
	    		       }
	    		case 3:{
	    			   System.out.println("Enter the Maths Marks to be updated:");
			           scanner.nextLine();
			           String updateMaths=scanner.nextLine();
			           pst=con.prepareStatement("update Marks set maths=? where student_rollNo=?");
			           pst.setString(1, updateMaths);
			           pst.setInt(2,rollNo);
			           pst.executeUpdate();
			       	   System.out.println("Rows Updated");
			       	   break;
	    		       }
	    		case 4:{
	    			   System.out.print("Enter the Science Marks to be updated:");
			           scanner.nextLine();
			           String updateScience=scanner.nextLine();
			           pst=con.prepareStatement("update Marks set science=? where student_rollNo=?");
			           pst.setString(1, updateScience);
			           pst.setInt(2,rollNo);
			           pst.executeUpdate();
			       	   System.out.println("Rows Updated");
			       	   break;
	    		       }
	    		case 5:{
	    			   System.out.print("Enter the Social Science Marks to be updated:");
			           scanner.nextLine();
			           String updateSocialScience=scanner.nextLine();
			           pst=con.prepareStatement("update Marks set social_science=? where student_rollNo=?");
			           pst.setString(1, updateSocialScience);
			           pst.setInt(2,rollNo);
			           pst.executeUpdate();
			       	   System.out.println("Rows Updated");
			       	   break;
	    		       }
	    		case 6:{
	    			   System.out.print("Enter the EVS Marks to be updated:");
			           scanner.nextLine();
			           String updateEVS=scanner.nextLine();
			           pst=con.prepareStatement("update Marks set evs=? where student_rollNo=?");
			           pst.setString(1, updateEVS);
			           pst.setInt(2,rollNo);
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
	 public void deleteMarksDetails() throws InvalidRollNoException {
		    //logger.info("In  Marks DAO");
			//logger.info("In Delete Marks Details Method");
			try(Connection con=DBUtil.getConnection()){
				PreparedStatement pst=null;
				System.out.print("Enter the roll no of the Student to be deleted:");
				Scanner scanner=new Scanner(System.in);
				int rollNo=scanner.nextInt();
				if(rollNo<1) {
					throw new InvalidRoomNoException("Roll No is Invalid");
				}
				String deleteQuery="delete from Marks where student_rollNo=?";
				pst=con.prepareStatement(deleteQuery);
				pst.setInt(1,rollNo);
				pst.execute();
				System.out.println("Rows Deleted");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
}
