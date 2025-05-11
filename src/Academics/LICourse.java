package Academics;

import java.util.ArrayList;

public class LICourse extends Course{
    private final String courseCode;
    private final String courseName;
    public final String courseSection;
    private  String final_exam_date;
    private String professorName;
    private static ArrayList<LICourse> courses = new ArrayList<>();


    public LICourse(String courseCode, String courseName, String courseSection, String professorName, String final_exam_date) {
        super("LI", courseCode, courseName, courseSection);
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
        return "LI";
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
    
    public static ArrayList<LICourse> getCourses() {
        return new ArrayList<LICourse>(courses);
    }



    @Override
    public String toString() {
        return this.getCourseName() +" " + this.getCourseCode() +" " +this.getCourseSection() + " " + this.getProfessorName() + " " + this.getFinalExamDate();

    }
}

