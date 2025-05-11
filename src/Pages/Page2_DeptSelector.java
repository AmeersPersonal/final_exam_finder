package Pages;
// Page 2 class
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Second page, used to select a department based on the campuus selected
public class Page2_DeptSelector extends Page {

    // Instance fields
    private JLabel campusLabel;

    public Page2_DeptSelector(StateManager state) {
        super(state);
        // Empty department list for now, this will be populated once the campus is selected.
    }

    @Override
    public void addComponents() {
        // Add title label
        this.campusLabel = new JLabel("Campus Selected: " + state.getCampus().getName() + " , Please select your dept out of the list");
        add(this.campusLabel);
    }

    // Helper method, takes an array of departments and creates a button for each dept.
    public void addButtons(ArrayList<String> listOfDepts) {
        for (String name : listOfDepts) {
            System.out.println(name);
            addButton(name, (ActionEvent e) -> {
                state.setDeptSelected(name);
                state.navigateTo(PageIdentifier.PAGE3);
            });
        }
    }

    // Helper method, updates campus label with current campus in state.
    public void updateCampusLabel() {
        campusLabel.setText("Campus Selected: " + state.getCampus().getName() + " , Please select your dept out of the list");
    }

    // On page shown, we need to update the campus label and add buttons for each department.
    @Override
    public void onPageShown() {
        updateCampusLabel();
        addButtons(state.getDeptList());
    }
}
