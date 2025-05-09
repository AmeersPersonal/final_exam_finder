package Pages;
// Main application class
import javax.swing.*;

import java.awt.*;

public class MainApp extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainApp() {
        setTitle("Multi-Page App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create instances of page classes
        Page1 page1 = new Page1(this);
        Page2 page2 = new Page2(this);
        Page3 page3 = new Page3(this);

        // Add pages to the card layout
        mainPanel.add(page1, "Page1");
        mainPanel.add(page2, "Page2");
        mainPanel.add(page3, "Page3");

        add(mainPanel);
        setVisible(true);
    }

    public void showPage(String pageName) {
        cardLayout.show(mainPanel, pageName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainApp::new);
    }
}
