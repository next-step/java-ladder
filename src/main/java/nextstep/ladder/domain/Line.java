package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineConnectionStrategy;

import java.util.List;
import java.util.stream.Stream;

public class Line {

    private static final LineGenerator lineGenerator = LineGenerator.getInstance();
    private List<Boolean> line;

    private Line(final List<Boolean> line) {
        this.line = line;
    }

    public static Line of(final int participantCount, LineConnectionStrategy lineConnectionStrategy) {
        List<Boolean> line = lineGenerator.generateLine(participantCount, lineConnectionStrategy);
        return new Line(line);
    }

    public Stream<Boolean> stream() {
        return line.stream();
    }
}
