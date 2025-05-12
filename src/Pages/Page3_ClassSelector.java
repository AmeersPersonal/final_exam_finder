package Pages;

// Page 2 class
import javax.swing.*;

import Academics.Course;
import Academics.Deparment;
import Academics.LICourse;
import Academics.NYCCourse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Jeffrey: Third page that allows you to select a class based on department.
public class Page3_ClassSelector extends Page {
    // instance fields
    private JLabel titleLabel;

    // Constructor
    public Page3_ClassSelector(AppStateManager state) {
        super(state);
    }

    // Add components to the page such as the title label.
    @Override
    public void addComponents() {
        this.titleLabel = new JLabel("Dept Selected: " + state.getDept() + " , Please select your course of the list");
        add(this.titleLabel);
        addButtons(state.getCourseList());
    }

    // Helper method to add buttons across a list of courses.
    public void addButtons(ArrayList<String> listOfCourseCodes) {

        for (String name : listOfCourseCodes) {
            JButton button = new JButton(name);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    state.setCourseSelected(name);
                    state.navigateTo(PageIdentifier.PAGE4);
                }
            });

            add(button);
        }
    }

    @Override
    public void onPageShown() {
        ArrayList<String> courseNames = new ArrayList<>();
        for (Deparment d : Deparment.deparments) {
            if (d.getName().equals(state.getDept())) {
                ArrayList<Course> courseList = d.courses;
                for (Course c : courseList) {
                    if (c instanceof LICourse) {
                        LICourse LIC = (LICourse) c;
                        if (!courseNames.contains(LIC.getCourseName()))
                            courseNames.add(LIC.getCourseName());
                    }
                    if (c instanceof NYCCourse) {
                        NYCCourse NYCC = (NYCCourse) c;
                        if (!courseNames.contains(NYCC.getCourseName()))
                            courseNames.add(NYCC.getCourseName());
                    }
                }
            }
        }

        state.setCourseList(courseNames);
        super.onPageShown();
    }
}
