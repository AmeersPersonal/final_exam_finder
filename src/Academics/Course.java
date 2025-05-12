
/*
Modifed by Ameer Tayeh and Cristopher Bustos on 5/12/25
CSCI 185 M03
Final Exam Finder
 */
package Academics;

import java.util.ArrayList;
import java.util.Collections;


public abstract class Course implements Comparable<Course> {
    private final String location;
    private final String courseCode;
    private final String courseName;
    private final String courseSection;
    private static ArrayList<Course> courses = new ArrayList<>();

    public Course(String location, String courseCode, String courseName, String courseSection) {
        this.location = location;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseSection = courseSection;
        courses.add(this);
    }

    @Override
    public int compareTo(Course other) {
        return this.courseName.compareTo(other.courseName);
    }




    public static ArrayList<Course> getCourses() {
        return new ArrayList<Course>(courses);
    }

    // public String getCourseName() {
    //     return this.courseName;
    // }

    abstract String getLocation();





}
