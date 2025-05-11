package Pages;

// Jeffrey: Campus enum (Basically a restricted list for strings. Prevents typos and errors)
public enum Campus {
    // Campus names
    NONE(""),
    LONG_ISLAND("LI"),
    NEW_YORK_CITY("NYC");

    // Define a campus name, constructor and getter method so we can connect enum values to strings.
    private String name;

    Campus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}