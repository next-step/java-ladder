package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ladder.exception.LadderHeightException;

public class Ladder {
    private static final int LADDER_MIN_HEIGHT = 2;
    private static final String LADDER_MIN_HEIGHT_EXCEPTION_COMMENT = "사다리의 높이는 %d이상이어야 합니다.";

    private final List<Line> ladder;

    private Ladder(int countOfPerson, int height) {
        validate(height);
        ladder = Collections.unmodifiableList(
            Stream.generate(() -> Line.from(countOfPerson))
                .limit(height)
                .collect(Collectors.toList())
        );
    }

    public static Ladder from(int countOfPerson, int height) {
        return new Ladder(countOfPerson, height);
    }

    private void validate(int height) {
        if (height < LADDER_MIN_HEIGHT) {
            throw new LadderHeightException(String.format(LADDER_MIN_HEIGHT_EXCEPTION_COMMENT, LADDER_MIN_HEIGHT));
        }
    }

    public List<Line> toList() {
        return ladder;
    }
}
