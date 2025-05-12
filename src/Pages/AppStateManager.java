package Pages;

import java.util.ArrayList;

import javax.swing.JPanel;

import Academics.Course;
import Pages.Campus;

public class AppStateManager {

    // Instance fields
    private AppRouter mainPage;
    private Campus campus;
    private String deptSelected;
    private String courseSelected;
    private ArrayList<String> deptList;
    private ArrayList<String> courseList;
    private ArrayList<String> finalCourseList;
    private boolean quickSearch;
    private String quickSearchQuery;

    // State Manager for our app, an all-in-one place to retrieve and update state via the application.
    // Part of this was inspired by web development, specifically React and how they have different state varables.
    public AppStateManager() {

        // instantiate all instance fields
        this.campus = Campus.NONE; // Default campus
        this.deptSelected = "";
        this.courseSelected = "";
        this.deptList = new ArrayList<>();
        this.courseList = new ArrayList<>();
        this.finalCourseList = new ArrayList<>();
        this.quickSearch = false;
        this.quickSearchQuery = "";

        // StateManager uses the main Page to tell the page where it needs to navigate to.
        
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

    public String getCourse() {
        return this.courseSelected;
    }

    public ArrayList<String> getDeptList() {
        return StringArrayListCopy(this.deptList);
    }

    public ArrayList<String> getCourseList() {
        return StringArrayListCopy(this.courseList);
    }

    public ArrayList<String> getFinalCourseList() {
        return StringArrayListCopy(this.finalCourseList);
    }

    public boolean getQuickSearch() {
        return this.quickSearch;
    }

    public String getQuickSearchQuery() {
        return this.quickSearchQuery;
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

    public void setDeptList(ArrayList<String> deptList) {
        this.deptList = deptList;
    }

    public void setCourseList(ArrayList<String> courseList) {
        this.courseList = courseList;
    }  

    public void setFinalCourseList(ArrayList<String> courseList) {
        this.finalCourseList = courseList;
    }  

    public void setQuickSearch(boolean quickSearch) {
        this.quickSearch = quickSearch;
    }

    public void setQuickSearchQuery(String query) {
        this.quickSearchQuery = query;
    }

    // navigate to a page. State Manager has it to tell the main page where to go. 
    public void navigateTo(PageIdentifier pageName) {
        this.mainPage.navigateToPage(pageName.getDisplayName());
    }
    
    private ArrayList<String> StringArrayListCopy(ArrayList<String> list) {
        ArrayList<String> listCopy = new ArrayList<String>();

        list.forEach((String s) -> {
            listCopy.add(s);
        });

        return listCopy;
    }

        private ArrayList<Course> CourseArrayListCopy(ArrayList<Course> list) {
        ArrayList<Course> listCopy = new ArrayList<Course>();

        list.forEach((Course s) -> {
            listCopy.add(s);
        });

        return listCopy;
    }
}
