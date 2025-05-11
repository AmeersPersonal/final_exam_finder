package Academics;

public abstract class Course {
    private final String location;
    private final String courseCode;
    private final String courseName;
    private final String courseSection;
    public static Course[] courses;


    public Course(String location, String courseCode, String courseName, String courseSection) {
        this.location = location;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseSection = courseSection;

    }

    abstract String getLocation();





}
