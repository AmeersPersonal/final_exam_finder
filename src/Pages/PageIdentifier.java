package Pages;

// Page Identifier (Restricted list of page strings) to prevent typos and errors
public enum PageIdentifier {
    // Page names
    PAGE1("Page 1"),
    PAGE2("Page 2"),
    PAGE3("Page 3");

    // Define a display name, constructorm and getter method so we can connect enum values to strings.
    private final String displayName;

    PageIdentifier(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
