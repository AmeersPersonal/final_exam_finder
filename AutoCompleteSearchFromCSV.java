import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

// Made by Max You
// First take on creating the GUI Search Engine w/ JSwing, helped inspire the remaining GUI program
public class AutoCompleteSearchFromCSV extends JFrame {
    private JTextField searchBar;
    private JPopupMenu suggestionsPopup;
    private ArrayList<String> searchOptions;
    private int selectedIndex = -1;
    private static final int MAX_SUGGESTIONS = 10;  // limit to 10 options

    public AutoCompleteSearchFromCSV() {
        // Load search options from CSV file
        searchOptions = loadSearchOptionsFromCSV("FinalExam.csv");

        // Setup frame
        setTitle("Autocomplete Search Bar");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create search bar
        searchBar = new JTextField();
        searchBar.setPreferredSize(new Dimension(300, 30));
        add(searchBar);

        // Popup for suggestions
        suggestionsPopup = new JPopupMenu();

        // Document listener for typing
        searchBar.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { showSuggestions(); }
            public void removeUpdate(DocumentEvent e) { showSuggestions(); }
            public void changedUpdate(DocumentEvent e) { showSuggestions(); }
        });

        // Key listener for arrow navigation & Enter key
        searchBar.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (suggestionsPopup.isVisible()) {
                    int itemCount = suggestionsPopup.getComponentCount();

                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        selectedIndex = (selectedIndex + 1) % itemCount;
                        highlightSuggestion(selectedIndex);
                        e.consume();
                    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                        selectedIndex = (selectedIndex - 1 + itemCount) % itemCount;
                        highlightSuggestion(selectedIndex);
                        e.consume();
                    } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        if (selectedIndex >= 0 && selectedIndex < itemCount) {
                            JMenuItem item = (JMenuItem) suggestionsPopup.getComponent(selectedIndex);
                            if (!item.getText().equals("No results found")) {
                                searchBar.setText(item.getText());
                            }
                            suggestionsPopup.setVisible(false);
                            selectedIndex = -1;
                            e.consume();
                        }
                    }
                }
            }
        });

        // Hide popup when losing focus
        searchBar.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                // only hide if not clicking inside popup
                SwingUtilities.invokeLater(() -> {
                    if (!suggestionsPopup.isAncestorOf(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner())) {
                        suggestionsPopup.setVisible(false);
                        selectedIndex = -1;
                    }
                });
            }
        });
    }

    private ArrayList<String> loadSearchOptionsFromCSV(String filename) {
        ArrayList<String> options = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    if (!value.trim().isEmpty()) {
                        options.add(value.trim());
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading CSV: " + e.getMessage());
        }
        return options;
    }

    private void showSuggestions() {
        String text = searchBar.getText();
        suggestionsPopup.setVisible(false);
        suggestionsPopup.removeAll();
        selectedIndex = -1;

        if (text.isEmpty()) {
            return;
        }

        int count = 0;
        boolean found = false;

        for (String option : searchOptions) {
            if (option.toLowerCase().startsWith(text.toLowerCase())) {
                JMenuItem item = new JMenuItem(option);
                item.setBackground(Color.WHITE);

                item.addActionListener(e -> {
                    searchBar.setText(option);
                    suggestionsPopup.setVisible(false);
                    selectedIndex = -1;
                });

                suggestionsPopup.add(item);
                found = true;

                count++;
                if (count >= MAX_SUGGESTIONS) break;  // limit to MAX_SUGGESTIONS
            }
        }

        if (!found) {
            JMenuItem noResultItem = new JMenuItem("No results found");
            noResultItem.setEnabled(false);
            suggestionsPopup.add(noResultItem);
        }

        if (suggestionsPopup.getComponentCount() > 0) {
            suggestionsPopup.show(searchBar, 0, searchBar.getHeight());
        }
    }

    private void highlightSuggestion(int index) {
        for (int i = 0; i < suggestionsPopup.getComponentCount(); i++) {
            JMenuItem item = (JMenuItem) suggestionsPopup.getComponent(i);
            item.setBackground(i == index ? Color.LIGHT_GRAY : Color.WHITE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AutoCompleteSearchFromCSV().setVisible(true);
        });
    }
}
