package ladder.domain;

public class Point {

    private final Boolean left;
    private final Boolean right;

    public Point(Boolean left, Boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Point first(Boolean right) {
        return new Point(false, right);
    }

    public static Point last(Boolean left) {
        return new Point(left, false);
    }
}
