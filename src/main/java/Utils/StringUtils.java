package Utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtils {
    private static final String DELIMETER = ",";

    private StringUtils() {
    }

    public static boolean isBlank(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return value.trim().isEmpty();
    }

    public static List<String> splitText(String value) {
        return Stream.of(value.split(DELIMETER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}

