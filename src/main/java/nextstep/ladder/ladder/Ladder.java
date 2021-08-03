package nextstep.ladder.ladder;

import nextstep.ladder.strategy.LadderStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(LadderBound bound, LadderStrategy strategy) {
        List<Line> collect = IntStream.range(START_INDEX, bound.getHeight())
                .mapToObj(s -> Line.of(bound.getWidth(), strategy))
                .collect(Collectors.toList());
        return new Ladder(collect);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
