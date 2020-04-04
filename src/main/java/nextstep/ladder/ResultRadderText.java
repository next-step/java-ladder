package nextstep.ladder;

public enum ResultRadderText {
    DEPTH("|"),
    LINE("-----"),
    NO_LINE("     ");

    private String text;

    ResultRadderText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
