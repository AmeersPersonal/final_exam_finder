/*
Modifed by Cristopher Bustos and Jeffrey Chu on 5/12/2025
CSCI 185 M03
Final Exam Finder
5/12/2025
 */

package Pages;
// Page 2 class
import Academics.Deparment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

// Second page, used to select a department based on the campuus selected
public class Page2_DeptSelector extends Page {

    // Instance fields
    private JLabel campusLabel;

    public Page2_DeptSelector(AppStateManager state) {
        super(state);
        // Empty department list for now, this will be populated once the campus is selected.
    }

    @Override
    public void addComponents() {
        addButton(this, "<- To Prev page", (ActionEvent e) -> {
            state.navigateTo(PageIdentifier.PAGE1);
        });
        // Add title label
        this.campusLabel = new JLabel("Campus Selected: " + state.getCampus().getName() + " , Please select your dept out of the list");
        add(this.campusLabel);
        this.campusLabel.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel();
        int numButtons = state.getDeptList().size();
        int columns = 4;
        int rows = (int) Math.ceil((double) numButtons / columns);
        buttonPanel.setLayout(new GridLayout(rows, columns, 10, 10));
        addButtons(state.getDeptList(), buttonPanel);
        buttonPanel.setBackground(new Color(242, 169, 0));

        scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new java.awt.Dimension(1600, 900));
        add(scrollPane);
    }

    // Helper method, takes an array of departments and creates a button for each dept.
    public void addButtons(ArrayList<String> listOfDepts, JPanel buttonPanel) {
        for (String name : listOfDepts) {
            addButton(buttonPanel, name, (ActionEvent e) -> {
                state.setDeptSelected(name);
                state.navigateTo(PageIdentifier.PAGE3);
            });
        }
    }

    @Override
    public void onPageShown() {
        state.setDeptList(Deparment.deparmentNames);
        super.onPageShown();
    }
    //Color of the Background
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(0, 45, 114));
    }
}
