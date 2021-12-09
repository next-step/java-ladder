package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public static Ladder of(Players players, Height height) {
        if (height == null) {
            throw new IllegalArgumentException("invalid height: cannot be null");
        }

        if (players == null) {
            throw new IllegalArgumentException("invalid players: cannot be null");
        }

        return new Ladder(IntStream.of(height.toInt())
                .mapToObj(n -> Line.of(players.size()))
                .collect(Collectors.toList()));
    }

    public static Ladder of(List<String> names, int height) {
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
}
