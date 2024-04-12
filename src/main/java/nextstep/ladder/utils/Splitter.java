package nextstep.ladder.utils;

import java.util.Arrays;
import java.util.List;

public class Splitter {
    public static final String COMMA_DELIMITER = ",";

    private Splitter() {}

    public static List<String> byDelimiter(String input, String delimiter) {
        assertNotBlank(input);
        return Arrays.asList(input.split(delimiter));
    }

    private static void assertNotBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("문자열을 입력해주세요.");
        }
    }

}
