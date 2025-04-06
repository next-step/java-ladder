package nextstep.ladder.domain;

public class Point {

    private final boolean right;

    public Point(boolean right) {
        this.right = right;
    }

    public static Point withoutRight() {
        return new Point(false);
    }

    public boolean hasRight() {
        return right;
    }
}
