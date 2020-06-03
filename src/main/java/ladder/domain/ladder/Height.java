package ladder.domain.ladder;

import ladder.exception.ErrorMessage;
import ladder.exception.ValueOutOfBoundsException;

public class Height {

    public static final int MIN_HEIGHT = 1;

    private final int value;

    private Height(final int value) {
        verifyHeight(value);
        this.value = value;
    }

    public static Height of(final int value) {
        return new Height(value);
    }

    private static void verifyHeight(final int height) {
        if (height < MIN_HEIGHT) {
            throw new ValueOutOfBoundsException(ErrorMessage.REQUIRED_MIN_LADDER_HEIGHT);
        }
    }

    public int getValue() {
        return value;
    }
}
