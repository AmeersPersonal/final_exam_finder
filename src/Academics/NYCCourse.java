package Academics;

import java.util.ArrayList;

public class NYCCourse extends Course {
    private final String courseCode;
    private final String courseName;
    public final String courseSection;
    private String final_exam_date;
    private String professorName;
    private String timeStart;
    private String timeEnd;
    private String building;
    private String room;
    public static ArrayList<NYCCourse> courses = new ArrayList<NYCCourse>();

    public NYCCourse(String courseCode, String courseName, String courseSection, String professorName, String final_exam_date, String timeStart, String timeEnd, String building, String room) {
        super("NYC", courseCode, courseName, courseSection);
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

    @Override
    public String toString() {
        return this.getCourseName() +" " + this.getCourseCode() +" " +this.getCourseSection() + " " + this.getProfessorName() + " " + this.getFinalExamDate() + " " + this.getTimeStart() + " " + this.getTimeEnd() + " " + this.getBuilding() + " " + this.getRoom();
    }
}
