package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

public class LadderHeight {

    private final int value;

    public LadderHeight(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_HEIGHT);
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
