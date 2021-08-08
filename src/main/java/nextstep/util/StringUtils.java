package nextstep.util;

import java.util.Objects;

public class StringUtils {
    private StringUtils() {}

    public static boolean isEmpty(final String args) {
        return Objects.isNull(args) || args.isEmpty();
    }
}
