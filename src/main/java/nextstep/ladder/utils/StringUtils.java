package nextstep.ladder.utils;

import java.util.Optional;

public class StringUtils {
    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";

    private StringUtils() {}

    public static String removeSpace(String input) {
        return Optional.ofNullable(input)
                .map(string -> string.replaceAll(SPACE, EMPTY_STRING))
                .orElseThrow(() -> new IllegalArgumentException("문자열을 입력하세요."));
    }
}
