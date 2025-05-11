package Academics;

public class Deparment {
    private final String name;

    public Course[] courses;
    public static Deparment[] deparments;
    public static String[] deparmentNames;

    public Deparment(String name, Course[] courses) {
        this.name = name;

        this.courses = courses;
        appendDeparment(this);



    }

    public String getName() {
        return this.name;
    }

    public String getCourses() {
        String s = "";
        for (Course c : courses) {
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
        if (deparments == null) {
            deparments = new Deparment[1];
            deparments[0] = deparment;

        }
        Deparment[] newDeparments = new Deparment[this.courses.length + 1];
        for (int i = 0; i < deparments.length; i++) {
            newDeparments[i] = deparments[i];
        }
        newDeparments[newDeparments.length - 1] = deparment;
        deparments = newDeparments;
    }
    public void appendDeparmentName(String name){
        if(deparmentNames == null){
            deparmentNames = new String[this.courses.length + 1];
            deparmentNames[0] = this.name;
            return;
        }
        String[] names = new String[deparmentNames.length + 1];
        for (int i = 0; i < deparmentNames.length; i++) {
            names[i] = deparmentNames[i];


        }
        names[names.length-1 ] = name;
        deparmentNames = names;
    }
    public static boolean doesDeparmentExist(String name ){
        if (deparmentNames == null){
            return false;
        }
        for (String d : deparmentNames) {
            if (d.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void appendCourses(Course[] courses) {
        Course[] newCourses = new NYCCourse[this.courses.length + courses.length];

        for (int i = 0; i < this.courses.length; i++) {
            newCourses[i] = this.courses[i];
        }
        for (int i = 0; i < courses.length; i++) {
            newCourses[this.courses.length + i] = courses[i];

        }
        this.courses = newCourses;
    }

    public void appendCourses(Course courses) {
        Course[] newCourses = new Course[this.courses.length + 1];
        for (int i = 0; i < this.courses.length; i++) {
            newCourses[i] = this.courses[i];

        }
        newCourses[newCourses.length - 1] = courses;
        this.courses = newCourses;

    }



}
