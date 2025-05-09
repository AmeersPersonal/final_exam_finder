package Pages;
// Page 1 class
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Page1 extends JPanel {
    private MainApp mainApp;

    public Page1(MainApp mainApp) {
         this.mainApp = mainApp;
        setLayout(new FlowLayout());
        add(new JLabel("This is Page 1"));
        JButton button = new JButton("Go to Page 2");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showPage("Page2");
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
}