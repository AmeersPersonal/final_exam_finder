package Pages;
// Page 1 class
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Jeffrey: First page, allows you to select a campus.
public class Page1_CampusSelector extends Page {

    // Constructor
    public Page1_CampusSelector(StateManager state) {
        super(state);
    }

    // Add Compoenents to our page.
    @Override
    public void addComponents() {
        // Add a title to the page
        JLabel title = new JLabel("Choose your campus");
        add(title);  
        
        // Creates buttons for campus selection and moves to the next page. 
        // calling State manager to update the campus info based on the button pressed.
        addButton("Long Island", (ActionEvent e) -> {
            state.setCampus(Campus.LONG_ISLAND);
            state.navigateTo(PageIdentifier.PAGE2);
        });

        addButton("New York City", (ActionEvent e) -> {
            state.setCampus(Campus.NEW_YORK_CITY);
            state.navigateTo(PageIdentifier.PAGE2);
        });   
    }

    // called method once the page is shown
    @Override
    public void onPageShown() {
        // Nothing happens, this is a static page and nothing else needs to be called.
    }
}