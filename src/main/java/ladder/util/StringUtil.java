package ladder.util;

import java.util.List;

public class StringUtil {

    private static final String COMMA_REGEX = ",";

    public static List<String> parse(String text) {
        String[] list = text.split(COMMA_REGEX);
        return List.of(list);
    }
}
