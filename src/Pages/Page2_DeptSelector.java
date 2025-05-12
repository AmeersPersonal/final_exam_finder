package Pages;
// Page 2 class
import javax.swing.*;

import Academics.Deparment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Second page, used to select a department based on the campuus selected
public class Page2_DeptSelector extends Page {

    // Instance fields
    private JLabel campusLabel;

    public Page2_DeptSelector(AppStateManager state) {
        super(state);
        // Empty department list for now, this will be populated once the campus is selected.
    }

    @Override
    public void addComponents() {
        addButton("<- To Prev page", (ActionEvent e) -> {
            state.navigateTo(PageIdentifier.PAGE1);
        });
        // Add title label
        this.campusLabel = new JLabel("Campus Selected: " + state.getCampus().getName() + " , Please select your dept out of the list");
        add(this.campusLabel);
        addButtons(state.getDeptList());
    }

    // Helper method, takes an array of departments and creates a button for each dept.
    public void addButtons(ArrayList<String> listOfDepts) {
        for (String name : listOfDepts) {
            addButton(name, (ActionEvent e) -> {
                state.setDeptSelected(name);
                state.navigateTo(PageIdentifier.PAGE3);
            });
        }
    }

    @Override
    public void onPageShown() {
        state.setDeptList(Deparment.deparmentNames);
        super.onPageShown();
    }
}
