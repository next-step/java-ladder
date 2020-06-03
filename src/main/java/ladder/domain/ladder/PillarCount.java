package ladder.domain.ladder;

import ladder.exception.ErrorMessage;
import ladder.exception.ValueOutOfBoundsException;

public class PillarCount {

    static final int MIN_COUNT = 1;

    private final int value;

    private PillarCount(final int value) {
        verifyCount(value);
        this.value = value;
    }

    public static PillarCount of(final int value) {
        return new PillarCount(value);
    }

    private static void verifyCount(final int count) {
        if (count < MIN_COUNT) {
            throw new ValueOutOfBoundsException(ErrorMessage.REQUIRED_MIN_PILLAR_COUNT);
        }
    }

    public int getValue() {
        return value;
    }
}
