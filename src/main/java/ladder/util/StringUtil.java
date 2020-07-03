package ladder.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class StringUtil {
    private static final String DIVIDER = ",";
    private static final int MAXIMUM_CHAR = 5;

    private StringUtil() {}

    public static List<String> parse(final String input) {
        return Arrays.stream(input.split(DIVIDER))
                .peek(StringUtil::isValid)
                .collect(Collectors.toList());
    }

    private static void isValid(final String input) {
        if (input.length() > MAXIMUM_CHAR) {
            throw new IllegalArgumentException();
        }
    }

    public static String fixStringLength(final String input) {
        return String.format("%-5s", input);
    }

}
