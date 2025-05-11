import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import Pages.MainApp;


//Written by Max You
//edited by
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\n\n\n\n\n\n\n\n\n" + IO.readFile("src/FinalExam.csv"));
        System.out.println("Hello and welcome!");

        MainApp app = new MainApp();

        List<String> dataLines = List.of(
                "ICLT 327 M02,The Literature of Initiation,Trimnell,\"Thursday, May 15, 2025\",5:30 PM,8:10 PM,\"26 W. 61st St., Rm. 401\",New York City",
                "AAID 101 M01,Design Fundamentals I,Davila,\"Friday, May 16, 2025\",8:15 AM,10:15 AM,\"Guiliano Global Ctr., Rm. 502\",New York City",
                "AAID 102 W01,Design Fundamentals II,Laho,\"Friday, May 16, 2025\",8:15 AM,10:15 AM,\"Education Hall, Rm. 231\",Long Island"
        );

        List<FinalExamSchedule> dataset = new ArrayList<>();
        for (String line : dataLines) {
            dataset.add(new FinalExamSchedule(line));
        }

        Scanner scanner = new Scanner(System.in);
        List<FinalExamSchedule> filtered = new ArrayList<>(dataset);

        String[] searchOrder = {
                "Campus Location",
                "Course Code",
                "Course Section",
                "Final Exam Date",
                "Professor Name",
                "Course Name",
                "Exam Location"
        };

        for (String field : searchOrder) {
            System.out.print("Search " + field + ": ");
            String input = scanner.nextLine().trim();

            filtered = filterByField(filtered, field, input);

            if (filtered.size() == 1) {
                System.out.println("\nMatch Found:\n" + filtered.get(0));
                return;
            }

            if (filtered.isEmpty()) {
                System.out.println("\nNo results match your search.");
                return;
            }
        }

        System.out.println("\nFinal Matching Results:");
        for (FinalExamSchedule result : filtered) {
            System.out.println(result);
        }


    }

    private static List<FinalExamSchedule> filterByField(List<FinalExamSchedule> list, String field, String query) {
        String lowerQuery = query.toLowerCase();
        return list.stream()
                .filter(schedule -> {
                    switch (field) {
                        case "Course Name":
                            return schedule.getCourseName().toLowerCase().contains(lowerQuery);
                        case "Course Code":
                            return schedule.getCourseCode().toLowerCase().contains(lowerQuery);
                        case "Course Section":
                            return schedule.getCourseSection().equalsIgnoreCase(query);
                        case "Professor Name":
                            return schedule.getProfessorName().toLowerCase().contains(lowerQuery);
                        case "Final Exam Date":
                            return schedule.getFinalExamDate().toLowerCase().contains(lowerQuery);
                        case "Exam Location":
                            return schedule.getExamLocation().toLowerCase().contains(lowerQuery);
                        case "Campus Location":
                            return schedule.getCampusLocation().equalsIgnoreCase(query);
                        default:
                            return false;
                    }
                })
                .collect(Collectors.toList());
    }
}
