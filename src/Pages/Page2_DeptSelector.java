package Pages;
// Page 2 class
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page2_DeptSelector extends JPanel {
    // TODO need to invoke a backend method to create a series of buttons for dept selection & add them (could be a list or something)

    private MainApp mainApp;
    private JLabel campusLabel;

    public Page2_DeptSelector(MainApp mainApp) {
        this.mainApp = mainApp;
        setLayout(new FlowLayout());
        campusLabel = new JLabel("Campus Selected: " + mainApp.getCampus().getName());

        add(campusLabel);
         JButton button = new JButton("Go to Page 1");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showPage("Page1");
            }
        });
        JButton button2 = new JButton("Go to Page 3");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showPage("Page3");
            }
        });
        add(button);
        add(button2);
    }

    public void updateCampusLabel() {
        campusLabel.setText("Campus Selected: " + mainApp.getCampus());
    }
}
