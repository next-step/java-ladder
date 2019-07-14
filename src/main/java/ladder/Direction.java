package ladder;

public class Direction {
    private boolean left;
    private boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next(PointMaker pointMaker) {
        if (this.right) {
            return next(false);
        }
        return next(pointMaker.nextBoolean());
    }

    public Direction last() {
        return of(this.right, false);
    }

    public String getLine() {
        if (right) {
            return "-".repeat(5);
        }
        return " ".repeat(5);
    }

    public int move(int index) {
        if (this.isLeft()) {
            return index - 1;
        } else if (this.right) {
            return index + 1;
        }
        return index;
    }
}
