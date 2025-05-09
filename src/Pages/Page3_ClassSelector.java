package Pages;
// Page 2 class
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page3_ClassSelector extends JPanel {
    // TODO need to invoke a backend method to pull down all classes 

    private MainApp mainApp;
    public Page3_ClassSelector(MainApp mainApp) {
        this.mainApp = mainApp;
        setLayout(new FlowLayout());
        add(new JLabel("This is Page 3"));
         JButton button = new JButton("Go to Page 1");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showPage("Page1");
            }
        });

        JButton button2 = new JButton("Go to Page 2");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showPage("Page2");
            }
        });
        add(button);
        add(button2);
    }
}
