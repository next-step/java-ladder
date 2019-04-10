package ladder.domain;

public class Point {
    private final boolean left;
    private final boolean current;

    public Point(boolean left, boolean current) {
        if(left && current) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.current = current;
    }

    public boolean hasHorizontalLine() {
        return current;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return current;
    }

    public boolean isCenter() {
        return !left && !current;
    }
}
