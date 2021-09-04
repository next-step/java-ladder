package ladder.util;

import static java.lang.Character.isWhitespace;

public class StringUtil {

    private static final int ZERO = 0;

    private static final String COMMA = ",";

    private static final String BLANK = "\\s";
    private static final String EMPTY = "";

    private StringUtil() {
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

    public static boolean containsComma(String input) {
        return input.contains(COMMA);
    }

    public static String[] splitByComma(String input) {
        return input.replaceAll(BLANK, EMPTY).split(COMMA);
    }

}
