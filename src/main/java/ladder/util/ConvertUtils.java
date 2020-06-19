package ladder.util;

import java.util.Arrays;
import java.util.List;

public class ConvertUtils {
    private static final String DELIMITER = ",";

    public static List<String> split(String input) {
        isNotNullOrEmpty(input);
        return Arrays.asList(input.split(DELIMITER));
    }

    private static void isNotNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값은 빈 문자열이거나 null일 수 없습니다.");
        }
    }
}
