package ladder.refactoring.domain;

public enum Orientation {
    LEFT(-1), RIGHT(1), STAY(0);

    private final int val;

    Orientation(int val) {
        this.val = val;
    }

    public static int next(boolean left, boolean right) {
        if (left) {
            return LEFT.val;
        }
        if (right) {
            return RIGHT.val;
        }
        return STAY.val;
    }
}
