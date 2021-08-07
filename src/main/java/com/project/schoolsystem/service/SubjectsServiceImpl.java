package com.project.schoolsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project.schoolsystem.dao.SubjectsDAO;
import com.project.schoolsystem.dao.SubjectsDAOImpl;
import com.project.schoolsystem.exceptions.InvalidIdException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Subjects;

public class SubjectsServiceImpl implements SubjectsService {
	SubjectsDAO subjectsDAO = new SubjectsDAOImpl();

	static Logger logger = Logger.getLogger("SubjectsServiceImpl.class");

	public void addSubjectsDetails(Subjects subjects) {
		logger.info("In Subjects Service");
		logger.info("In Add Subjects Details Method");
		subjectsDAO.addSubjectsDetails(subjects);
	}

	public List<Subjects> readAllSubjectsDetails() {
		logger.info("In Read All Subjects Details Method");
		List<Subjects> subjectsList = new ArrayList<Subjects>();

		subjectsList = subjectsDAO.readAllSubjectsDetails();

		return subjectsList;

	}

	public Subjects readSubjectsDetailsBySubjectId() {
		logger.info("In Subjects Service");
		logger.info("In Read Subjects Details Method");
		Subjects subjects = new Subjects();

		subjects = subjectsDAO.readSubjectsDetailsBySubjectId();

		return subjects;

	}

	public void updateSubjectsDetails() {
		logger.info("In Subjects Service");
		logger.info("In Update Subjects Details Method");
		subjectsDAO.updateSubjectsDetails();

	}

	public void deleteSubjectsDetails() {
		logger.info("In Subjects Service");
		logger.info("In Delete Subjects Details Method");
		subjectsDAO.deleteSubjectsDetails();
	}
}
