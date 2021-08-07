package com.project.schoolsystem.controller;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;
import com.project.schoolsystem.model.Classes;
import com.project.schoolsystem.service.ClassesService;
import com.project.schoolsystem.service.ClassesServiceImpl;

public class ClassesController {
	ClassesService classesServiceImpl = new ClassesServiceImpl();

	static Logger logger = Logger.getLogger("ClassesController.class");

	public void addClassesDetails(Classes classes) {
		logger.info("In Classes Controller");
		logger.info("In Add Classes Details Method");
		classesServiceImpl.addClassesDetails(classes);
	}

	public List<Classes> readAllClassesDetails() {
		logger.info("In Classes Controller");
		logger.info("In Read All Classes Details Method");
		List<Classes> classesList = new ArrayList<Classes>();
		try {
			classesList = classesServiceImpl.readAllClassesDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classesList;

	}

	public Classes readClassesDetailsByRoomNo() {
		logger.info("In Classes Controller");
		logger.info("In Read Classes Details Method");
		Classes classes = new Classes();
		classes = classesServiceImpl.readClassesDetailsByRoomNo();

		return classes;

	}

	public void updateClassesDetails() {
		logger.info("In Classes Controller");
		logger.info("In Update Classes Details Method");
		classesServiceImpl.updateClassesDetails();
	}

	public void deleteClassesDetails() {
		logger.info("In Classes Controller");
		logger.info("In Delete Classes Details Method");
		classesServiceImpl.deleteClassesDetails();

	}
}
