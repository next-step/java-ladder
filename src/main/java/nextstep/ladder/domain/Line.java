package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.strategy.LineConnectionStrategy;

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

    public List<Boolean> toList() {
        return line.stream()
            .collect(Collectors.toList());
    }
}
