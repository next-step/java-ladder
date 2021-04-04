package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    private static final String PLAYER_COUNT_VALIDATE_MESSAGE = "참여자는 2명 이상이여야 합니다";
    private static final int MINIMUM_PLAYER_BOUND = 2;

    private final List<Point> points;

    public Line(int countOfPerson) {
        validatePersonCount(countOfPerson);
        this.points = createPoints(countOfPerson);
    }

    private void validatePersonCount(int countOfPerson) {
        if (countOfPerson < MINIMUM_PLAYER_BOUND) {
            throw new IllegalArgumentException(PLAYER_COUNT_VALIDATE_MESSAGE);
        }
    }

    private List<Point> createPoints(int countOfPerson) {
        return Stream.generate(Point::new)
                .limit(countOfPerson)
                .collect(Collectors.toList());
    }

    public int pointSize() {
        return points.size();
    }
}
