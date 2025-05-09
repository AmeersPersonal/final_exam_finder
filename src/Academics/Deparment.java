package Academics;

public class Deparment {
    private final String name;
    private final String type;
    public NYCCourse[] courses;
    public static Deparment[] deparments;

    public Deparment(String name, String type, NYCCourse[] courses) {
        this.name = name;
        this.type = type;
        this.courses = courses;
        appendDeparment(this);


    }

    public String getName() {
        return this.name;
    }
    public String getType() {
        return this.type;
    }
    public String getCourses() {
        String s = "";
        for (NYCCourse c : courses) {
            s +=c.toString() +"\n";
        }
        return s;
    }
    public static String getDeparmentName() {
        String res = "";
        for (Deparment d : deparments) {
            res += d.getName() +"\n";
        }
        return res;
    }

    public void appendDeparment(Deparment deparment) {
        Deparment[] newDeparments = new Deparment[this.courses.length + 1];
        for (int i = 0; i < deparments.length; i++) {
            newDeparments[i] = deparments[i];
        }
        newDeparments[newDeparments.length - 1] = deparment;
        deparments = newDeparments;
    }

    public void appendCourses(NYCCourse[] courses) {
        NYCCourse[] newCourses = new NYCCourse[this.courses.length + courses.length];

        for (int i = 0; i < this.courses.length; i++) {
            newCourses[i] = this.courses[i];
        }
        for (int i = 0; i < courses.length; i++) {
            newCourses[this.courses.length + i] = courses[i];

        }
        this.courses = newCourses;
    }
    public void appendCourses(NYCCourse courses) {
        NYCCourse[] newCourses = new NYCCourse[this.courses.length + 1];
        for (int i = 0; i < this.courses.length; i++) {
            newCourses[i] = this.courses[i];

        }
        newCourses[newCourses.length - 1] = courses;
        this.courses = newCourses;

    }



}
