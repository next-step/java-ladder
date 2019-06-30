package ladder.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    public static List<String> split(String s, String delimiter) {

        return Arrays.stream(s.split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static boolean isBlank(String s) {

        return s == null || s.isEmpty();
    }
}
