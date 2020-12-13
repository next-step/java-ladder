package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

public class LadderGoal {

    private final String value;

    public LadderGoal(String value) {
        throwIfNullOrEmpty(value);
        this.value = value;
    }

    private void throwIfNullOrEmpty(String value) {
        if (value == null || value.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_GOAL);
        }
    }
}
