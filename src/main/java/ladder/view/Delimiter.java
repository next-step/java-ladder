package ladder.view;

public enum Delimiter {
    WHITE_SPACE(" "),
    HORIZONTAL_LINE("-"),
    VERTICAL_LINE("|"),
    LINE_SEPARATOR("\n");

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
