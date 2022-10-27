package ladder.domain.ladder;

import ladder.exception.NoSuchLadderException;

public enum HorizontalLineDirection {

    LEFT(1, true, false), RIGHT(2, false, true), NONE(3, false, false);

    private final int type;
    private final boolean left;
    private final boolean right;

    HorizontalLineDirection(int type, boolean left, boolean right) {
        this.type = type;
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
