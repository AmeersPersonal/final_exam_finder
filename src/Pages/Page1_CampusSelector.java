package Pages;
// Page 1 class
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
        JTextField quickSearchField = new JTextField("Insert search query here");
        quickSearchField.setSize(100, 10);

        add(quickSearchLabel);
        add(quickSearchField);
        addButton("Click to Quick Search", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setQuickSearchQuery(quickSearchField.getText());
                state.setQuickSearch(true);
                state.navigateTo(PageIdentifier.PAGE4);
            }
        });
        

        // Add a title to the page
        JLabel title = new JLabel("Choose your campus");
        add(title);  
        
        // Creates buttons for campus selection and moves to the next page. 
        // calling State manager to update the campus info based on the button pressed.
        addButton("Long Island", (ActionEvent e) -> {
            state.setCampus(Campus.LONG_ISLAND);
            state.navigateTo(PageIdentifier.PAGE2);
        });

        addButton("New York City", (ActionEvent e) -> {
            state.setCampus(Campus.NEW_YORK_CITY);
            state.navigateTo(PageIdentifier.PAGE2);
        });   
    }
}