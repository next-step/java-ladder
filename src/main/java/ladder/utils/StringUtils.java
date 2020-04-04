package ladder.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class StringUtils {

    private static final String NON_CREATE_MSG = "유틸 객체 생성 불가";

    private StringUtils() {
        throw new IllegalArgumentException(NON_CREATE_MSG);
    }

    public static List<String> splitStringToList(final String input, final String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(s -> s.trim())
                .collect(Collectors.toList());
    }
}
