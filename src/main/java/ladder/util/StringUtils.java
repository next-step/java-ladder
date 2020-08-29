package ladder.util;

public class StringUtils {

    private StringUtils() {
    }

    public static String[] split(String string, String delimiter) {
        return string
                .trim()
                .split(delimiter);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }
}
