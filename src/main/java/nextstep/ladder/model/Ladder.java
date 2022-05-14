package nextstep.ladder.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final String NOT_NULL_CREATE_MESSAGE = "사다리는 생성이 되어야 합니다.";
    private static final String EMPTY_EXCEPTION_MESSAGE = "사다리의 높이는 1보다 작을 수 없습니다. (입력받은 사다리 높이:%d)";
    private static final int LEAST_HEIGHT_SIZE = 1;
    private static final int START_INDEX = 0;

    private final List<Line> ladder;

    public Ladder(int participant, int height) {
        this(create(participant, height));
    }

    public Ladder(List<Line> ladder) {
        validateNullCheck(ladder);
        this.ladder = ladder;
    }

    private void validateNullCheck(List<Line> ladder) {
        if(ladder == null || ladder.isEmpty()) {
            throw new IllegalArgumentException(NOT_NULL_CREATE_MESSAGE);
        }
        ladder.forEach(line -> line.validateNullCheck(line.bars()));
    }

    private static List<Line> create(int participant, int height) {
        validateHeightLength(height);
        return IntStream.range(START_INDEX, height)
                .mapToObj(i -> new Line(participant))
                .collect(Collectors.toList());
    }

    private static void validateHeightLength(int value) {
        if (value < LEAST_HEIGHT_SIZE) {
            throw new IllegalArgumentException(String.format(EMPTY_EXCEPTION_MESSAGE, value));
        }
    }

    public List<Line> lines() {
        return ladder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "ladder=" + ladder +
                '}';
    }
}
