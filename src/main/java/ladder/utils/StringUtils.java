package ladder.utils;

import ladder.exception.LadderException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class StringUtils {

    private static final String NON_CREATE_MSG = "유틸 객체 생성 불가";
    private static final String NON_NUMERIC_MSG = "숫자로 변환할 수 없습니다.";

    private StringUtils() {
        throw new IllegalArgumentException(NON_CREATE_MSG);
    }

    public static List<String> splitStringToList(final String input, final String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(s -> s.trim())
                .collect(Collectors.toList());
    }

    public static int stringToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LadderException(NON_NUMERIC_MSG);
        }
    }
}
