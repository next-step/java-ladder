package nextstep.ladder.util;

import java.util.Optional;

public class StringUtil {

    private static final String DELIMITER = ",";

    private StringUtil() {
    }

    public static String[] toStringArray(String strings) {
        return Optional.ofNullable(strings)
                .filter(string -> !string.isBlank())
                .orElseThrow(() ->
                        new IllegalArgumentException("문자열에 공백 또는 null은 허용되지 않습니다."))
                .split(DELIMITER);
    }
}
