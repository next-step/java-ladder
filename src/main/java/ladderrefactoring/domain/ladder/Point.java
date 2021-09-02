package ladderrefactoring.domain.ladder;

public class Point {
    private final int index;
    private final boolean left;
    private final boolean right;


    public Point(int index, boolean left, boolean right) {
        this.index = index;
        this.left = left;
        this.right = right;
    }

    public int move() {
        return 0;
    }
}
