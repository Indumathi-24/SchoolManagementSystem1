package com.project.schoolsystem.client;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.schoolsystem.controller.MarksController;
import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Marks;

public class MarksApplication {
	public static void addMarks() {
		System.out.print("Enter the number of Students Marks:");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.nextLine();
		int rollNo = 0;
		System.out.println("Adding Marks Details");
		for (int i = 0; i < number; i++) {
			Marks marks = new Marks();
			System.out.print("Enter the Tamil Mark:");
			Integer tamil = sc.nextInt();
			System.out.print("Enter the English Mark:");
			Integer english = sc.nextInt();
			System.out.print("Enter the Maths Mark:");
			Integer maths = sc.nextInt();
			System.out.print("Enter the Science Mark:");
			Integer science = sc.nextInt();
			System.out.print("Enter the Social Science Mark:");
			Integer socialScience = sc.nextInt();
			System.out.print("Enter the EVS Mark:");
			Integer evs = sc.nextInt();
			System.out.print("Enter the rollNo of Student:");
			rollNo = sc.nextInt();
			sc.nextLine();
			try {
				if (rollNo < 1) {
					throw new InvalidRollNoException("Roll No is Invalid");
				} else {
					marks.setStudentRollNo(rollNo);
					marks.setTamil(tamil);
					marks.setEnglish(english);
					marks.setMaths(maths);
					marks.setScience(science);
					marks.setSocialScience(socialScience);
					marks.setEvs(evs);
					marksController.addMarksDetails(marks);
				}
			} catch (InvalidRollNoException e) {
				logger.warn(e.getMessage());
			}
		}
		if (rollNo > 0) {
			System.out.println("Case 1: Adding Marks Details is Completed");
		}
	}

	static MarksController marksController = new MarksController();

	static Logger logger = Logger.getLogger("MarksApplication.class");

	public static void main(String args[]) {

		logger.info("In Marks Application");
		while (true) {
			System.out.println("====== Marks Application======");
			System.out.println("0.======Exit======");
			System.out.println("1.======Insertion======");
			System.out.println("2.======Retrieval======");
			System.out.println("3.======Updation======");
			System.out.println("4.======Deletion======");
			System.out.println("5.======Total marks Calculation======");
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
					addMarks();
					break;
				}
				case 2: {
					System.out.println("Enter choice of retrieval");
					Marks marks = new Marks();
					List<Marks> marksList = new ArrayList<Marks>();
					Scanner sc = new Scanner(System.in);
					int choice = sc.nextInt();
					switch (choice) {
					case 1: {
						System.out.println("Reading All Marks Details");
						marksList = marksController.readAllMarksDetails();
						for (Marks s : marksList) {
							System.out.println(s);
						}
						System.out.println("Case 2: Reading Markss Details is Completed");
						break;
					}
					case 2: {
						System.out.println("Reading Marks Details");
						marks = marksController.readMarksDetailsByStudentRollNo();
						System.out.println(marks);
						System.out.println("Case 2: Reading Marks Details is Completed");
						break;
					}
					}
					break;
				}
				case 3: {
					System.out.println("Updating Marks Details");
					marksController.updateMarksDetails();
					System.out.println("Case 3: Updating Markss Details is Completed");
					break;
				}
				case 4: {
					System.out.println("Deleting Marks Details");
					marksController.deleteMarksDetails();
					System.out.println("Case 4: Deleting Markss Details is Completed");
					break;
				}
				case 5: {
					System.out.println("Total Marks Method");
					marksController.totalMarksByStudentRollNo();
					System.out.println("Case 5: Total Marks Calculating Method is Completed");
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
