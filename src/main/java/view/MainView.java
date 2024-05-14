package view;

import controller.ReportsController;
import controller.StudentController;
import lombok.RequiredArgsConstructor;
import repository.ReportsRepository;
import repository.StudentRepository;
import service.impl.ReportsService;
import service.impl.StudentService;
import view.Reports.ReportsView;
import view.Student.StudentView;

import java.util.*;

@RequiredArgsConstructor
public class MainView {

    public static void run(){
        System.out.println("Welcome to the School Management System!\n" +
                "\n" +
                "Please select an option:\n" +
                "1. Student\n" +
                "2. Reports\n" +
                "3. Report Card\n" +
                "4. Exit\n" +
                "\n" +
                "Enter your choice (1-4): ");


        control();
    }
    public static void control(){
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        StudentView studentView = new StudentView(
                new StudentController(
                        new StudentService(
                                new StudentRepository(
                                        new ArrayList<>()))));
        ReportsView reportsView = new ReportsView(
                new ReportsController(
                        new ReportsService(
                                new ReportsRepository(
                                        new ArrayList<>()))));
        switch (choice)
        {
            case 1:
                studentView.StudentOption();
                break;
            case 2:
                reportsView.ReportsOption();
                break;
            case 3:
//                ReportCardOption();
                break;
            case 4 :
                System.out.println("Thank you for using our application");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
