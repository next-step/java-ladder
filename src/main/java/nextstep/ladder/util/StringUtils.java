package nextstep.ladder.util;

public final class StringUtils {

    private StringUtils() { }

    public static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
