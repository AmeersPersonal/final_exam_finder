/*
Modifed by Jeffrey Chu on 5/12/2025
CSCI 185 M03
Final Exam Finder
 */

package Pages;


// Main application class
import java.awt.*;
import javax.swing.*;

// Jeffrey: Page Navigator, handles the main application and navigation between pages.
public class AppRouter {
    // Include State Manager, which manages the state of the whole application
    private JFrame frame;
    // CardLayout is used to showcase one page at a time.
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public AppRouter(AppStateManager state) {
        // StateManager uses the mainApp instance 
        this.frame = new JFrame();

        // JFrame settings
        this.frame.setTitle("Final Exam Searcher");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(1920, 1280);

        this.cardLayout = new CardLayout();
        this.mainPanel = new JPanel(this.cardLayout);

        // Create instances of page classes
        Page1_CampusSelector page1 = new Page1_CampusSelector(state);
        Page2_DeptSelector page2 = new Page2_DeptSelector(state);
        Page3_ClassSelector page3 = new Page3_ClassSelector(state);
        Page4_FinalCourseList page4 = new Page4_FinalCourseList(state);

        // Add pages to the card layout
        this.mainPanel.add(page1, PageIdentifier.PAGE1.getDisplayName());
        this.mainPanel.add(page2, PageIdentifier.PAGE2.getDisplayName());
        this.mainPanel.add(page3, PageIdentifier.PAGE3.getDisplayName());
        this.mainPanel.add(page4, PageIdentifier.PAGE4.getDisplayName());

        this.frame.add(mainPanel);
        this.frame.setVisible(true);
    }

    // Helper method to get the current page by checking which component is visible.
    public Component getCurrentPage() {
        for (Component component : this.mainPanel.getComponents()) {
            if (component.isVisible()) {
                return component; // Return the currently visible component
            }
        }
        return null; // Return null if no component is visible
    }

    // Using a safe cast to confirm that the component is a page and call the onPageShown method. this allows us to dynamically update the page once we navigate to it.
    public void navigateToPage(String pageName) {
        this.cardLayout.show(this.mainPanel, pageName);
        Component currentPage = getCurrentPage();
        if (currentPage instanceof Page) {
            ((Page) currentPage).onPageShown();
        }
    }
}
