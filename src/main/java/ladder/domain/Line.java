package ladder.domain;

import ladder.domain.generator.LineGenerator;
import ladder.domain.generator.RandomLineGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Stair> stairs;

    private Line(final List<Stair> stairs) {
        this.stairs = stairs;
    }

    public static Line of(final int playerCount) {
        return new Line(new RandomLineGenerator().generate(playerCount));
    }

    public static Line of(final int playerCount, final LineGenerator lineGenerator) {
        return new Line(lineGenerator.generate(playerCount));
    }

    public List<Stair> getLine() {
        return Collections.unmodifiableList(stairs);
    }

    public Position move(final Position position) {
        int playerPosition = position.value();
        // 좌측 이동이 가능한지
        if (isMovableLeft(playerPosition)) {
            return position.left();
        }

        // 우측 이동이 가능한지
        if (isMovableRight(playerPosition)) {
            return position.right();
        }
        return position;
    }

    private boolean isMovableLeft(final int playerPosition) {
        return stairs.get(playerPosition).isExist();
    }

    private boolean isMovableRight(final int playerPosition) {
        return isLineIn(playerPosition) && nextStair(playerPosition).isExist();
    }

    private boolean isLineIn(final int playerPosition) {
        return playerPosition + Position.NEXT < stairs.size();
    }

    private Stair nextStair(final int playerPosition) {
        return stairs.get(playerPosition + Position.NEXT);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Line line = (Line) o;
        return Objects.equals(stairs, line.stairs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stairs);
    }
}