package util;

public class StringUtils {
    private static final String DELIMITER_COMMA = ",";

    public static String[] toStringArrays(String value) {
        return value.split(DELIMITER_COMMA);
    }
}
