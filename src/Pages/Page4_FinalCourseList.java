package Pages;

// Page 2 class
import Academics.Course;
import Academics.LICourse;
import Academics.NYCCourse;
import FileIO.IO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

// Jeffrey: Third page that allows you to select a class based on department.
public class Page4_FinalCourseList extends Page {
    // instance fields
    private JLabel titleLabel;
    private JScrollPane scrollPane;

    // Constructor
    public Page4_FinalCourseList(AppStateManager state) {
        super(state);
    }

    // Add components to the page such as the title label.
    @Override
    public void addComponents() {
        addButton(this, "<- To Prev page", (ActionEvent e) -> {
            state.navigateTo(PageIdentifier.PAGE3);
            state.setQuickSearch(false);
        });
        this.titleLabel = new JLabel(
                "Course Selected: " + state.getCourse() + " , Look below to find the finals based on your section");
        add(this.titleLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        addButtons(state.getFinalCourseList(), buttonPanel);

        scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new java.awt.Dimension(1600, 900));
        add(scrollPane);
    }

    // Helper method to add buttons across a list of courses.
    public void addButtons(ArrayList<String> listOfFinalCourseCodes, JPanel buttonPanel) {
        for (String name : listOfFinalCourseCodes) {
            JButton button = new JButton(name);

            button.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 70)); // Fixed height of 50
            button.setAlignmentX(CENTER_ALIGNMENT);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
            buttonPanel.add(button);
        }

    }

    @Override
    public void onPageShown() {
        ArrayList<String> courseString = new ArrayList<>();

        if (state.getQuickSearch()) {
            try {
                courseString = IO.search("src/FileIO/FinalExam.csv",state.getQuickSearchQuery());
            } catch (Exception e) {
                System.out.println("Error searching: " + e.getMessage());
            }
        } else {
            // Included Max's filtering here (similar approach)
            for (Course c : Course.getCourses()) {
                if (c instanceof LICourse) {
                    LICourse LIC = (LICourse) c;
                    if (state.getCourse().equals(LIC.getCourseName())
                            && LIC.getLocation().equals(state.getCampus().getName())) {
                        courseString.add(LIC.toString());
                    }
                } else if (c instanceof NYCCourse) {
                    NYCCourse NYCC = (NYCCourse) c;
                    if (state.getCourse().equals(NYCC.getCourseName())
                            && NYCC.getLocation().equals(state.getCampus().getName())) {
                        courseString.add(NYCC.toString());
                    }
                }
            }
        }

        state.setFinalCourseList(courseString);
        // scrollPane.removeAll();
        super.onPageShown();
    }
}
