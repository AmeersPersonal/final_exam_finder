package Pages;

// Page 2 class
import Academics.Course;
import Academics.LICourse;
import Academics.NYCCourse;
import FileIO.IO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOError;
import java.util.ArrayList;
import javax.swing.*;

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
        addButton("<- To Prev page", (ActionEvent e) -> {
            state.navigateTo(PageIdentifier.PAGE3);
        });
        this.titleLabel = new JLabel(
                "Course Selected: " + state.getCourse() + " , Look below to find the finals based on your section");
        add(this.titleLabel);
        addButtons(state.getFinalCourseList());
        // state.getFinalCourseList().forEach((String s) -> {
        // System.out.println(s);
        // });
    }

    // Helper method to add buttons across a list of courses.
    public void addButtons(ArrayList<String> listOfFinalCourseCodes) {
        for (String name : listOfFinalCourseCodes) {
            JButton button = new JButton(name);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });

            add(button);
        }

    }

    @Override
    public void onPageShown() {
        ArrayList<String> courseString = new ArrayList<>();

        if (state.getQuickSearch()) {
            try {
                courseString = IO.search("src/FileIO/FinalExam.csv",state.getQuickSearchQuery());
            } catch (Exception e) {
                System.out.println("Error searching: " + e.getMessage());
            }
        } else {
            // Included Max's filtering here (similar approach)
            for (Course c : Course.getCourses()) {
                if (c instanceof LICourse) {
                    LICourse LIC = (LICourse) c;
                    if (state.getCourse().equals(LIC.getCourseName())
                            && LIC.getLocation().equals(state.getCampus().getName())) {
                        courseString.add(LIC.toString());
                    }
                } else if (c instanceof NYCCourse) {
                    NYCCourse NYCC = (NYCCourse) c;
                    if (state.getCourse().equals(NYCC.getCourseName())
                            && NYCC.getLocation().equals(state.getCampus().getName())) {
                        courseString.add(NYCC.toString());
                    }
                }
            }
        }

        state.setFinalCourseList(courseString);
        ;
        super.onPageShown();
    }
}
