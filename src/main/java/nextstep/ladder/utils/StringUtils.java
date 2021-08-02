package nextstep.ladder.utils;

import java.util.Objects;

public class StringUtils {
    private StringUtils() {}

    public static boolean isEmpty(String stringValue) {
        return Objects.isNull(stringValue) || stringValue.isEmpty();
    }
}
