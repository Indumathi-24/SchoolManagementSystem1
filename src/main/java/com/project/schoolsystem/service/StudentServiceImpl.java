package com.project.schoolsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project.schoolsystem.dao.StudentDAO;
import com.project.schoolsystem.dao.StudentDAOImpl;
import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Student;

public class StudentServiceImpl implements StudentService {
	StudentDAO studentDAO = new StudentDAOImpl();
	static Logger logger = Logger.getLogger("StudentServiceImpl.class");

	public void addStudentDetails(Student student) {
		logger.info("In  Student Service");
		logger.info("In Add Student Details Method");
		studentDAO.addStudentDetails(student);
	}

	public List<Student> readAllStudentDetails() {
		logger.info("In Read All Student Details Method");
		List<Student> studentList = new ArrayList<Student>();

		studentList = studentDAO.readAllStudentDetails();

		return studentList;

	}

	public Student readStudentDetailsById() {
		logger.info("In  Student Service");
		logger.info("In Read Student Details Method");
		Student student = new Student();

		student = studentDAO.readStudentDetailsById();

		return student;

	}

	public void updateStudentDetails() throws InvalidUserChoiceException, InvalidRollNoException {
		logger.info("In  Student Service");
		logger.info("In Update Student Details Method");
		studentDAO.updateStudentDetails();

	}

	public void deleteStudentDetails() throws InvalidRollNoException {
		logger.info("In Student Service");
		logger.info("In Delete Student Details Method");
		studentDAO.deleteStudentDetails();
	}
}