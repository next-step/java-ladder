package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import nextstep.ladder.domain.line.LineGenerateStrategy;

public class Ladder {
    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public static Ladder of(final PlayerCount playerCount, final Height height) {
        if (height == null) {
            throw new IllegalArgumentException("invalid height: cannot be null");
        }

        if (playerCount == null) {
            throw new IllegalArgumentException("invalid player count: cannot be null");
        }

        return new Ladder(Stream.generate(() -> Line.of(playerCount, LineGenerateStrategy.NO_LINE_STRATEGY))
                .limit(height.toInt())
                .collect(Collectors.toList()));
    }

    public static Ladder of(final PlayerCount playerCount, final int height) {
        return Ladder.of(playerCount, Height.of(height));
    }

    public static Ladder of(final int playerCount, final int height) {
        return Ladder.of(PlayerCount.of(playerCount), Height.of(height));
    }

    public static Ladder of(final Players players, final Height height) {
        return Ladder.of(players.count(), height);
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

    public Stream<Line> stream() {
        return lines.stream();
    }
}
