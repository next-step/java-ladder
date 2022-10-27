package ladder.domain.ladder;

public enum HorizontalLineDirection {

    LEFT(true, false), RIGHT(false, true), NONE(false, false);

    private final boolean left;
    private final boolean right;

    HorizontalLineDirection(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }
}
