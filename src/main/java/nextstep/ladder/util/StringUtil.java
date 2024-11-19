package nextstep.ladder.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    public static List<String> convert(String value, String delimiter) {
        return toList(split(value, delimiter));
    }

    private static String[] split(String value, String delimiter) {
        return value.split(delimiter);
    }

    private static List<String> toList(String[] value) {
        return Arrays.asList(value);
    }
}
