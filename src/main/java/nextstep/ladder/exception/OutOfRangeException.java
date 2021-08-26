package nextstep.ladder.exception;

public class OutOfRangeException extends IllegalArgumentException {

    private static String SHOULD_GREATER_THAN_OR_EQUAL_FORMAT = "파라미터는 %s 보다 크거나 같아야 합니다. 현재 : %s";
    private static String SHOULD_LESS_THAN_FORMAT = "파라미터는 %s 보다 크거나 같아야 합니다. 현재 : %s";

    private OutOfRangeException(String message) {
        super(message);
    }

    public static OutOfRangeException shouldGreaterOrEqualThan(int value, int minimum) {
        return new OutOfRangeException(String.format(SHOULD_GREATER_THAN_OR_EQUAL_FORMAT, value, minimum));
    }

    public static OutOfRangeException shouldLessThan(int value, int maximum) {
        return new OutOfRangeException(String.format(SHOULD_LESS_THAN_FORMAT, value, maximum));
    }

}
