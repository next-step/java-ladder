package laddergame.v2.domain;

import java.util.Random;

public class Point {

    private final static Random RANDOM = new Random();

    private final boolean left;
    private final boolean right;

    public Point(final boolean left, final boolean right) {
        if(left && right){
            throw new IllegalArgumentException("옆 칸과 다리가 겹치면 이동할 수 없습니다");
        }
        this.left = left;
        this.right = right;
    }

    public static Point first(final boolean right) {
        return new Point(false, right);
    }

    public Point next(final boolean right) {
        return new Point(this.right, right);
    }

    public Point last() {
        return new Point(this.right, false);
    }

    public Direction move() {
        if(left){
            return Direction.LEFT;
        }
        if(right){
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
