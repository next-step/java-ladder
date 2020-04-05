package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final int playerCount, final Height height) {
        this.lines = createLines(playerCount, height);
    }

    public List<Line> getLines() {
        return lines;
    }

    private List<Line> createLines(final int playerCount, final Height height) {
        final List<Line> lines = IntStream.rangeClosed(Height.MIN_HEIGHT, height.value())
                                          .mapToObj(count -> Line.of(playerCount))
                                          .collect(Collectors.toList());
        return Collections.unmodifiableList(lines);
    }
}
