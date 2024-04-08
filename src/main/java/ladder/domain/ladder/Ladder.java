package ladder.domain.ladder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ladder.domain.line.ConnectionCount;
import ladder.domain.line.ConnectionGenerator;
import ladder.domain.line.Line;
import ladder.domain.player.Players;

public class Ladder {

    private final List<Line> lines;

    Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public List<List<Boolean>> ladderDetail() {
        return this.lines.stream()
                .map(Line::connections)
                .collect(Collectors.toUnmodifiableList());
    }

    public static Ladder of(final Players players, final int height, final ConnectionGenerator connectionGenerator) {
        return of(players.connectionCount(), height, connectionGenerator);
    }

    public static Ladder of(final int count, final int height, final ConnectionGenerator connectionGenerator) {
        return of(ConnectionCount.from(count), new Height(height), connectionGenerator);
    }

    public static Ladder of(
            final ConnectionCount connectionCount,
            final Height height,
            final ConnectionGenerator connectionGenerator
    ) {
        final List<Line> lines = Stream.generate(() -> Line.of(connectionCount, connectionGenerator))
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
