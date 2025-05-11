package Academics;

public class LICourse extends Course{
    public final String courseCode;
    public final String courseName;
    public final String courseSection;
    public  String final_exam_date;
    public String professorName;
    public static LICourse[] LICourses;


    public LICourse(String courseCode, String courseName, String courseSection, String professorName, String final_exam_date) {
        super("LI", courseCode, courseName, courseSection);
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseSection = courseSection;
        this.professorName = professorName;
        this.final_exam_date = final_exam_date;
        appendLICourse(this);

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
    public static LICourse[] getLICourses() {
        LICourse[] liCourses = new LICourse[LICourse.LICourses.length];
        for (int i = 0; i < liCourses.length; i++) {
            liCourses[i] = LICourse.LICourses[i];
        }
        return liCourses;
    }

    public void appendLICourse(LICourse LICourse) {
        LICourse[] arr = new LICourse[LICourse.LICourses.length];
        for(int i = 0; i < LICourse.LICourses.length; i++) {
            arr[i] = LICourse.LICourses[i];

        }

        arr[LICourse.LICourses.length] = LICourse;
        LICourses = arr;

    }


    @Override
    public String toString() {
        return this.getCourseName() +" " + this.getCourseCode() +" " +this.getCourseSection() + " " + this.getProfessorName() + " " + this.getFinalExamDate();

    }
}