package com.project.schoolsystem.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.schoolsystem.controller.ClassesController;
import com.project.schoolsystem.exceptions.InvalidRoomNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Classes;

public class ClassesApplication {
	public static void addClasses() throws InvalidRoomNoException {
		System.out.print("Enter the number of Classes:");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.nextLine();
		System.out.println("Adding Classes Details");
		for (int i = 0; i < number; i++) {
			Classes classes = new Classes();
			System.out.print("Enter the roomNo of Classes:");
			int roomNo = sc.nextInt();
			sc.nextLine();
			if (roomNo < 1) {
				throw new InvalidRoomNoException("Room NO is Invalid");
			}
			System.out.print("Enter the standard of Classes:");
			String standard = sc.nextLine();
			System.out.print("Enter the section of Classes:");
			String section = sc.nextLine();
			classes.setStandard(standard);
			classes.setClasses_roomNo(roomNo);
			classes.setSection(section);
			classesController.addClassesDetails(classes);
		}
		System.out.println("Case 1: Adding Classes Details is Completed");
	}

	static ClassesController classesController = new ClassesController();

	// static Logger logger=Logger.getLogger("ClassesApplication.class");
	public static void main(String args[]) throws InvalidRoomNoException, InvalidUserChoiceException {

		// logger.info("In Classes Application");
		while (true) {
			System.out.println("====== Classes Application======");
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
				addClasses();
				break;
			}
			case 2: {
				System.out.print("Enter choice of retrieval:");
				Classes classes = new Classes();
				List<Classes> classesList = new ArrayList<Classes>();
				Scanner sc = new Scanner(System.in);
				int readChoice = sc.nextInt();
				switch (readChoice) {
				case 1: {
					System.out.println("Reading All Classes Details");
					classesList = classesController.readAllClassesDetails();
					for (Classes s : classesList) {
						System.out.println(s);
					}
					System.out.println("Case 2: Reading Classes Details is Completed");
					break;
				}
				case 2: {
					System.out.println("Reading Classes Details");
					classes = classesController.readClassesDetailsByRoomNo();
					System.out.println(classes);
					System.out.println("Case 2: Reading Classes Details is Completed");
					break;
				}
				}
				break;
			}
			case 3: {
				System.out.println("Updating Classes Details");
				classesController.updateClassesDetails();
				System.out.println("Case 3: Updating Classes Details is Completed");
				break;
			}
			case 4: {
				System.out.println("Deleting Classes Details");
				classesController.deleteClassesDetails();
				System.out.println("Case 4: Deleting Classes Details is Completed");
				break;
			}
			default:
				throw new InvalidUserChoiceException("User Choice is Invalid");
			}

		}
	}
}
