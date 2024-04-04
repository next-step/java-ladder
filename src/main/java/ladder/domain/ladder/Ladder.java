package ladder.domain.ladder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ladder.domain.line.ConnectionGenerator;
import ladder.domain.line.Line;
import ladder.domain.line.PlayersCount;

public class Ladder {

    private final List<Line> lines;

    Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder from(
            final PlayersCount playersCount,
            final Height height,
            final ConnectionGenerator connectionGenerator
    ) {
        final List<Line> lines = Stream.generate(() -> Line.from(playersCount, connectionGenerator))
                .limit(height.value())
                .collect(Collectors.toUnmodifiableList());

        return new Ladder(lines);
    }

    @Override
    public boolean equals(final Object otherLadder) {
        if (this == otherLadder) {
            return true;
        }

        if (otherLadder == null || getClass() != otherLadder.getClass()) {
            return false;
        }

        return Objects.equals(this.lines, ((Ladder)otherLadder).lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lines);
    }
}
