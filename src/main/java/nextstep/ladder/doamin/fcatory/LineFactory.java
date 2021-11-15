package nextstep.ladder.doamin.fcatory;

import nextstep.ladder.doamin.Line;
import nextstep.ladder.strategy.LineStrategy;
import nextstep.ladder.utils.Preconditions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineFactory {
    private static final Integer RANGE_START = 1;
    private static final Integer MINIMUM_HEIGHT_SIZE = 1;
    private static final Integer MINIMUM_PERSON_SIZE = 2;

    public List<Line> createLines(LineStrategy lineStrategy, Integer countOfPerson, Integer heightOfLadder) {
        Preconditions.checkMinimumSize(countOfPerson, MINIMUM_PERSON_SIZE,
                                       String.format("사람 수는 %s 이상 이어야 합니다.", MINIMUM_PERSON_SIZE));
        Preconditions.checkMinimumSize(heightOfLadder, MINIMUM_HEIGHT_SIZE,
                                       String.format("사다리 높이는 %s 이상 이어야 합니다.", MINIMUM_HEIGHT_SIZE));

        return IntStream.rangeClosed(RANGE_START, heightOfLadder)
                .boxed()
                .map(h -> Line.from(lineStrategy.createPoints(countOfPerson)))
                .collect(Collectors.toList());
    }
}
