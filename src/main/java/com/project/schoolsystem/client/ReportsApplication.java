package com.project.schoolsystem.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.schoolsystem.controller.ReportsController;
import com.project.schoolsystem.exceptions.InvalidIdException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Reports;

public class ReportsApplication {
	public static void addReports() throws InvalidIdException {
		System.out.print("Enter the number of Reports:");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.nextLine();
		System.out.println("Adding Reports Details");
		for (int i = 0; i < number; i++) {
			Reports reports = new Reports();
			System.out.print("Enter the teacher id:");
			int id = sc.nextInt();
			sc.nextLine();
			if (id < 1) {
				throw new InvalidIdException("Id is Invalid");
			}
			System.out.print("Enter the subject id:");
			Integer subject_id = sc.nextInt();
			System.out.print("Enter the date:");
			String date = sc.nextLine();
			System.out.print("Enter the topic:");
			String topic = sc.nextLine();
			reports.setTeacher_id(id);
			reports.setSubjects_id(subject_id);
			reports.setDate(date);
			reports.setTopic(topic);
			reportsController.addReportsDetails(reports);
		}
		System.out.println("Case 1: Adding Reports Details is Completed");
	}

	static ReportsController reportsController = new ReportsController();

	// static Logger logger=Logger.getLogger("ReportsApplication.class");
	public static void main(String args[]) throws InvalidIdException, InvalidUserChoiceException {

		// logger.info("In Reports Application");
		while (true) {
			System.out.println("====== Reports Application======");
			System.out.println("0.======Exit======");
			System.out.println("1.======Insertion======");
			System.out.println("2.======Retrieval======");
			System.out.println("3.======Updation======");
			System.out.println("4.======Deletion======");
			System.out.println("Enter your choice");
			Scanner scanner = new Scanner(System.in);
			int userChoice = scanner.nextInt();
			switch (userChoice) {
			case 0: {
				System.exit(0);
				break;
			}
			case 1: {
				addReports();
				break;
			}
			case 2: {
				System.out.print("Enter choice of retrieval:");
				Reports reports = new Reports();
				List<Reports> reportsList = new ArrayList<Reports>();
				Scanner sc = new Scanner(System.in);
				int readChoice = sc.nextInt();
				switch (readChoice) {
				case 1: {
					System.out.println("Reading All Reports Details");
					reportsList = reportsController.readAllReportsDetails();
					for (Reports s : reportsList) {
						System.out.println(s);
					}
					System.out.println("Case 2: Reading Reports Details is Completed");
					break;
				}
				case 2: {
					System.out.println("Reading Reports Details");
					reports = reportsController.readReportsDetailsByRoomNo();
					System.out.println(reports);
					System.out.println("Case 2: Reading Reports Details is Completed");
					break;
				}
				}
				break;
			}
			case 3: {
				System.out.println("Updating Reports Details");
				reportsController.updateReportsDetails();
				System.out.println("Case 3: Updating Reports Details is Completed");
				break;
			}
			case 4: {
				System.out.println("Deleting Reports Details");
				reportsController.deleteReportsDetails();
				System.out.println("Case 4: Deleting Reports Details is Completed");
				break;
			}
			default:
				throw new InvalidUserChoiceException("User Choice is Invalid");
			}

		}
	}
}
