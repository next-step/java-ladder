package nextstep.ladder.utils;

import java.util.stream.Stream;

public class StringUtils {
    private final static String BLANK = " ";

    private StringUtils() {}

    public static boolean isEmpty(String value) {
        return value == null || "".equals(value.trim());
    }

    public static String generateBlank(int length) {
        if (length == 0) return "";
        return Stream.generate(()-> BLANK)
                .limit(length - 1)
                .reduce(BLANK, (a, b) -> a + b);
    }
}
