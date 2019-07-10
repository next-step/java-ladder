package ladder.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class StringSplitter {
    public static final String SEPARATOR = ",";

    public static List<String> split(String input) {
        final String[] names = input.trim().split(SEPARATOR);

        return Arrays.stream(names)
                     .map(String::trim)
                     .collect(Collectors.toList());
    }

    private StringSplitter() {}
}
