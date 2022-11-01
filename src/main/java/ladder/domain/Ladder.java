package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int userCount, int height) {
        return new Ladder(IntStream.rangeClosed(1, height)
            .mapToObj(value -> new Line(userCount))
            .collect(Collectors.toList()));
    }

    public List<Line> getLines() {
        return lines;
    }
}
