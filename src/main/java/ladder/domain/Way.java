package ladder.domain;

import ladder.exception.LadderException;

public class Way {

    private final boolean left;
    private final boolean right;

    public Way(final boolean left, final boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    private void validate(final boolean left, final boolean right) {
        if (left && right) {
            throw new LadderException("양방향 이동은 불가");
        }
    }
}
