package Academics;

import java.util.ArrayList;

public class NYCCourse extends Course {
    public final String courseCode;
    public final String courseName;
    public final String courseSection;

    public String professorName;
    public String final_exam_date;
    public static  ArrayList<NYCCourse> courses = new ArrayList<NYCCourse>();

    public NYCCourse(String courseCode, String courseName, String courseSection, String professorName, final String final_exam_date) {
        super("NYC", courseCode, courseName, courseSection);
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseSection = courseSection;
        this.professorName = professorName;
        this.final_exam_date = final_exam_date;
        courses.add(this);

    }
    public String getCourseCode() {
        return this.courseCode;
    }
    public String getCourseName() {
        return this.courseName;
    }
    public String getCourseSection() {
        return this.courseSection;
    }

    @Override
    String getLocation() {
        return "NYC";
    }


    String getSection() {
        return this.courseSection;
    }

    public String getProfessorName() {
        return this.professorName;
    }
    public String getFinalExamDate() {
        return this.final_exam_date;
    }

   public static ArrayList<NYCCourse> getCourses() {
        return new ArrayList<NYCCourse>(courses);
   }


    @Override
    public String toString() {
        return this.getCourseName() +" " + this.getCourseCode() +" " +this.getCourseSection() + " " + this.getProfessorName() + " " + this.getFinalExamDate();

    }
}
