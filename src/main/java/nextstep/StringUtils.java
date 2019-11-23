package nextstep;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    public static final String COMMA = ",";
    public static final String BLANK = " ";
    public static final String EMPTY = "";

    public static List<String> splitBy(String regex, String text) {
        return Arrays
                .stream(removeBlank(text).split(regex))
                .collect(Collectors.toList());
    }

    public static String removeBlank(String text) {
        return text.replace(BLANK, EMPTY);
    }
}
