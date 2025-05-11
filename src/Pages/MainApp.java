package Pages;
// Main application class
import javax.swing.*;

import java.awt.*;

public class MainApp extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Campus campus;

    public MainApp() {
        campus = Campus.NONE; // Default campus
        setTitle("Multi-Page App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create instances of page classes
        Page1_CampusSelector page1 = new Page1_CampusSelector(this);
        Page2_DeptSelector page2 = new Page2_DeptSelector(this);
        Page3_ClassSelector page3 = new Page3_ClassSelector(this);

        // Add pages to the card layout
        mainPanel.add(page1, "Page1");
        mainPanel.add(page2, "Page2");
        mainPanel.add(page3, "Page3");

        add(mainPanel);
        setVisible(true);
    }

    public void showPage(String pageName) {
        // Show the intiial main panels
        cardLayout.show(mainPanel, pageName);
    }

    public Campus getCampus() {

        // returns the selected campus w/ default to none
        return campus;
    }

    public void setCampus(Campus campus) {
        // updates the selected campus across the entire app and calls updateState to update the pages w/ new
        this.campus = campus;
        updateState();
    }

    private void updateState() {
        // Update the state of the application based on the selected campus
        // This can include enabling/disabling buttons, changing labels, etc.
        // any changes that need to be done across an entire application should be done here

        if (mainPanel.getComponent(1) instanceof Page2_DeptSelector) { // Assuming Page2 is the second component
            ((Page2_DeptSelector) mainPanel.getComponent(1)).updateCampusLabel();
        }
    }
}
