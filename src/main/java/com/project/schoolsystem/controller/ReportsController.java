package com.project.schoolsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.project.schoolsystem.exceptions.InvalidRoomNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Reports;
import com.project.schoolsystem.service.ReportsService;
import com.project.schoolsystem.service.ReportsServiceImpl;

public class ReportsController {
	ReportsService reportsServiceImpl = new ReportsServiceImpl();

	// static Logger logger=Logger.getLogger("ReportsController.class");
	public void addReportsDetails(Reports Reports) {
		// logger.info("In Reports Controller");
		// logger.info("In Add Reports Details Method");
		reportsServiceImpl.addReportsDetails(Reports);
	}

	public List<Reports> readAllReportsDetails() {
		// logger.info("In Reports Controller");
		// logger.info("In Read All Reports Details Method");
		List<Reports> reportsList = new ArrayList<Reports>();
		try {
			reportsList = reportsServiceImpl.readAllReportsDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reportsList;

	}

	public Reports readReportsDetailsByRoomNo() {
		// logger.info("In Reports Controller");
		// logger.info("In Read Reports Details Method");
		Reports reports = new Reports();
		reports = reportsServiceImpl.readReportsDetailsByRoomNo();

		return reports;

	}

	public void updateReportsDetails() throws InvalidRoomNoException, InvalidUserChoiceException {
		// logger.info("In Reports Controller");
		// logger.info("In Update Reports Details Method");
		reportsServiceImpl.updateReportsDetails();
	}

	public void deleteReportsDetails() throws InvalidRoomNoException {
		// logger.info("In Reports Controller");
		// logger.info("In Delete Reports Details Method");
		reportsServiceImpl.deleteReportsDetails();

	}
}
