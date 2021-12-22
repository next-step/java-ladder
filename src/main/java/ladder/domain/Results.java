package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Results {

    public static final String NOT_FOUND_TARGET_MESSAGE = "대상을 찾을 수 없습니다.";
    public static final String NULL_MESSAGE = "결과는 null일 수 없습니다.";
    public static final String INVALID_RESULT_LENGTH_MESSAGE = "Names, Rewards, LadderWidth의 길이가 올바르지 않습니다.";

    private static final int INDEX_ZERO = 0;
    private final List<Result> value;

    public Results(Names names, Ladder ladder, Rewards rewards) {
        if (names.count() != rewards.count()
                || (names.count() * 2 - 1 != ladder.width())) {
            throw new IllegalArgumentException(INVALID_RESULT_LENGTH_MESSAGE);
        }

        this.value = IntStream.range(INDEX_ZERO, names.count())
                .mapToObj(index -> {
                    int rewardIndex = ladder.findRewardIndex(index);
                    return new Result(names.findByIndex(index), rewards.findByIndex(rewardIndex));
                }).collect(Collectors.toList());
    }

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
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_TARGET_MESSAGE));
    }

    public List<Result> value() {
        return Collections.unmodifiableList(value);
    }

}
