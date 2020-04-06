package ladder.model.prize;

import static ladder.Messages.WARNING_LADDER_PRIZE_NOT_ALLOWED_STRING;
import static ladder.Messages.WARNING_NOT_ALLOWED_NUMBER;

public class LadderPrize {
    private static final String BLANK = "꽝";
    private static final int MINIMUM_VALUE_FOR_POSITIVE = 0;

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

    private void validateString(String input) {
        if (!isAllowedInputPrize(input)) {
            throw new IllegalArgumentException(WARNING_LADDER_PRIZE_NOT_ALLOWED_STRING);
        }
    }

    private void validateNumber(String prizeName) {
        try {
            Integer.parseInt(prizeName);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WARNING_LADDER_PRIZE_NOT_ALLOWED_STRING);
        }
    }

    private void validatePositive(String prizeName){
        if(Integer.parseInt(prizeName) < MINIMUM_VALUE_FOR_POSITIVE){
            throw new IllegalArgumentException(WARNING_NOT_ALLOWED_NUMBER);
        }
    }
}
