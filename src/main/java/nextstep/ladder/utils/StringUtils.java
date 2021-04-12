package nextstep.ladder.utils;

import java.util.stream.Stream;

public class StringUtils {
    private final static String BLANK = " ";
    private final static String SEPARATOR = ",";
    private final static int MIN_INPUT_LENGTH = 2;

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

    public static String[] stringToArrays(String value) {
        String[] values = value.split(SEPARATOR);
        if (values.length < MIN_INPUT_LENGTH) {
            throw new IllegalArgumentException("입력값은 " + SEPARATOR + "기준으로 최소 2개 이상이어야 합니다.");
        }
        return values;
    }
}
