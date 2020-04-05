package ladder.model;

import static ladder.Messages.WARNING_LADDER_PRIZE_NOT_ALLOWED_STRING;

public class LadderPrize {
    private static final String BLANK = "꽝";

    private String prizeName;

    public LadderPrize(String prizeName) {
        validateString(prizeName);
        validateNumber(prizeName);
        this.prizeName = prizeName;
    }

    private void validateString(String input) {
        if (!BLANK.equals(input)) {
            throw new IllegalArgumentException(WARNING_LADDER_PRIZE_NOT_ALLOWED_STRING);
        }
    }

    private void validateNumber(String prizeName){
        try {
            Integer.parseInt(prizeName);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(WARNING_LADDER_PRIZE_NOT_ALLOWED_STRING);
        }
    }
}
