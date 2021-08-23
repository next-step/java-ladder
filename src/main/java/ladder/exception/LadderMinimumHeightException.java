package ladder.exception;

import ladder.domain.ladder.Ladder;

public final class LadderMinimumHeightException extends IllegalArgumentException {

    private static final String MESSAGE = "사다리 높이는 %d 이상이어야 합니다. (입력값: %d)";

    public LadderMinimumHeightException(final int input) {
        super(String.format(MESSAGE, Ladder.MIN_HEIGHT, input));
    }
}
