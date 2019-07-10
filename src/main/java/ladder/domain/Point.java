package ladder.domain;

public class Point {
    private final int index;
    private final boolean isLeft;
    private final boolean isRight;

    private Point(int index, boolean isLeft, boolean isRight) {
        if (isLeft && isRight) {
            throw new IllegalArgumentException("사다리는 왼쪽과 오른쪽이 동시에 존재 할 수 없습니다.");
        }
        this.index = index;
        this.isLeft = isLeft;
        this.isRight = isRight;
    }

    public static Point first(boolean isRight) {
        return new Point(0, false, isRight);
    }

    public int move() {
        if (isLeft) {
            return index - 1;
        }
        if (isRight) {
            return index + 1;
        }
        return index;
    }

    public Point next() {
        return new Point(index + 1, isRight, false);
    }
}
