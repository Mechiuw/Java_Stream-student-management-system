package view.Reports;

import controller.ReportsController;
import lombok.RequiredArgsConstructor;
import model.dto.request.ReportsRequest;
import view.MainView;

import java.util.*;

import static view.MainView.control;

@RequiredArgsConstructor
public class ReportsView {
    private final ReportsController reportsController;
    public void ReportsOption(){
        control();
    }
    public void control(){
        Scanner scan = new Scanner(System.in);
        boolean around = true;
        while(around){
            System.out.println("Report Management Menu:\n" + "\n" +
                    "1. Create Report\n" +
                    "2. View All Reports\n" +
                    "3. Update Report\n" +
                    "4. Delete Report\n" +
                    "5. View Report By Id\n" +
                    "6. Back\n" +
                    "Enter your choice (1-6): ");
            String choice = scan.nextLine();

            switch(choice){
                case "1":
                    System.out.println("1. insert subject :\n" +
                            "2. insert unit :\n" +
                            "3. insert semester:\n" +
                            "4. insert year:\n" +
                            "Type one by one :\n");
                    String aa = scan.nextLine();
                    String ab = scan.nextLine();
                    int ac = scan.nextInt();
                    String ad = scan.nextLine();

                    ReportsRequest reportsRequestPost = ReportsRequest.builder()
                            .subject(aa)
                            .unit(ab)
                            .semester(ac)
                            .year(ad)
                            .build();
                    System.out.println();
                    System.out.println(reportsController.createReports(reportsRequestPost));
                    break;
                case "2":
                    reportsController.viewAllReports();
                    break;
                case "3":
                    System.out.println("insert report unit to update :\n" +
                            "1. insert new subject :\n" +
                            "2. insert new unit :\n" +
                            "3. insert new semester:\n" +
                            "4. insert new year:\n" +
                            "Type one by one :\n");
                    String id = scan.nextLine();
                    String ba = scan.nextLine();
                    String bb = scan.nextLine();
                    int bc = scan.nextInt();
                    String bd = scan.nextLine();

                    ReportsRequest reportsRequestPut = ReportsRequest.builder()
                            .subject(ba)
                            .unit(bb)
                            .semester(bc)
                            .year(bd)
                            .build();
                    System.out.println();
                    System.out.println(reportsController.updateReports(id,reportsRequestPut));
                    break;
                case "4" :
                    System.out.println("insert report unit to delete :\n");
                    String delId = scan.nextLine();
                    reportsController.deleteReports(delId);
                    System.out.println("done deleted");
                    break;
                case "5":
                    System.out.println("insert report unit to view :\n");
                    String viewId = scan.nextLine();
                    System.out.println(reportsController.viewById(viewId));
                    break;
                case "6":
                    System.out.println("done");
                    around = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 to 6");
            }
        }
        MainView.run();
    }
}
