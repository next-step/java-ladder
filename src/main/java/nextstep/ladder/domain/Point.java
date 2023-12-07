package nextstep.ladder.domain;

import java.util.Random;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        validate(left, right);

        this.left = left;
        this.right = right;
    }

    private void validate(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("사다리는 2개가 연속해서 만들어질 수 없습니다.");
        }
    }

    public static Point first() {
        return new Point(false, random());
    }

    public Point last() {
        return new Point(this.right, false);
    }

    public Point next() {
        return new Point(this.right, random());
    }

    private static boolean random() {
        return new Random().nextBoolean();
    }

    public static Point left() {
        return new Point(true, false);
    }

    public boolean isLeft() {
        return this.left && !this.right;
    }

    public boolean isRight() {
        return !this.left && this.right;
    }
}
