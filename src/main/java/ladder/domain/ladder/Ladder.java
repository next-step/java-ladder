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

    private void validateLadderHeight(final int ladderHeight) {
        if (ladderHeight < MIN_HEIGHT) {
            throw new LadderMinimumHeightException(ladderHeight);
        }
    }

    public int run(final int startPosition) {
        int position = startPosition;
        for (Line line : lines) {
            position = move(line, position);
        }
        return position;
    }

    private int move(final Line line, final int position) {
        return line.move(position);
    }

    public List<Line> getLines() {
        return lines;
    }
}
