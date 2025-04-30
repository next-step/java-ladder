package nextstep.ladder.domain.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringParserUtil {
    private static final String DELIM = ",";

    public static <T> List<T> parseInputString(String input, Function<String, T> mapper) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 문자열은 비어 있을 수 없습니다.");
        }

        return Arrays.stream(input.split(DELIM))
                .map(mapper)
                .collect(Collectors.toList());
    }
}
