package ladder.domain;

import ladder.constant.LadderConstants;
import ladder.strategy.Point;
import ladder.strategy.PointStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final String MINIMUM_PERSON_ERROR = "2명 이상 참여해야합니다.";
    private static final int MINIMUM_PERSON = 2;

    private final PointStrategy pointStrategy;
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        this(countOfPerson, Point.instance());
    }

    public Line(int countOfPerson, PointStrategy pointStrategy) {
        validCountOfPersonUnderTwo(countOfPerson);
        this.pointStrategy = pointStrategy;
        this.points = createPoints(countOfPerson);
    }

    private void validCountOfPersonUnderTwo(int countOfPerson) {
        if (MINIMUM_PERSON > countOfPerson) {
            throw new IllegalArgumentException(MINIMUM_PERSON_ERROR);
        }
    }

    private List<Boolean> createPoints(int countOfPerson) {
        Boolean[] isExistBefore = {false};
        return IntStream.range(LadderConstants.DEFAULT_FIRST_INDEX, countOfPerson)
                .mapToObj(index -> {
                    if (index == (countOfPerson - LadderConstants.MINUS_ONE_INDEX)) {
                        return false;
                    }
                    isExistBefore[LadderConstants.DEFAULT_FIRST_INDEX] = !isExistBefore[LadderConstants.DEFAULT_FIRST_INDEX]
                                                    ? pointStrategy.isPoint() : false;
                    return isExistBefore[LadderConstants.DEFAULT_FIRST_INDEX];
                }).collect(Collectors.toList());
    }

    public List<Boolean> readOnlyPoints() {
        return Collections.unmodifiableList(points);
    }
}
