package ladder.domain;

import ladder.exception.LadderException;

public class Way {

    private static final String TWO_WAY_MOVE_POSSIBLE = "양방향 이동은 불가";

    private final boolean left;
    private final boolean right;

    public Way(final boolean left, final boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    public static Way nextWay(final boolean left, final boolean right) {
        return new Way(left, right);
    }

    private void validate(final boolean left, final boolean right) {
        if (left && right) {
            throw new LadderException(TWO_WAY_MOVE_POSSIBLE);
        }
    }

    public boolean isMovableLeft() {
        return this.left;
    }

    public boolean isMovableRight() {
        return this.right;
    }
}
