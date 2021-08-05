package com.project.schoolsystem.service;

import java.util.ArrayList;
import java.util.List;

import com.project.schoolsystem.dao.ReportsDAO;
import com.project.schoolsystem.dao.ReportsDAOImpl;
import com.project.schoolsystem.exceptions.InvalidRoomNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Reports;

public class ReportsServiceImpl implements ReportsService {
	ReportsDAO reportsDAO = new ReportsDAOImpl();

	// static Logger logger=Logger.getLogger("ReportsServiceImpl.class");
	public void addReportsDetails(Reports reports) {
		// logger.info("In Reports Service");
		// logger.info("In Add Reports Details Method");
		reportsDAO.addReportsDetails(reports);
	}

	public List<Reports> readAllReportsDetails() {
		// logger.info("In Read All Reports Details Method");
		List<Reports> reportsList = new ArrayList<Reports>();

		reportsList = reportsDAO.readAllReportsDetails();

		return reportsList;

	}

	public Reports readReportsDetailsById() {
		// logger.info("In Reports Service");
		// logger.info("In Read Reports Details Method");
		Reports reports = new Reports();

		reports = reportsDAO.readReportsDetailsById();

		return reports;

	}

	public void updateReportsDetails() throws InvalidUserChoiceException, InvalidIdException {
		// logger.info("In Reports Service");
		// logger.info("In Update Reports Details Method");
		reportsDAO.updateReportsDetails();

	}

	public void deleteReportsDetails() throws InvalidIdException {
		// logger.info("In Reports Service");
		// logger.info("In Delete Reports Details Method");
		reportsDAO.deleteReportsDetails();
	}
}
