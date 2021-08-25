package nextstep.ladder.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    private static final String REGEX = ",";

    public static List<String> splitWithComma(String input) {
        return Arrays.stream(input.split(REGEX))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
