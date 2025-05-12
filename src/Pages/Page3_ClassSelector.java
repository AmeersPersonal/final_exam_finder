/*
Modifed by Cristopher Bustos and Jeffrey Chu on 5/12/2025
CSCI 185 M03
Final Exam Finder
5/12/2025
 */

package Pages;

// Page 2 class
import Academics.Course;
import Academics.Deparment;
import Academics.LICourse;
import Academics.NYCCourse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

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
        addButton(this, "<- To Prev page", (ActionEvent e) -> {
            state.navigateTo(PageIdentifier.PAGE2);
        });
        this.titleLabel = new JLabel("Dept Selected: " + state.getDept() + " , Please select your course of the list");
        add(this.titleLabel);
        this.titleLabel.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel();
        int numButtons = state.getCourseList().size();
        int columns = 2;
        int rows = (int) Math.ceil((double) numButtons / columns);
        buttonPanel.setLayout(new GridLayout(rows, columns, 10, 10));
        addButtons(state.getCourseList(), buttonPanel);
        buttonPanel.setBackground(new Color(242, 169, 0));

        scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new java.awt.Dimension(1600, 900));
        add(scrollPane);
    }

    // Helper method to add buttons across a list of courses.
    public void addButtons(ArrayList<String> listOfCourseCodes, JPanel panel) {

        for (String name : listOfCourseCodes) {
            JButton button = new JButton(name);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    state.setCourseSelected(name);
                    state.setQuickSearch(false);
                    state.navigateTo(PageIdentifier.PAGE4);
                }
            });

            panel.add(button);
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
    //Color of the Background
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(0, 45, 114));
    }
}
