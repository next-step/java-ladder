package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.strategy.LadderGenerateStrategy;

public class Ladder {
    private static final int START_RANGE_NUMBER = 0;
    private static final int MIN_LENGTH = 1;
    private static final String MIN_LENGTH_ERROR = "사다리 길이는 최소 " + MIN_LENGTH + "이상이어야 합니다.";

    private List<Line> lines = new ArrayList<>();

    public Ladder(int maxLength, Users users, LadderGenerateStrategy randomGenerateStrategy) {
        validateMinLength(maxLength);
        lines = IntStream.range(START_RANGE_NUMBER, maxLength)
                .mapToObj(line -> Line.of(users, randomGenerateStrategy))
                .collect(Collectors.toList());
    }

    private void validateMinLength(int minLength) {
        if (minLength < MIN_LENGTH) {
            throw new IllegalArgumentException(MIN_LENGTH_ERROR);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public Map<Integer, Integer> rideLadder(int userSize) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < userSize; i++) {
            int finalIndex = decideUserResult(i);
            resultMap.put(i, finalIndex);
        }
        return Collections.unmodifiableMap(resultMap);
    }

    private int decideUserResult(int index) {
        for (Line line : lines) {
            index = line.decideNextIndex(index);
        }
        return index;
    }
}
