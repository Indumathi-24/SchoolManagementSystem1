package com.project.schoolsystem.controller;

import org.apache.log4j.Logger;

import com.project.schoolsystem.exceptions.InvalidIdException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.School;
import com.project.schoolsystem.service.SchoolService;
import com.project.schoolsystem.service.SchoolServiceImpl;

public class SchoolController {
	SchoolService schoolServiceImpl = new SchoolServiceImpl();

	static Logger logger=Logger.getLogger("SchoolController.class");
	public void addSchoolDetails(School school) {
		logger.info("In School Controller");
		logger.info("In Add School Details Method");

		schoolServiceImpl.addSchoolDetails(school);
	}

	public School readSchoolDetails() {
		 logger.info("In School Controller");
		 logger.info("In Read School Details Method");
		School school = new School();
		school = schoolServiceImpl.readSchoolDetails();

		return school;

	}

}
