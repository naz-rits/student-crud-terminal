package com.example.dsa.dsaproject.apprunner;

import com.example.dsa.dsaproject.services.StudentServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class ConsoleAppRunner implements CommandLineRunner {

    private final StudentServiceImpl studentService;


    public ConsoleAppRunner(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    public static void clearScreen() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int input = 0;

        while (input != 6) {
            System.out.println();
            System.out.println("Welcome to the Student Information Management System");
            System.out.println("[1] Add Student");
            System.out.println("[2] Remove Student");
            System.out.println("[3] Update Student's Information");
            System.out.println("[4] Update Student's Grades");
            System.out.println("[5] Search Student");
            System.out.println("[6] Exit");
            System.out.print("Your choice is: ");

            try {
                input = scanner.nextInt();
                switch (input) {
                    case 1:
                        clearScreen();
                        studentService.addStudent();
                        break;
                    case 2:
                        clearScreen();
                        studentService.removeStudent();
                        break;
                    case 3:
                        clearScreen();
                        studentService.updateStudent();
                        break;
                    case 4:
                        clearScreen();
                        studentService.updateStudentGrades();
                        break;
                    case 5:
                        clearScreen();
                        studentService.getStudent();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid command.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }

        }
        scanner.close();
    }
}