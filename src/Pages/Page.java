package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Jeffrey: Abstract class for all pages in the application. This class provides a common structure and methods for all pages.
public abstract class Page extends JPanel{
    // Includes State Manager which holds information about the current state of the application
    protected AppStateManager state;

    // Default Constructor of our page. All pages will need a state manager, have flow layout, and call an addComponents method to add the components onto the page.
    protected Page(AppStateManager state) {
        this.state = state;
        setLayout(new FlowLayout());
        this.addComponents();
    }

    public abstract void addComponents();

    // Add Button helper method to add buttons to the page. This prevents code reuse by dealing with the button instantiation and adding it to a JPanel
    public void addButton(String name, ActionListener action) {
        JButton button = new JButton(name);
        button.addActionListener(action);
        add(button);
    }

    // method that updates all components whenever the page is shown. This will dynamically update the page once the user navigates to it.
    public void onPageShown() {
        removeAll();
        addComponents();
    };

}
