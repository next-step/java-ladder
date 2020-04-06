package ladder.domain;

import ladder.domain.generator.LineGenerator;
import ladder.domain.generator.RandomLineGenerator;

import java.util.*;

public class Line {
    private final List<Boolean> lines;

    public Line(final List<Boolean> lines) {
        this.lines = lines;
    }

    public static Line of(final int playerCount) {
        return new Line(new RandomLineGenerator().generate(playerCount));
    }

    public static Line of(final int playerCount, final LineGenerator lineGenerator) {
        return new Line(lineGenerator.generate(playerCount));
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(lines);
    }

    public int move(final int playerPosition) {
        // 좌측 이동이 가능한지
        if (lines.get(playerPosition)) {
            return playerPosition - 1;
        }

        // 우측 이동이 가능한지
        if (lines.size() > playerPosition + 1 && lines.get(playerPosition + 1)) {
            return playerPosition + 1;
        }

        return playerPosition;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Line line1 = (Line) o;
        return Objects.equals(lines, line1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
