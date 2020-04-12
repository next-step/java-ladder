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

    private void validate(final boolean left, final boolean right) {
        if (left && right) {
            throw new LadderException(TWO_WAY_MOVE_POSSIBLE);
        }
    }

    public Way first(LadderMoveStrategy strategy) {
        return new Way(false, strategy.move());
    }

    public Way next(LadderMoveStrategy strategy) {
        boolean move = strategy.move();

        if (right) {
            return new Way(right, false);
        }
        return new Way(false, move);
    }

    public Way last() {
        if (right) {
            return new Way(right, false);
        }
        return new Way(false, false);
    }

    public boolean isMovableLeft() {
        return left;
    }

    public boolean isMovableRight() {
        return right;
    }
}
