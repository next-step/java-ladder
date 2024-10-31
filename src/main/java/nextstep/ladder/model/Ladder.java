package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final int height;

    private static final int MIN_HEIGHT = 1;
    private static final int MIN_COUNT_OF_PERSON = 2;

    public Ladder(int height, int countOfPerson) {
        validateHeight(height);
        validateCountOfPerson(countOfPerson);

        lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfPerson - 1))
                .collect(Collectors.toUnmodifiableList());

        this.height = height;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return height;
    }

    private void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < MIN_COUNT_OF_PERSON) {
            throw new IllegalArgumentException("사다리 인원은 2명 이상이어야 합니다.");
        }
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 0보다 커야 합니다.");
        }
    }
}
