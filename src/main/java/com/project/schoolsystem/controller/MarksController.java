package com.project.schoolsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Marks;
import com.project.schoolsystem.service.MarksService;
import com.project.schoolsystem.service.MarksServiceImpl;

public class MarksController {
	MarksService marksServiceImpl =new MarksServiceImpl(); 
	//static Logger logger=Logger.getLogger("MarksController.class");
    public void addMarksDetails(Marks marks) {
    	//logger.info("In Marks Controller");
    	//logger.info("In Add Marks Details Method");
			
    	marksServiceImpl.addMarksDetails(marks); 
    }
    public List<Marks> readAllMarksDetails() {
    	//logger.info("In  Marks Controller");
    	//logger.info("In Read All Marks Details Method");
    	List<Marks> marksList = new ArrayList<Marks>();
    	try {
			 marksList=marksServiceImpl.readAllMarksDetails();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return marksList;
    	 
     }
    public Marks readMarksDetailsByStudentRollNo() {
    	//logger.info("In  Marks Controller");
    	//logger.info("In Read Marks Details Method");
    	Marks marks = new Marks();
	    marks=marksServiceImpl.readMarksDetailsByStudentRollNo();
		
    	return marks;
    	 
     }
    
		
    public void updateMarksDetails() throws InvalidRollNoException, InvalidUserChoiceException { 
    	//logger.info("In  Marks Controller");
    	//logger.info("In Update Marks Details Method");
		marksServiceImpl.updateMarksDetails();
	 } 
    public void deleteMarksDetails() throws InvalidRollNoException { 
    	//logger.info("In Marks Controller");
    	//logger.info("In Delete Marks Details Method");
        marksServiceImpl.deleteMarksDetails(); 
     	 
    } 
}
