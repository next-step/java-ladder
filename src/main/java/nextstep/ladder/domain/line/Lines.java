package nextstep.ladder.domain.line;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(int height, int width) {
        this.lines = createLines(height, width);
    }

    private List<Line> createLines(int height, int width) {
        return IntStream.range(0, height)
                        .mapToObj(i -> new Line(width))
                        .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
