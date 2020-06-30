package ladder.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    public static List<String> split(String text, String regex) {
        validateNullOrEmpty(text);
        return Arrays.stream(text.split(regex)).map(String::trim).collect(Collectors.toList());
    }

    private static void validateNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("입력된 텍스트가 비어있거나 NULL 입니다.");
        }
    }
}
