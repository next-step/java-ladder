package nextstep.ladder.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    private static final String REGEX = ",";
    private static final int ZERO = 0;

    public static List<String> splitWithComma(String input) {
        return Arrays.stream(input.split(REGEX))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static boolean isBlank(String input) {
        return input == null || input.trim().length() == ZERO;
    }
}
