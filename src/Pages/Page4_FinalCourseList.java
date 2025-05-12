package Pages;

// Page 2 class
import javax.swing.*;

import Academics.Course;
import Academics.LICourse;
import Academics.NYCCourse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Jeffrey: Third page that allows you to select a class based on department.
public class Page4_FinalCourseList extends Page {
    // instance fields
    private JLabel titleLabel;

    // Constructor
    public Page4_FinalCourseList(AppStateManager state) {
        super(state);
    }

    // Add components to the page such as the title label.
    @Override
    public void addComponents() {
        this.titleLabel = new JLabel(
                "Course Selected: " + state.getCourse() + " , Look below to find the finals based on your section");
        add(this.titleLabel);
        addLabels(state.getFinalCourseList());
    }

    // Helper method to add buttons across a list of courses.
    public void addLabels(ArrayList<String> FinalCoursesList) {
        for (String name : FinalCoursesList) {
            JLabel label = new JLabel(name);
            label.setVisible(true);
            add(label);
        }
    }

    @Override
    public void onPageShown() {
        ArrayList<String> courseString = new ArrayList<>();

        // Included Max's filtering here (similar approach)
        for (Course c : Course.getCourses()) {
            if (c instanceof LICourse) {
                LICourse LIC = (LICourse) c;
                if (state.getCourse().equals(LIC.getCourseName()) && LIC.getLocation().equals(state.getCampus().getName())) {
                    courseString.add(LIC.toString());
                }
            } else if (c instanceof NYCCourse) {
                NYCCourse NYCC = (NYCCourse) c;
                if (state.getCourse().equals(NYCC.getCourseName()) && NYCC.getLocation().equals(state.getCampus().getName())) {
                    courseString.add(NYCC.toString());
                }
            }
        }

        courseString.forEach((String s) -> {
            System.out.println(s);
        });
        state.setFinalCourseList(courseString);
        super.onPageShown();
    }
}
