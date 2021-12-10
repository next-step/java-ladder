package nextstep.ladder.utils;

public class StringUtils {

    private static final String MESSAGE_INPUT_IS_NULL_OR_EMPTY = "null 이나 빈 값이 들어올 수 없습니다.";

    private StringUtils() {
    }

    public static String isNullOrEmpty(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException(MESSAGE_INPUT_IS_NULL_OR_EMPTY);
        }
        return input;
    }

}
