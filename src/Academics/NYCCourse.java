package Academics;

public class NYCCourse extends Course {
    public final String courseCode;
    public final String courseName;
    public final String courseSection;

    public String professorName;
    public String final_exam_date;
    public static  NYCCourse[] nycCourses;

    public NYCCourse(String courseCode, String courseName, String courseSection, String professorName, final String final_exam_date) {
        super("NYC", courseCode, courseName, courseSection);
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseSection = courseSection;
        this.professorName = professorName;
        this.final_exam_date = final_exam_date;
        appendNycCourse(this);

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

    public static NYCCourse[] getNycCourses() {
        NYCCourse[] nycCourses = new NYCCourse[NYCCourse.nycCourses.length];
        for (int i = 0; i < nycCourses.length; i++) {
            nycCourses[i] = NYCCourse.nycCourses[i];
        }
        return nycCourses;
    }

    public void appendNycCourse(NYCCourse nycCourse) {
        NYCCourse[] arr = new NYCCourse[NYCCourse.nycCourses.length + 1];
        for(int i = 0; i < NYCCourse.nycCourses.length; i++) {
            arr[i] = NYCCourse.nycCourses[i];

        }

        arr[NYCCourse.nycCourses.length] = nycCourse;
        NYCCourse.nycCourses = arr;

    }

    @Override
    public String toString() {
        return this.getCourseName() +" " + this.getCourseCode() +" " +this.getCourseSection() + " " + this.getProfessorName() + " " + this.getFinalExamDate();

    }
}
