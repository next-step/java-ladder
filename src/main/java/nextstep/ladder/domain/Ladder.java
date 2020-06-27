package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final int height;

    private final List<Line> lines;

    private static final int FIRST = 1;
    private static final int MINIMUM_USER_COUNT = 2;

    public Ladder(int height, int countOfPerson) {
        validationCheck(height, countOfPerson);
        this.height = height;
        this.lines = createLines(height, countOfPerson);
    }

    private void validationCheck(int height, int countOfPerson) {
        if (height < FIRST) {
            throw new IllegalArgumentException("높이는 0 보다 커야 합니다.");
        }

        if (countOfPerson < MINIMUM_USER_COUNT) {
            throw new IllegalArgumentException("사용자 수는 1 보다 커야 합니다.");
        }
    }

    private List<Line> createLines(int height, int countOfPerson) {
        return IntStream.rangeClosed(FIRST, height)
                .mapToObj(index -> Line.of(countOfPerson))
                .collect(Collectors.toList());
    }

    public int getHeight() {
        return height;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
