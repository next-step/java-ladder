package nextstep.ladder.model;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import nextstep.ladder.model.strategy.RandomPointPickerStrategy;

public class Ladder {
    private static final String INVALID_LADDER_LENGTH_EXCEPTION_MESSAGE = "사다리의 높이는 양수여야 합니다.";

    private final List<Line> lines;

    public Ladder(int ladderLength, int countOfPerson) {
        validate(ladderLength);
        this.lines = IntStream.range(0, ladderLength)
            .mapToObj(idx -> new Line(countOfPerson, new RandomPointPickerStrategy()))
            .collect(toList());
    }


    int move(int startPosition) {
        int resultPosition = startPosition;
        // TODO: 사다리 이동 로직 완성 할 것
        return resultPosition;
    }


    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    private void validate(int ladderLength) {
        if (ladderLength <= 0) {
            throw new IllegalArgumentException(INVALID_LADDER_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
