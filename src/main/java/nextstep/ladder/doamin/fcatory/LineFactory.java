package nextstep.ladder.doamin.fcatory;

import nextstep.ladder.doamin.Line;
import nextstep.ladder.strategy.LineStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineFactory {
    private static final Integer RANGE_START = 1;

    public List<Line> createLines(LineStrategy lineStrategy, Integer countOfPerson, Integer heightOfLadder) {
        return IntStream.rangeClosed(RANGE_START, heightOfLadder)
                .boxed()
                .map(h -> createLine(lineStrategy, countOfPerson))
                .collect(Collectors.toList());
    }

    private Line createLine(LineStrategy lineStrategy, Integer countOfPerson) {
        return Line.from(lineStrategy.createPoints(countOfPerson));
    }
}
