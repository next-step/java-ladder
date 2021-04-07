package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineConnectionRandomStrategy;
import nextstep.ladder.strategy.LineConnectionStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineGenerator {

    private static final int LINE_START_POINT = 0;

    private LineGenerator() {
    }

    public static LineGenerator getInstance() {
        return LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final LineGenerator instance = new LineGenerator();
    }

    public List<Boolean> generateLine(int width, LineConnectionStrategy lineConnectionStrategy) {
        boolean[] previousLine = {false};
        List<Boolean> line = IntStream.range(LINE_START_POINT, width)
                .mapToObj(i -> {
                    previousLine[LINE_START_POINT] = lineConnectionStrategy.createLine(previousLine[LINE_START_POINT]);
                    return previousLine[LINE_START_POINT];
                }).collect(Collectors.toList());
        return line;
    }

    public List<Line> generateLines(int ladderHeight, int width) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(h -> Line.of(width, new LineConnectionRandomStrategy()))
                .collect(Collectors.toList());
    }
}
