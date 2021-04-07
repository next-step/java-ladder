package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineConnectionRandomStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineGenerator {

    private LineGenerator() {
    }

    public static LineGenerator getInstance() {
        return LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final LineGenerator instance = new LineGenerator();
    }

    public List<Line> generateLines(int ladderHeight, int width) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(h -> Line.of(width, new LineConnectionRandomStrategy()))
                .collect(Collectors.toList());
    }
}
