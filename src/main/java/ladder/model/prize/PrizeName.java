package ladder.model.prize;

import java.util.Objects;

import static ladder.Messages.WARNING_LADDER_PRIZE_NOT_ALLOWED_STRING;
import static ladder.Messages.WARNING_NOT_ALLOWED_NUMBER;

public class PrizeName {
    private static final int MINIMUM_VALUE_FOR_POSITIVE = 0;
    private static final String BLANK = "꽝";

    private String prizeName;

    public PrizeName(String prizeName) {
        if (!isAllowedInputPrize(prizeName)) {
            validateNumber(prizeName);
            validatePositive(prizeName);
        }
        this.prizeName = prizeName;
    }

    public static PrizeName of(String prizeName){
        return new PrizeName(prizeName);
    }

    public String getPrizeName() {
        return prizeName;
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
        if (Integer.parseInt(prizeName) < MINIMUM_VALUE_FOR_POSITIVE) {
            throw new IllegalArgumentException(WARNING_NOT_ALLOWED_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrizeName prizeName1 = (PrizeName) o;
        return Objects.equals(prizeName, prizeName1.prizeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeName);
    }
}