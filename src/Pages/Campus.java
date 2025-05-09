package Pages;

// Campus enum (Basically a restricted list for strings. Prevents typos and errors)
public enum Campus {
    NONE(""),
    LONG_ISLAND("LI"),
    NEW_YORK_CITY("NYC");

    private String name;

    Campus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}