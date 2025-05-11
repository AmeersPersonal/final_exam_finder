package Pages;

import java.util.ArrayList;

import javax.swing.JPanel;

import Pages.Campus;

public class AppStateManager {

    // Instance fields
    private AppRouter mainPage;
    private Campus campus;
    private String deptSelected;
    private String courseSelected;
    private ArrayList<String> deptList = new ArrayList<>();
    private ArrayList<String> courseList = new ArrayList<>();

    // State Manager for our app, an all-in-one place to retrieve and update state via the application.
    // Part of this was inspired by web development, specifically React and how they have different state varables.
    public AppStateManager() {
        System.out.println("StateManager constructor called");

        // instantiate all instance fields
        this.campus = Campus.NONE; // Default campus
        this.deptSelected = "";
        this.courseSelected = "";

        // StateManager uses the main Page to tell the page where it needs to navigate to.

        // dummy data
        deptList.add("Hello World");
        courseList.add("Hello World");
        
        this.mainPage = new AppRouter(this);
    }
    
    // getters
    public Campus getCampus() {
        // returns the selected campus w/ default to none
        return this.campus;
    }

    public String getDept() {
        return this.deptSelected;
    }

    public ArrayList<String> getDeptList() {
        return this.deptList;
    }

    public ArrayList<String> getCourseList() {
        return this.deptList;
    }

    // setters
    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public void setDeptSelected(String dept) {
        this.deptSelected = dept;
    }

    public void setCourseSelected(String courseSelected) {
        this.courseSelected = courseSelected;
    }

    // navigate to a page. State Manager has it to tell the main page where to go. 
    public void navigateTo(PageIdentifier pageName) {
        this.mainPage.navigateToPage(pageName.getDisplayName());
    }
    
}
