import javax.swing.JFrame;

import Pages.MainApp;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        JFrame app = new MainApp();
        app.setVisible(true);
        app.setDefaultCloseOperation(MainApp.EXIT_ON_CLOSE);
        app.setSize(400, 300);
    }
}