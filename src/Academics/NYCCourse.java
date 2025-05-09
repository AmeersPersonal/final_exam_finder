package Academics;

public class NYCCourse extends Course {
    public final String courseCode;
    public final String courseName;
    public final String courseSection;

    public String professorName;
    public String final_exam_date;

    public NYCCourse(String courseCode, String courseName, String courseSection, String professorName, String final_exam_date) {
        super("NYC", courseCode, courseName, courseSection);
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseSection = "";
        this.professorName = "";
        this.final_exam_date = "";

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
    String getCampus() {
        return "NYC";
    }

    @Override
    String getSection() {
        return this.courseSection;
    }

    public String getProfessorName() {
        return this.professorName;
    }
    public String getFinalExamDate() {
        return this.final_exam_date;
    }


    @Override
    public String toString() {
        return this.getCourseName() +" " + this.getCourseCode() +" " +this.getCourseSection() + " " + this.getProfessorName() + " " + this.getFinalExamDate();

    }
}
