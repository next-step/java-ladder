package ladder.domain.ladder;

import ladder.domain.participant.Participants;
import ladder.domain.strategy.LineGenerateStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Ladder {

    private static final int START_INCLUSIVE = 0;
    private final List<Line> lines;

    public static final Ladder from(final Participants participants, final LadderHeight ladderHeight, final LineGenerateStrategy strategy) {
        return from(IntStream.range(START_INCLUSIVE, ladderHeight.height())
                .mapToObj(i -> Line.of(participants, strategy))
                .collect(Collectors.toList())
        );
    }

    public static final Ladder from(final List<Line> lines) {
        return new Ladder(lines);
    }

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }
}
