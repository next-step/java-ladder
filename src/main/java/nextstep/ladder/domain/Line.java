package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineConnectionStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final int LINE_START_POINT = 0;
    private List<Boolean> lines;

    private Line(final List<Boolean> lines) {
        this.lines = lines;
    }

    public static Line of(final int participantCount, LineConnectionStrategy lineConnectionStrategy) {
        boolean[] previousLine = {false};

        List<Boolean> lines = IntStream.range(LINE_START_POINT, participantCount)
                .mapToObj(i -> {
                    previousLine[LINE_START_POINT] = lineConnectionStrategy.createLine(previousLine[LINE_START_POINT]);
                    return previousLine[LINE_START_POINT];
                }).collect(Collectors.toList());

        return new Line(lines);
    }
}
