package ladder.utils;

import java.util.Collections;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isNullOrBlank(String text) {
        return text == null || text.trim().isEmpty();
    }

    public static String repeat(String string, int count) {
        return String.join("", Collections.nCopies(count, string));
    }
}
