package ladder.util;

import ladder.exception.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtil {

    private StringUtil() {
    }

    public static boolean isEmpty(final String str) {
        return (str == null || str.isEmpty());
    }

    public static List<String> splitValues(final String values, final String delimiter) {
        if (isEmpty(values) || delimiter == null) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_OR_EMPTY);
        }
        return Stream.of(values.split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
