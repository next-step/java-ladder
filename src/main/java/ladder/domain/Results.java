package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    public static final String NOT_FOUND_TARGET_MESSAGE = "대상을 찾을 수 없습니다.";
    public static final String NULL_MESSAGE = "결과는 null일 수 없습니다.";
    private final List<Result> value;

    public Results(Result... results) {
        this(toList(results));
    }

    private static List<Result> toList(Result[] results) {
        return Arrays.stream(results)
                .collect(Collectors.toList());
    }

    public Results(List<Result> value) {
        if (value == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        this.value = value;
    }

    public Result resultOf(String name) {
        return value.stream()
                .filter(result -> result.matchName(name))
                .findFirst()
                .orElseThrow(() ->new IllegalArgumentException(NOT_FOUND_TARGET_MESSAGE));
    }

    public List<Result> value() {
        return value;
    }
}
