package ladder.domain;

import ladder.common.ErrorMessage;

public class LadderHeight {

    private static final int MIN_HEIGHT = 0;
    private final int value;

    public LadderHeight(int value) {
        valid(value);
        this.value = value;
    }

    private void valid(int value) {
        if (value <= MIN_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.LADDER_HEIGHT_IS_WRONG);
        }
    }

    public int size() {
        return value;
    }
}
