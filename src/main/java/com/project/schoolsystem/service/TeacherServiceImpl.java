package com.project.schoolsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project.schoolsystem.dao.TeacherDAO;
import com.project.schoolsystem.dao.TeacherDAOImpl;
import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Teacher;



public class TeacherServiceImpl implements TeacherService {
	TeacherDAO teacherDAO = new TeacherDAOImpl();
	//static Logger logger=Logger.getLogger("SchoolManagementTeacherServiceImpl.class");
	public void addTeacherDetails(Teacher teacher) {
		//logger.info("In School Management Teacher Service");
		//logger.info("In Add Student Details Method");
		teacherDAO.addTeacherDetails(teacher);
	}

	public List<Teacher> readAllTeacherDetails() {
		//logger.info("In School Management Teacher Service");
		//logger.info("In Read All Teacher Details Method");
    	List<Teacher> teacherList = new ArrayList<Teacher>();
    	
	    teacherList=teacherDAO.readAllTeacherDetails();

    	return teacherList;
    	 
     }
    public Teacher readTeacherDetailsById() {
    	//logger.info("In School Management Teacher Service");
    	//logger.info("In Read Teacher Details Method");
    	Teacher teacher = new Teacher();
    	
		teacher=teacherDAO.readTeacherDetailsById();
	
    	return teacher;
    	 
     }
	public void updateTeacherDetails() throws InvalidUserChoiceException, InvalidRollNoException {
		//logger.info("In School Management Teacher Service");
		//logger.info("In Update Teacher Details Method");
		teacherDAO.updateTeacherDetails();
		
	}
	public void deleteTeacherDetails() throws InvalidRollNoException {
		//logger.info("In School Management Teacher Service");
		//logger.info("In Delete Teacher Details Method");
		teacherDAO.deleteTeacherDetails();
		
	}
}
