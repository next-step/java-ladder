package ladder.model.player;

public enum Direction {
    LEFT (-1, true, false),
    RIGHT(1, false, true),
    STAY(0, false, false);

    private int increment;
    private boolean isNextLeftValueTrue;
    private boolean isNextRightValueTrue;

    Direction(int increment, boolean isNextLeftValueTrue, boolean isNextRightValueTrue) {
        this.increment = increment;
        this.isNextLeftValueTrue = isNextLeftValueTrue;
        this.isNextRightValueTrue = isNextRightValueTrue;
    }

    public int getIncrement() {
        return increment;
    }

    public boolean isNextLeftValueTrue() {
        return isNextLeftValueTrue;
    }

    public boolean isNextRightValueTrue() {
        return isNextRightValueTrue;
    }
}
