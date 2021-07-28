package nextstep.ladder.exception;

public class OutOfRangeArgumentException extends IllegalArgumentException {
    private static final String LESS_THAN_OR_EQUAL_TO_FORMAT = "Value should less than or equal to %d, but it wat %d";
    private static final String GREATER_THAN_OR_EQUAL_TO_FORMAT = "Value should greater than or equal to %d, but it wat %d";

    public OutOfRangeArgumentException(String message) {
        super(message);
    }

    public static OutOfRangeArgumentException lessThanOrEqualTo(int maximum, int input) {
        return new OutOfRangeArgumentException(String.format(LESS_THAN_OR_EQUAL_TO_FORMAT, maximum, input));
    }

    public static OutOfRangeArgumentException greaterThanOrEqualTo(int minimum, int input) {
        return new OutOfRangeArgumentException(String.format(GREATER_THAN_OR_EQUAL_TO_FORMAT, minimum, input));
    }
}
