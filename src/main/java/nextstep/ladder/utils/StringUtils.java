package nextstep.ladder.utils;

public class StringUtils {
    private final static String SEPARATOR = ",";
    private final static int MIN_INPUT_LENGTH = 2;

    public static boolean isEmpty(String value) {
        return (value == null || "".equals(value.trim()));
    }

    public static String[] stringToArray(String value) {
        return value.split(SEPARATOR);
    }
}
