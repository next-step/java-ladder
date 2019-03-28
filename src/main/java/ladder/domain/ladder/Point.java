package ladder.domain.ladder;

public enum Point {
    CROSS("-----"),
    NOT_CROSS("     ");

    private final String view;

    Point(String view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return this.view;
    }
}
