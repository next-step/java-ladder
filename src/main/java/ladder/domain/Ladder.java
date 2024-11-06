package ladder.domain;

import ladder.domain.util.HorizontalGenerator;

import java.util.Objects;

public class Ladder {
    public static final int START = 0;
    private final Lines lines;
    private final Players players;

    public Ladder(Players players, int verticalLadderSize, HorizontalGenerator generator) {
        this(players, new Lines(players, verticalLadderSize, generator));
    }

    public Ladder(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
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

    public String toLadderString() {
        return lines.toLinesString(players);
    }
}
