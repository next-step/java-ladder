package ladder.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtil {
    private InputUtil() {
        throw new IllegalArgumentException("util class");
    }

    public static List<String> PlayerDelimiter(String names, String delimiter) {
        return Arrays.stream(names.split(delimiter)).collect(Collectors.toList());
    }
}
