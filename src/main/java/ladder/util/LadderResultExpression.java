package ladder.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderResultExpression {
    private static final String SEPARATOR = ",";
    private static final String INPUT_RESULT_EXCEPTION_MESSAGE = "사다리 실행결과의 값을 입력하지 않았습니다.";

    private LadderResultExpression() {
    }

    public static List<String> validateLadderResult(String results) {
        checkNull(results);
        return toStrings(results);
    }

    private static List<String> toStrings(String results) {
        return Stream.of(results.split(SEPARATOR))
                .collect(Collectors.toList());
    }

    private static void checkNull(String results) {
        if (results == null || results.isBlank()) {
            throw new IllegalArgumentException(INPUT_RESULT_EXCEPTION_MESSAGE);
        }
    }
}
