package Pages;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Jeffrey: First page, allows you to select a campus.
public class Page1_CampusSelector extends Page {

    // Constructor
    public Page1_CampusSelector(AppStateManager state) {
        super(state);
    }

    // Add Compoenents to our page.
    @Override
    public void addComponents() {
        JLabel quickSearchLabel = new JLabel("Use this to quick search:");
        JTextField quickSearchField = new JTextField("");
        quickSearchField.setPreferredSize(new java.awt.Dimension(150, 25));

        add(quickSearchLabel);
        add(quickSearchField);
        addButton(this, "Click to Quick Search", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setQuickSearchQuery(quickSearchField.getText());
                state.setQuickSearch(true);
                state.navigateTo(PageIdentifier.PAGE4);
            }
        });
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));

        // Add a title to the page
        JLabel title = new JLabel("Choose your campus");
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        infoPanel.add(title);
        infoPanel.add(buttonPanel);

        // Creates buttons for campus selection and moves to the next page.
        // calling State manager to update the campus info based on the button pressed.
        addGridButton(buttonPanel, "Long Island", (ActionEvent e) -> {
            state.setCampus(Campus.LONG_ISLAND);
            state.navigateTo(PageIdentifier.PAGE2);
        });

        addGridButton(buttonPanel, "New York City", (ActionEvent e) -> {
            state.setCampus(Campus.NEW_YORK_CITY);
            state.navigateTo(PageIdentifier.PAGE2);
        });

        this.scrollPane = new JScrollPane(infoPanel);
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.scrollPane.setPreferredSize(new java.awt.Dimension(1600, 900));
        add(this.scrollPane);

    }

    @Override
    public void addButton(JPanel panel, String name, ActionListener action) {
        JButton button = new JButton(name);
        button.addActionListener(action);
        panel.add(button);
    }

    public void addGridButton(JPanel panel, String name, ActionListener action) {
        JButton button = new JButton(name);
        button.setFont(new Font("Arial", Font.PLAIN, 30));
        button.addActionListener(action);
        panel.add(button);
    }
}