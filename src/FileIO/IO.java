package FileIO;
/*
Modifed by Ameer Tayeh
CSCI 185 M03
Final Exam Finder
 */

import Academics.Course;
import Academics.Deparment;
import Academics.LICourse;
import Academics.NYCCourse;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class IO {

    public static ArrayList<String> search(String fileName, String phrase) throws FileNotFoundException {
        File file = new File(fileName);
        ArrayList<String> res = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                StringBuilder builder = new StringBuilder();
                if (line.contains(phrase)) {
                    if (line.contains("Cycle D") || line.contains("Spring 2025")) {
                        String[] data = line.split(",");
                        res.add(line);
                    }
                }

            }
            return res;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            // checks if line exists and not end in file
            while ((line = br.readLine()) != null) {

                if (line.contains("Cycle D") || line.contains("Spring 2025")) {
                    String[] data = line.split(",");
                    if (data.length < 9)
                        continue;
                    String[] data1 = data[1].split(" ");
                    String deparement = data1[0];
                    String code = data1[1];

                    String courseName = data[2];
                    String professorName = data[3];
                    String day = data[4];
                    String date = data[5] + data[6];
                    String timeStart = data[7];
                    String timeEnd = data[8];
                    String building;
                    String room;
                    String campus;
                    if (data[9].equals("TBA") || data[9].equals("Zoom")) {
                        building = data[9];
                        room = "";
                        campus = data[10];
                    } else {

                        building = data[9];
                        room = data[10];
                        campus = data[11];
                    }
                    System.out.println(deparement);

                    Course c;
                    if (campus.equals("New York City")) {

                        c = new NYCCourse(deparement + " " + code, courseName, code, professorName, date, timeStart,
                                timeEnd, building, room);
                    } else {

                        c = new LICourse(deparement + " " + code, courseName, code, professorName, date, timeStart,
                                timeEnd, building, room);
                    }

                    if (!Deparment.doesDeparmentExist(deparement)) {
                        ArrayList<Course> courses = new ArrayList<>();
                        courses.add(c);
                        Deparment deparmentVar = new Deparment(deparement, new ArrayList<>(courses));
                    } else {
                        for (Deparment d : Deparment.deparments) {
                            if (d.getName().equals(deparement)) {
                                d.appendCourses(c);
                            }
                        }
                    }

                }

            }
            return sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";

    }
}
