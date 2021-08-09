package com.project.schoolsystem.controller;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;
import com.project.schoolsystem.model.Marks;
import com.project.schoolsystem.service.MarksService;
import com.project.schoolsystem.service.MarksServiceImpl;

public class MarksController {
	MarksService marksServiceImpl = new MarksServiceImpl();

	static Logger logger = Logger.getLogger("MarksController.class");

	public void addMarksDetails(Marks marks) {
		logger.info("In Marks Controller");
		logger.info("In Add Marks Details Method");

		marksServiceImpl.addMarksDetails(marks);
	}

	public List<Marks> readAllMarksDetails() {
		logger.info("In Marks Controller");
		logger.info("In Read All Marks Details Method");
		List<Marks> marksList = new ArrayList<Marks>();
		marksList = marksServiceImpl.readAllMarksDetails();
		return marksList;

	}

	public Marks readMarksDetailsByStudentRollNo() {
		logger.info("In Marks Controller");
		logger.info("In Read Marks Details Method");
		Marks marks = new Marks();
		marks = marksServiceImpl.readMarksDetailsByStudentRollNo();

		return marks;

	}

	public void updateMarksDetails() {
		logger.info("In Marks Controller");
		logger.info("In Update Marks Details Method");
		marksServiceImpl.updateMarksDetails();
	}

	public void deleteMarksDetails() {
		logger.info("In Marks Controller");
		logger.info("In Delete Marks Details Method");
		marksServiceImpl.deleteMarksDetails();

	}
}
