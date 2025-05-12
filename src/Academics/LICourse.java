/*
Modifed by Ameer Tayeh
CSCI 185 M03
Final Exam Finder
 */
package Academics;

import java.util.ArrayList;

public class LICourse extends Course{
    private final String courseCode;
    private final String courseName;
    public final String courseSection;
    private final String final_exam_date;
    private final String professorName;
    private static final ArrayList<LICourse> courses = new ArrayList<>();
    private final String timeStart;
    private final String timeEnd;
    private final String building;
    private final String room;


    public LICourse(String courseCode, String courseName, String courseSection, String professorName, String final_exam_date, String timeStart, String timeEnd, String building, String room) {
        super("LI", courseCode, courseName, courseSection);
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseSection = courseSection;
        this.professorName = professorName;
        this.final_exam_date = final_exam_date;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.building = building;
        this.room = room;
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
    public String getLocation() {
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

    public String getTimeStart() {
        return timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public String getBuilding() {
        return building;
    }

    public String getRoom() {
        return room;
    }
    
    public static ArrayList<Course> getCourses() {
        return new ArrayList<Course>(courses);
    }



    @Override
    public String toString() {
        return this.getCourseName() +" " + this.getCourseCode() +" " +this.getCourseSection() + " " + this.getProfessorName() + " " + this.getFinalExamDate() + " " + this.getTimeStart() + " " + this.getTimeEnd() + " " + this.getBuilding() + " " + this.getRoom();

    }
}

