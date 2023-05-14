package ladder.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {
    private static final String STRING_DELIMITER = ",";

    private StringSplitter() {
    }

    public static List<String> splitStrings(String strings) {
        return Arrays.stream(strings.split(STRING_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
