package com.project.schoolsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Teacher;
import com.project.schoolsystem.service.TeacherService;
import com.project.schoolsystem.service.TeacherServiceImpl;

public class TeacherController {
	TeacherService teacherServiceImpl = new TeacherServiceImpl();

	static Logger logger=Logger.getLogger("SchoolManagementTeacherController.class");
	public void addTeacherDetails(Teacher teacher) {
		logger.info("In School Management Teacher Controller");
	    logger.info("In Add Teacher Details Method");
		teacherServiceImpl.addTeacherDetails(teacher);
	}

	public List<Teacher> readAllTeacherDetails() {
		 logger.info("In School Management Teacher Controller");
		 logger.info("In Read All Teacher Details Method");
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = teacherServiceImpl.readAllTeacherDetails();

		return teacherList;

	}

	public Teacher readTeacherDetailsById() {
		logger.info("In School Management Teacher Controller");
		logger.info("In Read Teacher Details Method");
		Teacher teacher = new Teacher();
		teacher = teacherServiceImpl.readTeacherDetailsById();

		return teacher;

	}

	public void updateTeacherDetails() throws InvalidRollNoException, InvalidUserChoiceException {
		logger.info("In School Management Teacher Controller");
		logger.info("In Update Teacher Details Method");
		teacherServiceImpl.updateTeacherDetails();
	}

	public void deleteTeacherDetails() throws InvalidRollNoException {
		 logger.info("In School Management Teacher Controller");
		 logger.info("In Delete Teacher Details Method");
		teacherServiceImpl.deleteTeacherDetails();
	}

}
