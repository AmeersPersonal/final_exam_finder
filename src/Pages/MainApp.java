package Pages;


// Main application class
import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

// Jeffrey: Page Navigator, handles the main application and navigation between pages.
public class MainApp extends JFrame{

    // Include State Manager, which manages the state of the whole application
    private StateManager state;

    // CardLayout is used to showcase one page at a time.
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainApp() {
        // StateManager uses the mainApp instance 
        state = new StateManager(this);

        // JFrame settings
        setTitle("Multi-Page App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create instances of page classes
        Page1_CampusSelector page1 = new Page1_CampusSelector(state);
        Page2_DeptSelector page2 = new Page2_DeptSelector(state);
        Page3_ClassSelector page3 = new Page3_ClassSelector(state);

        // Add pages to the card layout
        mainPanel.add(page1, PageIdentifier.PAGE1.getDisplayName());
        mainPanel.add(page2, PageIdentifier.PAGE2.getDisplayName());
        mainPanel.add(page3, PageIdentifier.PAGE3.getDisplayName());

        add(mainPanel);
        setVisible(true);
    }

    // Helper method to get the current page by checking which component is visible.
    public Component getCurrentPage() {
        for (Component component : mainPanel.getComponents()) {
            if (component.isVisible()) {
                return component; // Return the currently visible component
            }
        }
        return null; // Return null if no component is visible
    }

    // Using a safe cast to confirm that the component is a page and call the onPageShown method. this allows us to dynamically update the page once we navigate to it.
    public void navigateToPage(String pageName) {
        cardLayout.show(mainPanel, pageName);
        Component currentPage = getCurrentPage();
        if (currentPage instanceof Page) {
            ((Page) currentPage).onPageShown();
        }
    }
}
