package ladder.utils;

import java.util.Objects;

public class StringUtils {

    public static void validate(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("There is no input. Please check your input.");
        }
    }

    private static boolean isEmpty(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }

    public static String[] getNamesFrom(String input) {
        return input.trim().replaceAll(" ", "").split(",");
    }
}
