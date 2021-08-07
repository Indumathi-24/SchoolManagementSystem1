package com.project.schoolsystem.controller;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;
import com.project.schoolsystem.model.Subjects;
import com.project.schoolsystem.service.SubjectsService;
import com.project.schoolsystem.service.SubjectsServiceImpl;

public class SubjectsController {
	SubjectsService subjectsServiceImpl = new SubjectsServiceImpl();

	static Logger logger = Logger.getLogger("SubjectsController.class");

	public void addSubjectsDetails(Subjects subjects) {
		logger.info("In Subjects Controller");
		logger.info("In Add Subjects Details Method");
		subjectsServiceImpl.addSubjectsDetails(subjects);
	}

	public List<Subjects> readAllSubjectsDetails() {
		logger.info("In Subjects Controller");
		logger.info("In Read All Subjects Details Method");
		List<Subjects> subjectsList = new ArrayList<Subjects>();
		try {
			subjectsList = subjectsServiceImpl.readAllSubjectsDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectsList;

	}

	public Subjects readSubjectsDetailsBySubjectId() {
		logger.info("In Subjects Controller");
		logger.info("In Read Subjects Details Method");
		Subjects subjects = new Subjects();
		subjects = subjectsServiceImpl.readSubjectsDetailsBySubjectId();

		return subjects;

	}

	public void updateSubjectsDetails() {
		logger.info("In Subjects Controller");
		logger.info("In Update Subjects Details Method");
		subjectsServiceImpl.updateSubjectsDetails();
	}

	public void deleteSubjectsDetails() {
		logger.info("In Subjects Controller");
		logger.info("In Delete Subjects Details Method");
		subjectsServiceImpl.deleteSubjectsDetails();

	}
}
