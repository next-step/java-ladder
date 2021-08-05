package nextstep.ladder.utils;

import java.util.Objects;

public class StringUtils {
    private StringUtils() {}

    public static boolean isEmpty(String value) {
        return Objects.isNull(value) || value.isEmpty();
    }
}
