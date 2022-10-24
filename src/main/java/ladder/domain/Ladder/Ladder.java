package ladder.domain.Ladder;

public enum Ladder {

    LEFT(true, false), RIGHT(false, true), NONE(false, false);

    private final boolean left;
    private final boolean right;

    Ladder(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }
}
