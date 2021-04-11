package nextstep.ladder.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static final String COMMA = ",";

    private StringUtil() {
    }

    public static List<String> splitWithComma(String input) {
        checkDelimiter(input, COMMA);
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void checkDelimiter(String input, String delimiter) {
        if (!input.contains(delimiter)) {
            throw new IllegalArgumentException("구분자 \"" + delimiter + "\"가 존재하는지 확인해주세요.");
        }
    }
}
