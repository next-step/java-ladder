package ladder.Model;

public class Point {
    private final boolean left;
    private final boolean right;
    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("사다리 라인은 양쪽 모두 있을 수 없습니다.");
        }

        this.left = left;
        this.right = right;
    }

    public Direction move() {
        if (right) {
            return Direction.RIGHT;
        }

        if (left) {
            return Direction.LEFT;
        }

        return Direction.DOWN;
    }
}
