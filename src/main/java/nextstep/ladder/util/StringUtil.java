package nextstep.ladder.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    private static final String SEPARATOR = ",";
    public static List<String> separator(String inputString) {
        return Arrays.asList(inputString.split(SEPARATOR));
    }
}
