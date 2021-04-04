package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private static final int HEIGHT_MINIMUM_BOUND = 1;
    private static final String HEIGHT_VALIDATE_MESSAGE = "사다리의 높이는 1 이상이어야 합니다.";

    private final List<Line> lines;

    public Ladder(int height, int countOfPerson) {
        validateHeight(height);
        lines = Stream.generate(()->new Line(countOfPerson))
                .limit(height)
                .collect(Collectors.toList());
    }

    private void validateHeight(int height) {
        if (height < HEIGHT_MINIMUM_BOUND) {
            throw new IllegalArgumentException(HEIGHT_VALIDATE_MESSAGE);
        }
    }
}
