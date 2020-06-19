package ladder.util;

import java.util.Arrays;
import java.util.List;

public class ConvertUtils {
    private static final String DELIMITER = ",";

    public static List<String> split(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }
}
