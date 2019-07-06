package ladder.model;

public class Point {
    public static Point firstOf(boolean right) {
        return new Point(right);
    }

    private final boolean right;

    private Point(boolean right) {
        this.right = right;
    }

    public Point nextOf(boolean right) {
        if (this.right && right) {
            throw new IllegalArgumentException("Point는 양방향으로 연결할 수 없습니다.");
        }
        return new Point(right);
    }

    public Point endOf() {
        return new Point(false);
    }
}
