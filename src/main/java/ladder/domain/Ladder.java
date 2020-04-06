package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final Height height;
    private final List<Line> lines;

    public Ladder(final int playerCount, final Height height) {
        this.height = height;
        this.lines = createLines(playerCount, height.value());
    }

    public List<Line> getLines() {
        return lines;
    }

    private List<Line> createLines(final int playerCount, final int height) {
        final List<Line> lines = IntStream.rangeClosed(Height.MIN_HEIGHT, height)
                                          .mapToObj(count -> Line.of(playerCount))
                                          .collect(Collectors.toList());
        return Collections.unmodifiableList(lines);
    }
}
