import CLISearchEngine.CLIEngine;
import FileIO.IO;
import Pages.AppStateManager;
import java.io.FileNotFoundException;

/*
Modifed by Max You and Jeffrey Chu on 5/12/2025
CSCI 185 M03
Final Exam Finder
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AppStateManager GUIState = new AppStateManager();

        System.out.println("\n\n\n\n\n\n\n\n\n" + IO.readFile("src/FileIO/FinalExam.csv"));

        CLIEngine cliEngine = new CLIEngine();
        cliEngine.runEngine();
    }
}
