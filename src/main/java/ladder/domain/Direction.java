package ladder.domain;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left,boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public int goLeft(int location) {
        return location - 1;
    }

    public int goRight(int location) {
        return location + 1;
    }
}
