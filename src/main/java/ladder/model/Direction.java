package ladder.model;

public enum Direction {
    DOWN(false, false, 0),
    RIGHT(false, true, 1),
    LEFT(true, false, -1);

    private final boolean left;
    private final boolean right;
    private final int step;

    Direction(boolean left, boolean right, int step) {
        this.left = left;
        this.right = right;
        this.step = step;
    }

    public int move(int position) {
        return position + step;
    }
}
