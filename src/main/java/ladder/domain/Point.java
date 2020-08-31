package ladder.domain;

public class Point {
    private static final int FIRST_INDEX = 0;

    private int index;
    private boolean left;
    private boolean right;

    private Point(int index, boolean left, boolean right) {
        this.index = index;
        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    // 테스트용
    public static Point of(int index, boolean left, boolean right) {
        return new Point(index, left, right);
    }

    public static Point getFirst(boolean right) {
        return new Point(FIRST_INDEX,false, right);
    }

    public static Point getLast(int index, boolean left) {
        return new Point(index, left, false);
    }

    public Point next(boolean nextRight) {
        if(Boolean.TRUE.equals(this.right)) {
            return new Point(index + 1, this.right, false);
        }
        return new Point(index + 1, false, nextRight);
    }

    public int move() {
        int nextIndex = index;

        if (this.right) {
            nextIndex++;
        }

        if (this.left) {
            nextIndex--;
        }

        return nextIndex;
    }
}
