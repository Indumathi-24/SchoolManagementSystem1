package com.project.schoolsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Parents;
import com.project.schoolsystem.service.ParentsService;
import com.project.schoolsystem.service.ParentsServiceImpl;

public class ParentsController {
	ParentsService parentsServiceImpl = new ParentsServiceImpl();

	// static Logger logger=Logger.getLogger("ParentsController.class");
	public void addParentsDetails(Parents Parents) {
		// logger.info("In Parents Controller");
		// logger.info("In Add Parents Details Method");
		parentsServiceImpl.addParentsDetails(Parents);
	}

	public List<Parents> readAllParentsDetails() {
		// logger.info("In Parents Controller");
		// logger.info("In Read All Parents Details Method");
		List<Parents> parentsList = new ArrayList<Parents>();
		try {
			parentsList = parentsServiceImpl.readAllParentsDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parentsList;

	}

	public Parents readParentsDetailsByStudentRollNo() {
		// logger.info("In Parents Controller");
		// logger.info("In Read Parents Details Method");
		Parents parents = new Parents();
		parents = parentsServiceImpl.readParentsDetailsByStudentRollNo();

		return parents;

	}

	public void updateParentsDetails() throws InvalidRollNoException, InvalidUserChoiceException {
		// logger.info("In Parents Controller");
		// logger.info("In Update Parents Details Method");
		parentsServiceImpl.updateParentsDetails();
	}

	public void deleteParentsDetails() throws InvalidRollNoException {
		// logger.info("In Parents Controller");
		// logger.info("In Delete Parents Details Method");
		parentsServiceImpl.deleteParentsDetails();

	}
}
