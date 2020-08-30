package ladder.domain;

public enum Point {

    TRUE ("-----|"),
    FALSE("     |");

    private final String line;

    Point(String line) {
        this.line = line;
    }

    public static Point of(boolean pointType) {
        if (pointType) {
            return Point.TRUE;
        }
        return Point.FALSE;
    }

    public String lineString() {
        return line;
    }
}
