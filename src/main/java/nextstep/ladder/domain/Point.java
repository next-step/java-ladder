package nextstep.ladder.domain;

public class Point {
    private final boolean left;
    private final boolean right;

    private Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public int move(int position){
        if (left) {
            return position - 1;
        }
        if (right) {
            return position + 1;
        }
        return position;
    }

    public static Point createNextPoint(boolean left, boolean right) {
        return new Point(left, right);
    }

    public boolean isRight() {
        return right;
    }
}
