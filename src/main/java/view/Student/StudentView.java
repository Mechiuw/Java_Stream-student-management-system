package view.Student;

import controller.StudentController;
import lombok.RequiredArgsConstructor;
import model.dto.request.StudentRequest;

import java.util.*;

@RequiredArgsConstructor
public class StudentView {
    private final StudentController studentController;
    public void StudentOption(){
        control();
    }

    public void control() {
        Scanner scan = new Scanner(System.in);

        boolean around = true;

        while (around) {
            System.out.println("Student Management Menu:\n" +
                    "\n" +
                    "1. Create Student\n" +
                    "2. View All Students\n" +
                    "3. Update Student\n" +
                    "4. Delete Student\n" +
                    "5. View By Id \n" +
                    "6. Back\n" +
                    "\n" +
                    "Enter your choice (1-5): ");
            String choice = scan.nextLine();

            switch (choice) {
                case "1":

                    System.out.println("input first name");
                    String a = scan.nextLine();
                    System.out.println("input last name");
                    String b = scan.nextLine();
                    System.out.println("input major");
                    String c = scan.nextLine();
                    System.out.println("input date of birth");
                    String d = scan.nextLine();
                    System.out.println("input email");
                    String e = scan.nextLine();
                    System.out.println("input phone number");
                    String f = scan.nextLine();

                    StudentRequest studentRequest = StudentRequest.builder()
                            .firstName(a)
                            .lastName(b)
                            .major(c)
                            .dateOfBirth(d)
                            .email(e)
                            .phoneNum(f)
                            .build();
                    System.out.println();
                    System.out.println(studentController.createStudent(studentRequest));
                    break;
                case "2":
                    studentController.viewAllStudents().forEach(System.out::println);
                    break;
                case "3":
                    System.out.println("input student id");
                    String id = scan.nextLine();
                    System.out.println("input new first name");
                    String ua = scan.nextLine();
                    System.out.println("input new last name");
                    String ub = scan.nextLine();
                    System.out.println("input new major");
                    String uc = scan.nextLine();
                    System.out.println("input new date of birth");
                    String ud = scan.nextLine();
                    System.out.println("input new email");
                    String ue = scan.nextLine();
                    System.out.println("input new phone number");
                    String uf = scan.nextLine();

                    StudentRequest updateStudentRequest = StudentRequest.builder()
                            .firstName(ua)
                            .lastName(ub)
                            .major(uc)
                            .dateOfBirth(ud)
                            .email(ue)
                            .phoneNum(uf)
                            .build();

                    System.out.println(studentController.updateStudent(id, updateStudentRequest));
                    break;
                case "4":
                    System.out.println("input student id to delete");
                    String delId = scan.nextLine();
                    studentController.deleteStudent(delId);
                    System.out.println("done deleted");
                    break;
                case "5":
                    System.out.println("insert id to view one");
                    String viewId = scan.nextLine();
                    System.out.println(studentController.viewById(viewId));
                    break;
                case "6":
                    System.out.println("done");
                    around = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
