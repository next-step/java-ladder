package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import ladder.domain.ladder.line.ConnectionGenerator;
import ladder.domain.ladder.line.Line;
import ladder.domain.player.Players;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        validateLinesAreNotEmpty(lines);

        this.lines = lines;
    }

    private void validateLinesAreNotEmpty(final List<Line> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("사다리 라인이 존재하지 않습니다.");
        }
    }

    public List<List<Boolean>> connectionsOfLines() {
        return this.lines.stream()
                .map(Line::connections)
                .collect(Collectors.toUnmodifiableList());
    }

    public int width() {
        return this.lines.get(0).width();
    }

    public Map<Integer, Integer> move() {
        Map<Integer, Integer> route = IntStream.range(0, width())
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> i));

        for (final Line line : this.lines) {
            route = line.move(route);
        }

        return Collections.unmodifiableMap(route);
    }

    public static Ladder of(final Players players, final int height, final ConnectionGenerator connectionGenerator) {
        final Width width = new Width(players.count());

        final List<Line> lines = Stream.generate(() -> Line.of(width, connectionGenerator))
                .limit(new Height(height).value())
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
