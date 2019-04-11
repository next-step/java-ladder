package ladder.domain;

public class Point {
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_LEFT = -1;
    private static final int MOVE_CENTER = 0;
    private final boolean left;
    private final boolean current;

    public Point(boolean left, boolean current) {
        if(left && current) {
            current = false;
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

    public int move() {
        int result = 0;
        if(isRight()) result = MOVE_RIGHT;
        if(isLeft()) result = MOVE_LEFT;
        if(isCenter()) result = MOVE_CENTER;

        return result;
    }

    public boolean next() {
        return current;
    }
}
