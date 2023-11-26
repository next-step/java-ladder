package nextstep.ladder.domain;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public Move move(){
        if (left) {
            return Move.LEFT;
        }
        if (right) {
            return Move.RIGHT;
        }
        return Move.NONE;
    }

    public boolean isRight() {
        return right;
    }
}
