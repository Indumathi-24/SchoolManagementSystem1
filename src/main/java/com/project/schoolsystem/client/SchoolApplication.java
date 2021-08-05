package com.project.schoolsystem.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.schoolsystem.controller.SchoolController;
import com.project.schoolsystem.exceptions.InvalidIdException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.School;

public class SchoolApplication {
	public static void addSchool() throws InvalidIdException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Adding school Details");
		School school = new School();
		System.out.print("Enter School Id:");
		int id = sc.nextInt();
		sc.nextLine();
		if (id < 1) {
			throw new InvalidIdException("School Id is Invalid");
		}
		System.out.print("Enter School Name:");
		String name = sc.nextLine();
		System.out.print("Enter School Address:");
		String address = sc.nextLine();
		school.setSchoolId(id);
		school.setSchoolName(name);
		school.setSchoolAddress(address);
		schoolController.addSchoolDetails(school);

		System.out.println("Case 1: Adding school Details is Completed");
	}

	static SchoolController schoolController = new SchoolController();

    static Logger logger=Logger.getLogger("SchoolApplication.class");
	public static void main(String args[]) throws InvalidUserChoiceException, InvalidIdException {

	    logger.info("In School Application");
		while (true) {
			System.out.println("====== School Application======");
			System.out.println("0.======Exit======");
			System.out.println("1.======Insertion======");
			System.out.println("2.======Retrieval======");
			System.out.println("Enter your choice");
			Scanner scanner = new Scanner(System.in);
			int userChoice = scanner.nextInt();
			switch (userChoice) {
			case 0: {
				System.exit(0);
				break;
			}
			case 1: {
				addSchool();
				break;
			}
			case 2: {
				School school = new School();
				System.out.println("Reading school Details");
				school = schoolController.readSchoolDetails();
				System.out.println(school);
				System.out.println("Case 2: Reading school Details is Completed");
				break;

			}

			default:
				throw new InvalidUserChoiceException("User Choice is Invalid");
			}

		}
	}
}
