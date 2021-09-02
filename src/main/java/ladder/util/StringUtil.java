package ladder.util;

public class StringUtil {

    private static final int ZERO = 0;

    private StringUtil() {
    }

    public static boolean isBlank(String input) {
        if (input == null || input.length() == ZERO) {
            return true;
        }
        return false;
    }
}
