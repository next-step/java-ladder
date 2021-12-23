package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.strategy.Strategy;

import java.util.Objects;

public class Ladder {
    public static final String LADDER_HEIGHT_LIMIT_MESSAGE = "사다리는 최소 1단이어야 합니다.";
    public static final int MIN = 1;

    private final Lines lines;
    private final int height;

    private Ladder(int height, Lines lines) {
        this.height = height;
        this.lines = lines;
    }

    public static Ladder from(int height, int numberOfParticipants, Strategy strategy) {
        if (height < MIN) {
            throw new IllegalArgumentException(LADDER_HEIGHT_LIMIT_MESSAGE);
        }

        Lines lines = Lines.from(height, numberOfParticipants, strategy);
        return new Ladder(height, lines);
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
