package ladder.domain.ladder;

import ladder.exception.NoSuchLadderException;

public enum HorizontalLineDirection {

    LEFT(true, false), RIGHT(false, true), NONE(false, false);

    private final boolean left;
    private final boolean right;

    HorizontalLineDirection(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        if (this == HorizontalLineDirection.RIGHT) {
            return "|-----";
        }
        if (this == HorizontalLineDirection.NONE || this == HorizontalLineDirection.LEFT) {
            return "|     ";
        }
        throw new NoSuchLadderException();
    }
}
