package nextstep.ladder.domain;

public enum PointType {
    VERTICAL_LINE("|"),
    HORIZONTAL_LINE("-----"),
    EMPTY("     ");

    private String text;

    PointType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
