package nextstep.ladder.domain;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
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

    public boolean isRight() {
        return right;
    }
}
