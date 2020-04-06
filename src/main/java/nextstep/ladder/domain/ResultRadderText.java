package nextstep.ladder.domain;

public enum ResultRadderText {
    VERTICAL("|"),
    LINE("-----"),
    NO_LINE("     "),
    BLANK(" "),
    NEW_LINE("\n");

    private String text;

    ResultRadderText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
