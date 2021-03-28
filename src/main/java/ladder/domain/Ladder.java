package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final String MINIMUM_SIZE_ERROR = "사다리 길이는 0 보다 커야합니다.";
    private static final int MINIMUM_SIZE = 1;
    private static final int DEFAULT_FIRST_INDEX = 0;

    private List<Line> lines;

    public Ladder(int ladderSize, int countOfPerson) {
        validLadderSizeUnderOne(ladderSize);
        this.lines = createLadder(ladderSize, countOfPerson);
    }

    private void validLadderSizeUnderOne(int ladderSize) {
        if (ladderSize < MINIMUM_SIZE) {
            throw new IllegalArgumentException(MINIMUM_SIZE_ERROR);
        }
    }

    private List<Line> createLadder(int ladderSize, int countOfPerson) {
        return IntStream.range(DEFAULT_FIRST_INDEX, ladderSize)
                .mapToObj(index -> new Line(countOfPerson))
                .collect(Collectors.toList());
    }

    public List<Line> readOnlyLines() {
        return Collections.unmodifiableList(lines);
    }
}
