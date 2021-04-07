package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineConnectionStrategy;

import java.util.List;
import java.util.stream.Stream;

public class Line {

    private static final LineGenerator LINE_GENERATOR = LineGenerator.getInstance();
    private List<Boolean> line;

    private Line(final List<Boolean> line) {
        this.line = line;
    }

    public static Line of(final int width, LineConnectionStrategy lineConnectionStrategy) {
        List<Boolean> line = LINE_GENERATOR.generateLine(width, lineConnectionStrategy);
        return new Line(line);
    }

    public Stream<Boolean> stream() {
        return line.stream();
    }
}
