package study.core;

public class Edge {
    private final boolean left;
    private final boolean current;

    private Edge(boolean left, boolean current) {
        if (left && current) {
            current = false;
        }
        this.left = left;
        this.current = current;
    }

    public static Edge first(boolean current) {
        return new Edge(false, current);
    }

    public Edge next(boolean current) {
        return new Edge(this.current, current);
    }

    public Edge last() {
        return new Edge(this.current, false);
    }

    public boolean isCurrent() {
        return current;
    }

    public Direction move() {
        if (current) {
            return Direction.RIGHT;
        }
        if (left) {
            return Direction.LEFT;
        }
        return Direction.PASS;
    }

    public boolean isRight() {
        return move() == Direction.RIGHT;
    }

    public boolean isLeft() {
        return move() == Direction.LEFT;
    }
}
