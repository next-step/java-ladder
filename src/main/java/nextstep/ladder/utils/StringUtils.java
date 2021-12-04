package nextstep.ladder.utils;

public class StringUtils {
    private static final String DELIMITER = ",";

    private StringUtils() {
        throw new AssertionError();
    }

    public static String[] split(String s) {
        return s.split(DELIMITER);
    }
}
