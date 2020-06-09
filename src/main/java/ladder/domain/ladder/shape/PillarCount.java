package ladder.domain.ladder.shape;

import ladder.exception.ErrorMessage;
import ladder.exception.ValueOutOfBoundsException;

import java.util.Objects;

public class PillarCount {

    public static final int MIN_COUNT = 1;

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

    public boolean isMinCount() {
        return value == MIN_COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PillarCount)) return false;
        PillarCount that = (PillarCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
