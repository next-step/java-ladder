package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.strategy.LadderGenerateStrategy;

public class Ladder {
    private static final int MIN_LENGTH = 1;
    private static final String MIN_LENGTH_ERROR = "사다리 길이는 최소 " + MIN_LENGTH + "이상이어야 합니다.";

    private List<Line> lines = new ArrayList<>();

    public Ladder(int maxLength, Users users, LadderGenerateStrategy randomGenerateStrategy) {
        validateMinLength(maxLength);
        for (int i = 0; i < users.size(); i++) {
            lines.add(Line.of(users, randomGenerateStrategy));
        }
    }

    private void validateMinLength(int minLength) {
        if (minLength < MIN_LENGTH) {
            throw new IllegalArgumentException(MIN_LENGTH_ERROR);
        }
    }
}
