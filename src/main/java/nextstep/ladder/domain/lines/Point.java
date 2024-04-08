package nextstep.ladder.domain.lines;

public class Point {

    private final boolean value;

    public Point(boolean value) {
        this.value = value;
    }

    public boolean isPointFalse() {
        return !value;
    }

    public boolean isPointTrue() {
        return value;
    }

    public Point decideNextPoint(Boolean randomBoolean) {
        if (!value) {
            return new Point(randomBoolean);
        }
        return new Point(false);
    }
}
