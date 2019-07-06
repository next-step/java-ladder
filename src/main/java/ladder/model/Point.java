package ladder.model;

import java.util.Random;

public final class Point {
    public static Point firstOf(boolean right) {
        return new Point(right);
    }

    public static Point firstOfRandom() {
        final boolean right = new Random().nextBoolean();
        return firstOf(right);
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

    public Point nextOfRandom() {
        if (right) {
            return new Point(false);
        }
        final boolean right = new Random().nextBoolean();
        return nextOf(right);
    }

    public Point endOf() {
        return new Point(false);
    }

    public boolean isConnectedRight() {
        return right;
    }
}
