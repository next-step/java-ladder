package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nextstep.ladder.domain.line.LineGenerateStrategy;

public class Ladder {
    private final List<Line> lines;
    private final Players players;

    private Ladder(final Players players, final List<Line> lines) {
        this.players = players;
        this.lines = Collections.unmodifiableList(lines);
    }

    public static Ladder of(final Players players, final Height height) {
        if (height == null) {
            throw new IllegalArgumentException("invalid height: cannot be null");
        }

        if (players == null) {
            throw new IllegalArgumentException("invalid players: cannot be null");
        }

        return new Ladder(players, IntStream.range(0, height.toInt())
                .mapToObj(n -> Line.of(players.size(), LineGenerateStrategy.NO_LINE_STRATEGY))
                .collect(Collectors.toList()));
    }

    public static Ladder of(final List<String> names, final int height) {
        if (names == null) {
            throw new IllegalArgumentException("invalid players: cannot be null");
        }

        return Ladder.of(Players.of(names), Height.of(height));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    public List<Player> playerList() {
        return players.collect();
    }

    public List<Line> ladder() {
        return lines;
    }
}
