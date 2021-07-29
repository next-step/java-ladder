package nextstep.ladder.domain.ladder;

import nextstep.ladder.exception.OutOfRangeArgumentException;

public class LadderPosition {
    private static final int ZERO = 0;

    private int position;

    private LadderPosition(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < ZERO) {
            throw OutOfRangeArgumentException.greaterThan(ZERO, position);
        }
    }

    public static LadderPosition from(int position) {
        return new LadderPosition(position);
    }
}
