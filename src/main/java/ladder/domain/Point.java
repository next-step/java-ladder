package ladder.domain;

public enum Point {

    TRUE ("-----|"),
    FALSE("     |");

    private final String line;
    private final Direction direction;

    Point(String line) {
        this.line = line;
        direction = Direction.of(this);
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

    public int move() {
        return direction.move();
    }
}
