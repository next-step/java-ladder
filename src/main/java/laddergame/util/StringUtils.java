package laddergame.util;

import java.util.List;
import java.util.Optional;

public class StringUtils {

    public static boolean isEmpty(String s) {
        return s == null || s.length() <= 0;
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    public static String repeat(String s, int count) {
        if(isEmpty(s))
            return "";

        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < count; ++i ) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String removeWhitespace(String string) {
        return Optional.ofNullable(string)
                        .orElse("")
                        .replaceAll("\\s+", "");
    }
}
