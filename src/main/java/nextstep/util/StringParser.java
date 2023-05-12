package nextstep.util;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public static final String DELIMINATOR = ",";

    public static List<String> split(String text) {
        return Arrays.asList(text.split(DELIMINATOR));
    }
}
