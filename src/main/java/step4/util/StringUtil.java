package step4.util;

import static java.lang.Character.isWhitespace;

import java.util.Objects;

public class StringUtil {

    private static final int ZERO = 0;

    private static final String COMMA = ",";

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

    public static boolean containsComma(String input) {
        checkNull(input);

        return input.contains(COMMA);
    }

    private static void checkNull(String input) {
        if (Objects.isNull(input)) {
            throw new NullPointException();
        }
    }

}
