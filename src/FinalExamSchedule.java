public class FinalExamSchedule {
    private String courseCode;
    private String courseSection;
    private String courseName;
    private String professorName;
    private String finalExamDate;
    private String examLocation;
    private String campusLocation;

    public FinalExamSchedule(String csvLine) {
        String[] parts = csvLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        if (parts.length < 8) {
            throw new IllegalArgumentException("Invalid CSV format");
        }

        String[] codeParts = parts[0].trim().split(" ");
        this.courseCode = codeParts[0] + " " + codeParts[1];
        this.courseSection = codeParts[2];
        this.courseName = parts[1].trim();
        this.professorName = parts[2].trim();
        this.finalExamDate = parts[3].replaceAll("\"", "") + ", " + parts[4].trim() + ", " + parts[5].trim();
        this.examLocation = parts[6].replaceAll("\"", "").trim();
        this.campusLocation = parts[7].trim();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseSection() {
        return courseSection;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getProfessorName() {
        return professorName;
    }

    public String getFinalExamDate() {
        return finalExamDate;
    }

    public String getExamLocation() {
        return examLocation;
    }

    public String getCampusLocation() {
        return campusLocation;
    }

    @Override
    public String toString() {
        return String.format(
                "Course Code: %s | Section: %s | Name: %s | Prof: %s | Date: %s | Location: %s | Campus: %s",
                courseCode, courseSection, courseName, professorName,
                finalExamDate, examLocation, campusLocation
        );
    }
}