package ladder.utils;

import java.util.Objects;

public class StringUtils {
    public static boolean isBlank(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
