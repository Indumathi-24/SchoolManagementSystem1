package com.project.schoolsystem.service;

import java.util.ArrayList;
import java.util.List;

import com.project.schoolsystem.dao.ParentsDAO;
import com.project.schoolsystem.dao.ParentsDAOImpl;
import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Parents;

public class ParentsServiceImpl implements ParentsService {
	ParentsDAO parentsDAO = new ParentsDAOImpl();

	// static Logger logger=Logger.getLogger("ParentsServiceImpl.class");
	public void addParentsDetails(Parents parents) {
		// logger.info("In Parents Service");
		// logger.info("In Add Parents Details Method");
		parentsDAO.addParentsDetails(parents);
	}

	public List<Parents> readAllParentsDetails() {
		// logger.info("In Read All Parents Details Method");
		List<Parents> parentsList = new ArrayList<Parents>();

		parentsList = parentsDAO.readAllParentsDetails();

		return parentsList;

	}

	public Parents readParentsDetailsByStudentRollNo() {
		// logger.info("In Parents Service");
		// logger.info("In Read Parents Details Method");
		Parents parents = new Parents();

		parents = parentsDAO.readParentsDetailsByStudentRollNo();

		return parents;

	}

	public void updateParentsDetails() throws InvalidUserChoiceException, InvalidRollNoException {
		// logger.info("In Parents Service");
		// logger.info("In Update Parents Details Method");
		parentsDAO.updateParentsDetails();

	}

	public void deleteParentsDetails() throws InvalidRollNoException {
		// logger.info("In Parents Service");
		// logger.info("In Delete Parents Details Method");
		parentsDAO.deleteParentsDetails();
	}
}
