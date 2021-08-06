package com.project.schoolsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project.schoolsystem.dao.ClassesDAO;
import com.project.schoolsystem.dao.ClassesDAOImpl;
import com.project.schoolsystem.exceptions.InvalidRoomNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Classes;

public class ClassesServiceImpl implements ClassesService {
	ClassesDAO classesDAO = new ClassesDAOImpl();

	static Logger logger=Logger.getLogger("ClassesServiceImpl.class");
	public void addClassesDetails(Classes classes) {
		 logger.info("In Classes Service");
		 logger.info("In Add Classes Details Method");
		classesDAO.addClassesDetails(classes);
	}

	public List<Classes> readAllClassesDetails() {
		logger.info("In Read All Classes Details Method");
		List<Classes> classesList = new ArrayList<Classes>();

		classesList = classesDAO.readAllClassesDetails();

		return classesList;

	}

	public Classes readClassesDetailsByRoomNo() {
		 logger.info("In Classes Service");
		 logger.info("In Read Classes Details Method");
		Classes classes = new Classes();

		classes = classesDAO.readClassesDetailsByRoomNo();

		return classes;

	}

	public void updateClassesDetails() throws InvalidUserChoiceException, InvalidRoomNoException {
	     logger.info("In Classes Service");
		logger.info("In Update Classes Details Method");
		classesDAO.updateClassesDetails();

	}

	public void deleteClassesDetails() throws InvalidRoomNoException {
		logger.info("In Classes Service");
	    logger.info("In Delete Classes Details Method");
		classesDAO.deleteClassesDetails();
	}
}
