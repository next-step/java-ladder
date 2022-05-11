package nextstep.ladder.utils;

import java.util.Objects;

public final class StringUtils {

    private StringUtils() { }

    public static boolean isEmpty(String name) {
        return Objects.isNull(name) || name.isEmpty();
    }
}
