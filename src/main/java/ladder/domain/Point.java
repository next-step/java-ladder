package ladder.domain;

public enum Point {

    TRUE ("-----|"),
    FALSE("     |");

    private final String bar;

    Point(String bar) {
        this.bar = bar;
    }

    public static Point of(boolean pointType) {
        if (pointType) {
            return Point.TRUE;
        }
        return Point.FALSE;
    }

    public String getBar() {
        return bar;
    }
}
