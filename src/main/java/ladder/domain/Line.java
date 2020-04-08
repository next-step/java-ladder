package ladder.domain;

import ladder.domain.generator.LineGenerator;
import ladder.domain.generator.RandomLineGenerator;

import java.util.*;

public class Line {
    private final List<Boolean> lines;

    private Line(final List<Boolean> lines) {
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

    public Position move(final Position position) {
        int playerPosition = position.value();
        // 좌측 이동이 가능한지
        if (isMoveLeft(playerPosition)) {
            return position.left();
        }

        // 우측 이동이 가능한지
        if (isMoveRight(playerPosition)) {
            return position.right();
        }
        return position;
    }

    private Boolean isMoveLeft(final int playerPosition) {
        return lines.get(playerPosition);
    }

    private boolean isMoveRight(final int playerPosition) {
        return playerPosition + Position.DEFAULT_MOVEMENT_POSITION < lines.size()
                && lines.get(playerPosition + Position.DEFAULT_MOVEMENT_POSITION);
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
