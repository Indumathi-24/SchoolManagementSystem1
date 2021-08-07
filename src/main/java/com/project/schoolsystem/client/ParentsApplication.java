package com.project.schoolsystem.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.schoolsystem.controller.ParentsController;
import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Parents;

public class ParentsApplication {
	public static void addParents() {
		System.out.print("Enter the number of Parents:");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.nextLine();
		int rollNo = 0;
		System.out.println("Adding Parents Details");
		for (int i = 0; i < number; i++) {
			Parents parents = new Parents();
			System.out.print("Enter the mother name:");
			String motherName = sc.nextLine();
			System.out.print("Enter the father name:");
			String fatherName = sc.nextLine();
			System.out.print("Enter the rollNo of Student:");
			rollNo = sc.nextInt();
			sc.nextLine();
			try {
				if (rollNo < 1) {
					throw new InvalidRollNoException("Roll NO is Invalid");
				} else {
					parents.setStudentRollNo(rollNo);
					parents.setMotherName(motherName);
					parents.setFatherName(fatherName);
					parentsController.addParentsDetails(parents);
				}
			} catch (InvalidRollNoException e) {
				logger.warn(e.getMessage());
			}
		}
		if (rollNo > 0) {
			System.out.println("Case 1: Adding Parents Details is Completed");
		}
	}

	static ParentsController parentsController = new ParentsController();
	static Logger logger = Logger.getLogger("ParentsApplication.class");

	public static void main(String args[]) {

		logger.info("In Parents Application");
		while (true) {
			System.out.println("====== Parents Application======");
			System.out.println("0.======Exit======");
			System.out.println("1.======Insertion======");
			System.out.println("2.======Retrieval======");
			System.out.println("3.======Updation======");
			System.out.println("4.======Deletion======");
			System.out.println("Enter your choice");
			try {
				Scanner scanner = new Scanner(System.in);
				int userChoice = scanner.nextInt();
				switch (userChoice) {
				case 0: {
					System.exit(0);
					break;
				}
				case 1: {
					addParents();
					break;
				}
				case 2: {
					System.out.print("Enter choice of retrieval:");
					Parents parents = new Parents();
					List<Parents> parentsList = new ArrayList<Parents>();
					Scanner sc = new Scanner(System.in);
					int readChoice = sc.nextInt();
					switch (readChoice) {
					case 1: {
						System.out.println("Reading All Parents Details");
						parentsList = parentsController.readAllParentsDetails();
						for (Parents s : parentsList) {
							System.out.println(s);
						}
						System.out.println("Case 2: Reading Parents Details is Completed");
						break;
					}
					case 2: {
						System.out.println("Reading Parents Details");
						parents = parentsController.readParentsDetailsByStudentRollNo();
						System.out.println(parents);
						System.out.println("Case 2: Reading Parents Details is Completed");
						break;
					}
					}
					break;
				}
				case 3: {
					System.out.println("Updating Parents Details");
					parentsController.updateParentsDetails();
					System.out.println("Case 3: Updating Parents Details is Completed");
					break;
				}
				case 4: {
					System.out.println("Deleting Parents Details");
					parentsController.deleteParentsDetails();
					System.out.println("Case 4: Deleting Parents Details is Completed");
					break;
				}
				default:
					throw new InvalidUserChoiceException("User Choice is Invalid");
				}
			} catch (InvalidUserChoiceException e) {
				logger.warn(e.getMessage());
			}
		}
	}
}