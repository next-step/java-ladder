package nextstep.ladders.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(final PointGenerateStrategy strategy, final int countOfPerson, final int height) {
        this.lines = Stream.generate(() -> new Line(countOfPerson, strategy))
                .limit(height)
                .collect(Collectors.toList());
    }

    public int start(int row) {
        for (Line line : lines) {
            row = line.start(row);
        }
        return row;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
