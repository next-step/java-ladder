package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lines {

    private List<Line> lines;

    private Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(final List<Line> lines) {
        return new Lines(lines);
    }

    public List<Line> toList() {
        return lines.stream()
            .collect(Collectors.toList());
    }
}
