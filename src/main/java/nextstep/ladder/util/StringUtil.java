package nextstep.ladder.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    private StringUtil() {
    }

    public static List<String> splitByDelimiter(String text, String delimiter) {
        return Arrays.asList(text.split(delimiter));
    }
}
