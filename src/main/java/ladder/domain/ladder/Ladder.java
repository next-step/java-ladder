package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Ladder {

    public static final int MIN_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder(final DirectionStrategy directionStrategy, final int ladderHeight, final int userCount) {
        lines = IntStream.range(0, ladderHeight)
                .mapToObj(ignore -> new Line(directionStrategy, userCount))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
