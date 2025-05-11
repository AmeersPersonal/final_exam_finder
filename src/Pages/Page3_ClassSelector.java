package Pages;
// Page 2 class
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Jeffrey: Third page that allows you to select a class based on department.
public class Page3_ClassSelector extends Page {
    // instance fields
    private JLabel titleLabel;

    // Constructor
    public Page3_ClassSelector(StateManager state) {
        super(state);
    }

    // Add components to the page such as the title label.
    @Override
    public void addComponents() {
        this.titleLabel = new JLabel("Dept Selected: " + state.getDept() + " , Please select your course of the list");
        add(this.titleLabel);
    }
    
    // Helper method to add buttons across a list of courses.
    public void addButtons(ArrayList<String> listOfCourseCodes) {
        for (String name : listOfCourseCodes) {
            JButton button = new JButton(name);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    state.setCourseSelected(name);
                    state.navigateTo(PageIdentifier.PAGE2);
                }
            });

            add(button);
        }
    }

    // Helper method to help update the info label with current dept selected
    public void updateInfoLabel() {
        this.titleLabel.setText("Dept Selected: " + state.getDept() + " , Please select your course of the list");
    }

    // On page shown, we need to update title label and add buttons for each course.
    @Override
    public void onPageShown() {
        updateInfoLabel();
        addButtons(state.getCourseList());
    }
}
