package ladder.domain.ladder;

import ladder.exception.LadderMinimumHeightException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Ladder {

    public static final int MIN_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder(final DirectionStrategy directionStrategy, final int ladderHeight, final int userCount) {
        validateLadderHeight(ladderHeight);

        lines = IntStream.range(0, ladderHeight)
                .mapToObj(ignore -> Line.generate(directionStrategy, userCount))
                .collect(Collectors.toList());
    }

    private void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_HEIGHT) {
            throw new LadderMinimumHeightException(ladderHeight);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
