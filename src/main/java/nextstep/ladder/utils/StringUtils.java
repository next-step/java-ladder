package nextstep.ladder.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    private static final String DELIMITER = ",";

    private StringUtils() {

    }

    public static List<String> splitByComma(String value) {
        return Arrays.stream(value.split(DELIMITER))
                .collect(Collectors.toList());
    }
}
