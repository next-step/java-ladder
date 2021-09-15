package step4.util;

import static java.lang.Character.isWhitespace;

public class StringUtil {

    private static final int ZERO = 0;

    private StringUtil() {
        throw new RuntimeException("Singleton couldn't create constructor.");
    }

    public static boolean isBlank(String input) {
        if (input == null || input.length() == ZERO) {
            return true;
        }
        for (int i = ZERO; i < input.length(); i++) {
            if (!isWhitespace(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
