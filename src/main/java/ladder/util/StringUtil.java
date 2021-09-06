package ladder.util;

import static java.lang.Character.isWhitespace;
import static java.util.Objects.isNull;

public class StringUtil {

    private static final String INVALID_NULL_INPUT_ERROR_MESSAGE = "String 값은 null이 들어올 수 없다.";

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
        checkNullInput(input);

        return input.contains(COMMA);
    }

    public static String[] splitByComma(String input) {
        return input.replaceAll(BLANK, EMPTY).split(COMMA);
    }

    private static void checkNullInput(String input) {
        if (isNull(input)) {
            throw new IllegalArgumentException(INVALID_NULL_INPUT_ERROR_MESSAGE);
        }
    }

}
