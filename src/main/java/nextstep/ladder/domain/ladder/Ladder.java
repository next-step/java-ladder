package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.Condition;
import nextstep.ladder.domain.ladder.strategy.Strategy;

import java.util.Objects;

public class Ladder {
    private final Lines lines;
    private final int height;

    private Ladder(Lines lines, int height) {
        this.lines = lines;
        this.height = height;
    }

    public static Ladder from(Condition condition, Strategy strategy) {
        Lines lines = Lines.from(condition, strategy);
        return new Ladder(lines, condition.heightOfLadder());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return height == ladder.height && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines, height);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                ", height=" + height +
                '}';
    }
}
