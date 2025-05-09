package Pages;
// Page 2 class
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page2 extends JPanel {
    private MainApp mainApp;
    public Page2(MainApp mainApp) {
        this.mainApp = mainApp;
        setLayout(new FlowLayout());
        add(new JLabel("This is Page 2"));
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
}
