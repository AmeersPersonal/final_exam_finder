import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Academics.Course;
import Academics.Deparment;
import Academics.LICourse;
import Academics.NYCCourse;
import Pages.AppStateManager;
import Pages.Campus;


//Written by Max You (Merged to GUI)
//edited by Jeffrey
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AppStateManager GUIState = new AppStateManager();

        System.out.println("\n\n\n\n\n\n\n\n\n" + IO.readFile("src/FinalExam.csv"));
}
