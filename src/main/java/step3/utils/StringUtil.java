package step3.utils;

public class StringUtil {

    private StringUtil() {
    }

    public static boolean isEmpty(String value) {
        return null == value || value.trim().isEmpty();
    }

    public static String padRight(String value, int repeat) {
        return String.format("%-" + repeat + "s", value);
    }
}
