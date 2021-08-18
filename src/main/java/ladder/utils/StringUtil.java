package ladder.utils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringUtil {

    private StringUtil() {
        throw new IllegalStateException();
    }

    public static boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }

    public static String rightPad(String text, int length) {
        return rightPad(text, length, " ");
    }

    public static String rightPad(String text, int length, String padString) {
        int padLength = length - text.length();

        return IntStream.range(0, padLength)
                .mapToObj(i -> padString)
                .collect(Collectors.joining("", text, ""));

    }
}
