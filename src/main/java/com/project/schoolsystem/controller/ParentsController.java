package com.project.schoolsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.project.schoolsystem.model.Parents;
import com.project.schoolsystem.service.ParentsService;
import com.project.schoolsystem.service.ParentsServiceImpl;

public class ParentsController {
	ParentsService parentsServiceImpl = new ParentsServiceImpl();

	static Logger logger = Logger.getLogger("ParentsController.class");

	public void addParentsDetails(Parents parents) {
		logger.info("In Parents Controller");
		logger.info("In Add Parents Details Method");
		parentsServiceImpl.addParentsDetails(parents);
	}

	public List<Parents> readAllParentsDetails() {
		logger.info("In Parents Controller");
		logger.info("In Read All Parents Details Method");
		List<Parents> parentsList = new ArrayList<Parents>();
		try {
			parentsList = parentsServiceImpl.readAllParentsDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parentsList;

	}

	public Parents readParentsDetailsByStudentRollNo() {
		logger.info("In Parents Controller");
		logger.info("In Read Parents Details Method");
		Parents parents = new Parents();
		parents = parentsServiceImpl.readParentsDetailsByStudentRollNo();

		return parents;

	}

	public void updateParentsDetails() {
		logger.info("In Parents Controller");
		logger.info("In Update Parents Details Method");
		parentsServiceImpl.updateParentsDetails();
	}

	public void deleteParentsDetails() {
		logger.info("In Parents Controller");
		logger.info("In Delete Parents Details Method");
		parentsServiceImpl.deleteParentsDetails();

	}
}
