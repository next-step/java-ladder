package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    private static final String COMMA = ",";
    private static final String REGEX_WHITESPACE = "\\s+";
    private static final String EMPTY_STRING = "";

    public static List<String> separateStringWithComma(String string) {
        return Arrays.stream(string.replaceAll(REGEX_WHITESPACE, EMPTY_STRING).split(COMMA))
                .collect(Collectors.toList());
    }
}
