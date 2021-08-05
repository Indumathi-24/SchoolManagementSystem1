package com.project.schoolsystem.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.schoolsystem.controller.SubjectsController;
import com.project.schoolsystem.exceptions.InvalidIdException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Subjects;

public class SubjectsApplication {
	public static void addSubjects() throws InvalidIdException {
		System.out.print("Enter the number of Subjects:");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.nextLine();
		System.out.println("Adding Subjects Details");
		for (int i = 0; i < number; i++) {
			Subjects subjects = new Subjects();
			System.out.print("Enter the Subject Id:");
			int id = sc.nextInt();
			sc.nextLine();
			if (id < 1) {
				throw new InvalidIdException("Subject Id is Invalid");
			}
			System.out.print("Enter the name of Subject:");
			String name = sc.nextLine();
			subjects.setSubjectId(id);
			subjects.setSubjectName(name);
			subjectsController.addSubjectsDetails(subjects);
		}
		System.out.println("Case 1: Adding Subjects Details is Completed");
	}

	static SubjectsController subjectsController = new SubjectsController();

	 static Logger logger=Logger.getLogger("SubjectsApplication.class");
	public static void main(String args[]) throws InvalidIdException, InvalidUserChoiceException {

		logger.info("In Subjects Application");
		while (true) {
			System.out.println("====== Subjects Application======");
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
				addSubjects();
				break;
			}
			case 2: {
				System.out.print("Enter choice of retrieval:");
				Subjects subjects = new Subjects();
				List<Subjects> subjectsList = new ArrayList<Subjects>();
				Scanner sc = new Scanner(System.in);
				int choice = sc.nextInt();
				switch (choice) {
				case 1: {
					System.out.println("Reading All Subjects Details");
					subjectsList = subjectsController.readAllSubjectsDetails();
					for (Subjects s : subjectsList) {
						System.out.println(s);
					}
					System.out.println("Case 2: Reading Subjects Details is Completed");
					break;
				}
				case 2: {
					System.out.println("Reading Subjects Details");
					subjects = subjectsController.readSubjectsDetailsBySubjectId();
					System.out.println(subjects);
					System.out.println("Case 2: Reading Subjects Details is Completed");
					break;
				}
				}
				break;
			}
			case 3: {
				System.out.println("Updating Subjects Details");
				subjectsController.updateSubjectsDetails();
				System.out.println("Case 3: Updating Subjects Details is Completed");
				break;
			}
			case 4: {
				System.out.println("Deleting Subjects Details");
				subjectsController.deleteSubjectsDetails();
				System.out.println("Case 4: Deleting Subjects Details is Completed");
				break;
			}
			default:
				throw new InvalidUserChoiceException("User Choice is Invalid");
			}

		}
	}
}
