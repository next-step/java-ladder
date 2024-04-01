package nextstep.step2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int height, int width, PointGenerator pointGenerator) {
        this.lines = Stream.concat(
                Stream.iterate(new Line(height, pointGenerator), prev -> new Line(height, prev, pointGenerator))
                        .limit(width - 1),
                Stream.of(Line.generateEndLine(height))
        ).collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
