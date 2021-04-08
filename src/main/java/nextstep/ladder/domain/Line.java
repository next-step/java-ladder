package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.strategy.LineConnectionStrategy;

public class Line {

    private List<Boolean> line;

    private Line(final List<Boolean> line) {
        this.line = line;
    }

    public static Line of(final int width, LineConnectionStrategy lineConnectionStrategy) {
        LineGenerator lineGenerator = LineGenerator.getInstance();
        List<Boolean> line = lineGenerator.generateLine(width, lineConnectionStrategy);
        return new Line(line);
    }

    public List<Boolean> toList() {
        return line.stream()
            .collect(Collectors.toList());
    }
}
