package com.project.schoolsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Student;
import com.project.schoolsystem.service.StudentService;
import com.project.schoolsystem.service.StudentServiceImpl;

public class StudentController {
	StudentService studentServiceImpl = new StudentServiceImpl();
	static Logger logger = Logger.getLogger("StudentController.class");

	public void addStudentDetails(Student student) {
		logger.info("In Student Controller");
		logger.info("In Add Student Details Method");

		studentServiceImpl.addStudentDetails(student);
	}

	public List<Student> readAllStudentDetails() {
		logger.info("In  Student Controller");
		logger.info("In Read All Student Details Method");
		List<Student> studentList = new ArrayList<Student>();
		try {
			studentList = studentServiceImpl.readAllStudentDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;

	}

	public Student readStudentDetailsById() {
		logger.info("In  Student Controller");
		logger.info("In Read Student Details Method");
		Student student = new Student();
		student = studentServiceImpl.readStudentDetailsById();

		return student;

	}

	public void updateStudentDetails() throws InvalidRollNoException, InvalidUserChoiceException {
		logger.info("In  Student Controller");
		logger.info("In Update Student Details Method");
		studentServiceImpl.updateStudentDetails();
	}

	public void deleteStudentDetails() throws InvalidRollNoException {
		logger.info("In Student Controller");
		logger.info("In Delete Student Details Method");
		studentServiceImpl.deleteStudentDetails();

	}
}
