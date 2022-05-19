package ladder.util;

import ladder.exception.NotSupportException;

import java.util.List;

public class SplitUtil {

    private static final String DEFAULT_SEPARATOR = ",";
    private static final String BLANK_VALUE = " ";
    private static final String EMPTY_VALUE = "";

    private SplitUtil() {
        throw new NotSupportException();
    }

    public static List<String> split(String values) {
        return split(values, DEFAULT_SEPARATOR);
    }

    public static List<String> split(String values, String separator) {
        return List.of(trim(values).split(separator));
    }

    private static String trim(String value) {
        return value.replace(BLANK_VALUE, EMPTY_VALUE);
    }
}
