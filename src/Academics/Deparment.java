/*
Modifed by Ameer Tayeh
CSCI 185 M03
Final Exam Finder
 */
package Academics;

import java.util.ArrayList;

public class Deparment {
    private final String name;

    public ArrayList<Course> courses;
    public static ArrayList<Deparment> deparments;
    public static ArrayList<String> deparmentNames;

    public Deparment(String name, ArrayList<Course> courses) {
        this.name = name;

        this.courses = courses;
        appendDeparment(this);



    }

    public String getName() {
        return this.name;
    }

    public String getCourses() {
        String s = "";
        for (Course c : courses) {
            s +=c.toString() +"\n";
        }
        return s;
    }
    public static String getDeparmentName() {
        String res = "";
        for (Deparment d : deparments) {
            res += d.getName() +"\n";
        }
        return res;
    }

    public void appendDeparment(Deparment deparment) {
        if (deparments == null) {
            deparments = new ArrayList<>();
        }
        if (!doesDeparmentExist(name)) {
            deparments.add(deparment);
            this.appendDeparmentName(name);
        }
    }
    public void appendDeparmentName(String name){
        if(deparmentNames == null){
            deparmentNames = new ArrayList<>();
        }
        if (!deparmentNames.contains(name)) {
            deparmentNames.add(name);
        }
    }
    public static boolean doesDeparmentExist(String name ){
        if (deparmentNames == null){
            return false;
        }
        for (String d : deparmentNames) {
            if (d.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void appendCourses(ArrayList<Course> courses) {
        this.courses.addAll(courses);
    }

    public void appendCourses(Course courses) {
        this.courses.add(courses);
    }



}
