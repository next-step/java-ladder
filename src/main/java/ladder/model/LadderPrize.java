package ladder.model;

import java.util.Objects;

import static ladder.Messages.WARNING_LADDER_PRIZE_NOT_ALLOWED_STRING;
import static ladder.Messages.WARNING_NOT_ALLOWED_NUMBER;

public class LadderPrize {
    private static final String BLANK = "꽝";
    private static final int ZERO = 0;

    private String prizeName;

    public LadderPrize(String prizeName) {
        if (!isAllowedInputPrize(prizeName)) {
            validateNumber(prizeName);
            validatePositive(prizeName);
        }
        this.prizeName = prizeName;
    }

    private boolean isAllowedInputPrize(String input) {
        return BLANK.equals(input);
    }

    private void validateNumber(String prizeName) {
        try {
            Integer.parseInt(prizeName);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WARNING_LADDER_PRIZE_NOT_ALLOWED_STRING);
        }
    }

    private void validatePositive(String prizeName) {
        if (Integer.parseInt(prizeName) <= ZERO) {
            throw new IllegalArgumentException(WARNING_NOT_ALLOWED_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderPrize that = (LadderPrize) o;
        return Objects.equals(prizeName, that.prizeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeName);
    }
}