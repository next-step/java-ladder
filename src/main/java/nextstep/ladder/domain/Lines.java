package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class Lines {
    private List<Line> lines;

    private Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(final List<Line> lines) {
        return new Lines(lines);
    }

    public Stream<Line> stream() {
        return lines.stream();
    }
}
