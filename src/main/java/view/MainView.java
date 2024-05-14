package view;

import controller.StudentController;
import lombok.RequiredArgsConstructor;
import repository.StudentRepository;
import service.impl.StudentService;
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
        StudentView studentView = new StudentView(new StudentController(new StudentService(new StudentRepository(new ArrayList<>()))));

        switch (choice)
        {
            case 1:
                studentView.StudentOption();
                break;
            case 2:
//                ReportsOption();
                break;
            case 3:
//                ReportCardOption();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
