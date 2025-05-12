package CLISearchEngine;

import Academics.Course;
import Academics.LICourse;
import Academics.NYCCourse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Made by Max You
// CLI Search Engine (Used to help create the GUI Engine)
public class CLIEngine {
    private List<Course> courses;

    public CLIEngine() {
        courses = Course.getCourses();
    }

    public void runEngine() {

        Scanner scanner = new Scanner(System.in);
        List<Course> filtered = new ArrayList<>(courses);

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
        for (Course result : filtered) {
            System.out.println(result.toString());
        }
    
    }

    private static List<Course> filterByField(List<Course> list, String field, String query) {
        String lowerQuery = query.toLowerCase();
        return list.stream()
                .filter(course -> {
                    if (course instanceof LICourse) {
                        LICourse courseWithLocation = (LICourse) course;

                        switch (field) {
                            case "Course Name":
                                return courseWithLocation.getCourseName().toLowerCase().contains(lowerQuery);
                            case "Course Code":
                                return courseWithLocation.getCourseCode().toLowerCase().contains(lowerQuery);
                            case "Course Section":
                                return courseWithLocation.getCourseSection().equalsIgnoreCase(query);
                            case "Professor Name":
                                return courseWithLocation.getProfessorName().toLowerCase().contains(lowerQuery);
                            case "Final Exam Date":
                                return courseWithLocation.getFinalExamDate().toLowerCase().contains(lowerQuery);
                            case "Exam Building":
                                return courseWithLocation.getBuilding().toLowerCase().contains(lowerQuery);
                            case "Campus Location":
                                return courseWithLocation.getLocation().equalsIgnoreCase(query);
                            default:
                                return false;
                        }
                    } else if (course instanceof NYCCourse) {
                        NYCCourse courseWithLocation = (NYCCourse) course;

                        switch (field) {
                            case "Course Name":
                                return courseWithLocation.getCourseName().toLowerCase().contains(lowerQuery);
                            case "Course Code":
                                return courseWithLocation.getCourseCode().toLowerCase().contains(lowerQuery);
                            case "Course Section":
                                return courseWithLocation.getCourseSection().equalsIgnoreCase(query);
                            case "Professor Name":
                                return courseWithLocation.getProfessorName().toLowerCase().contains(lowerQuery);
                            case "Final Exam Date":
                                return courseWithLocation.getFinalExamDate().toLowerCase().contains(lowerQuery);
                            case "Exam Building":
                                return courseWithLocation.getBuilding().toLowerCase().contains(lowerQuery);
                            case "Campus Location":
                                return courseWithLocation.getLocation().equalsIgnoreCase(query);
                            default:
                                return false;
                        }
                    } else {
                        System.out.println("Error: Course is not of type LICourse or NYCCourse");
                        return false;
                    }

                })
                .collect(Collectors.toList());
    }
}
