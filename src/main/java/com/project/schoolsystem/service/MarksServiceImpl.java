package com.project.schoolsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project.schoolsystem.dao.MarksDAO;
import com.project.schoolsystem.dao.MarksDAOImpl;
import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidRoomNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Marks;

public class MarksServiceImpl implements MarksService {
	MarksDAO marksDAO = new MarksDAOImpl();

	static Logger logger=Logger.getLogger("MarksServiceImpl.class");
	public void addMarksDetails(Marks marks) {
		logger.info("In Marks Service");
	    logger.info("In Add Marks Details Method");
		marksDAO.addMarksDetails(marks);
	}

	public List<Marks> readAllMarksDetails() {
		logger.info("In Read All Marks Details Method");
		List<Marks> marksList = new ArrayList<Marks>();

		marksList = marksDAO.readAllMarksDetails();

		return marksList;

	}

	public Marks readMarksDetailsByStudentRollNo() {
		 logger.info("In Marks Service");
		 logger.info("In Read Marks Details Method");
		Marks marks = new Marks();

		marks = marksDAO.readMarksDetailsByStudentRollNo();

		return marks;

	}

	public void updateMarksDetails() throws InvalidUserChoiceException, InvalidRollNoException {
		logger.info("In Marks Service");
		logger.info("In Update Marks Details Method");
		marksDAO.updateMarksDetails();

	}

	public void deleteMarksDetails() throws InvalidRollNoException {
		logger.info("In Marks Service");
		logger.info("In Delete Marks Details Method");
		marksDAO.deleteMarksDetails();
	}
}
