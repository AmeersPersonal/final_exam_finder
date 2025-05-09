package Pages;
// Page 1 class
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Page1_CampusSelector extends JPanel {
    // Need access to mainApp to change pages. TODO can consider different design if this does not work properly
    private MainApp mainApp;

    // Constructor
    public Page1_CampusSelector(MainApp mainApp) {
         this.mainApp = mainApp;
        setLayout(new FlowLayout());

        // Initial Label
        add(new JLabel("Choose your campus"));

        // Creates buttons for campus selection and moves to the next page. 
        // All state handling is done by the mainApp, which manages state across the entire application
        JButton button = new JButton("Long Island");
        button.addActionListener( (ActionEvent e) -> {
            mainApp.setCampus(Campus.LONG_ISLAND);
            mainApp.showPage("Page2");
        });

        JButton button2 = new JButton("New York City");
        button2.addActionListener( (ActionEvent e) -> {
            mainApp.setCampus(Campus.NEW_YORK_CITY);
            mainApp.showPage("Page2");
        });

        // Don't forget to add your components
        add(button);
        add(button2);

        // TODO we may want to consider styling these pages later. Currently they are just basic panels
    }
}