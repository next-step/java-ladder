package nextstep.ladder.domain;

public class Point {
    private final boolean left;
    private final boolean current;

    private Point(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("연속된 가로선은 허용되지 않습니다.");
        }
        this.left = left;
        this.current = current;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point next(boolean current) {
        return new Point(this.current, current);
    }

    public Point last() {
        return new Point(this.current, false);
    }

    public Direction move() {
      if (left) {
        return Direction.LEFT;
      }
      if (current) {
        return Direction.RIGHT;
      }
      return Direction.DOWN;
    }

    public boolean hasRightConnection() {
        return current;
    }
}