package com.project.schoolsystem.service;

import org.apache.log4j.Logger;

import com.project.schoolsystem.dao.SchoolDAO;
import com.project.schoolsystem.dao.SchoolDAOImpl;
import com.project.schoolsystem.model.School;

public class SchoolServiceImpl implements SchoolService {
	SchoolDAO schoolDAO = new SchoolDAOImpl();

	static Logger logger=Logger.getLogger("SchoolServiceImpl.class");
	public void addSchoolDetails(School school) {
		 logger.info("In School Service");
		 logger.info("In Add School Details Method");
		schoolDAO.addSchoolDetails(school);
	}

	public School readSchoolDetails() {
	    logger.info("In Read All School Details Method");
		School school = new School();

		school = schoolDAO.readSchoolDetails();

		return school;

	}
}
