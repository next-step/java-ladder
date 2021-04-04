package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final String PLAYER_COUNT_VALIDATE_MESSAGE = "참여자는 2명 이상이여야 합니다";
    private static final int CREATE_START_INDEX = 0;
    private static final int MINIMUM_PLAYER_BOUND = 2;

    private final List<Boolean> points;

    public Line(int countOfPerson) {
        validatePersonCount(countOfPerson);
        this.points = createPoints(countOfPerson);
    }

    private void validatePersonCount(int countOfPerson) {
        if (countOfPerson < MINIMUM_PLAYER_BOUND) {
            throw new IllegalArgumentException(PLAYER_COUNT_VALIDATE_MESSAGE);
        }
    }

    private List<Boolean> createPoints(int countOfPerson) {
        return IntStream.range(CREATE_START_INDEX, countOfPerson)
                .mapToObj(this::createPoint)
                .collect(Collectors.toList());
    }

    private Boolean createPoint(int idx) {
        return Boolean.FALSE;
    }

    public int pointSize() {
        return points.size();
    }
}
