package ladder.domain;

import ladder.common.ErrorMessage;

public class LadderHeight {

    private final int value;

    public LadderHeight(int value) {
        valid(value);
        this.value = value;
    }

    private void valid(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(ErrorMessage.LADDER_HEIGHT_IS_WRONG);
        }
    }

    public int getValue() {
        return value;
    }
}
