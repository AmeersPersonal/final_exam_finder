import CLISearchEngine.CLIEngine;
import FileIO.IO;
import Pages.AppStateManager;
import java.io.FileNotFoundException;

/*
Modifed by Max You and Jeffery
CSCI 185 M03
Final Exam Finder
Date: 5/12/2025
 */
//Written by Max You (Merged to GUI)
//edited by Jeffrey
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AppStateManager GUIState = new AppStateManager();

        System.out.println("\n\n\n\n\n\n\n\n\n" + IO.readFile("src/FileIO/FinalExam.csv"));

        CLIEngine cliEngine = new CLIEngine();
        cliEngine.runEngine();
    }
}
