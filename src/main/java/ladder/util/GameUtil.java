package ladder.util;

import java.util.Collection;
import java.util.Objects;

public class GameUtil {
    public static final String LINE_STRING_FOR_FALSE = "     |";
    public static final String LINE_STRING_FOR_TRUE = "-----|";
    public static final int ZERO = 0;
    public static final int MIN_WIDTH = 2;
    public static final int MIN_HEIGHT = 1;

    private GameUtil() {
    }

    public static String booleanToLineString(boolean value) {
        if (value) {
            return LINE_STRING_FOR_TRUE;
        }
        return LINE_STRING_FOR_FALSE;
    }

    public static void requireNonNullOrSizeGreaterThanZero(Collection collection) {
        Objects.requireNonNull(collection);

        if (collection.size() == ZERO) {
            throw new IllegalArgumentException();
        }
    }
}
