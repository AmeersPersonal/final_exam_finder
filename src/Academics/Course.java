package Academics;

import java.util.ArrayList;

public abstract class Course {
    private final String location;
    private final String courseCode;
    private final String courseName;
    private final String courseSection;
    private static  ArrayList<Course> courses = new ArrayList<>();



    public Course(String location, String courseCode, String courseName, String courseSection) {
        this.location = location;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseSection = courseSection;
        courses.add(this);


    }


    private static ArrayList<Course> getCourses() {
        return new ArrayList<Course>(courses);
    }

    abstract String getLocation();





}
