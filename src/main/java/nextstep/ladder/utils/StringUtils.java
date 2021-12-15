package nextstep.ladder.utils;

import java.util.Optional;

public class StringUtils {

    private static final String MESSAGE_INPUT_IS_NULL_OR_EMPTY = "null 이나 빈 값이 들어올 수 없습니다.";

    private StringUtils() {
    }

    public static String validationNotNullAndEmpty(String inputString) {
        return Optional.ofNullable(inputString)
                .filter(str -> !"".equals(str))
                .orElseThrow(() -> new IllegalArgumentException(MESSAGE_INPUT_IS_NULL_OR_EMPTY));
    }
}
