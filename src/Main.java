import FileIO.IO;
import Pages.AppStateManager;
import java.io.FileNotFoundException;


//Written by Max You (Merged to GUI)
//edited by Jeffrey
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AppStateManager GUIState = new AppStateManager();

        System.out.println("\n\n\n\n\n\n\n\n\n" + IO.readFile("src/FileIO/FinalExam.csv"));
}
}
