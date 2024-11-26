package nextstep.laddergame.domain;

import java.util.Objects;

public class Ladder {
    private final Position position;
    private final Lines lines;


    public Ladder(int position, Lines lines) {
        this(new Position(position), lines);
    }

    public Ladder(Position position, Lines lines) {
        this.position = position;
        this.lines = lines;
    }

    public Position nextPosition() {
        return position.next();
    }

    public boolean isLineAlreadySetAt(int floor) {
        return lines.isAlreadySetAt(floor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(position, ladder.position) && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, lines);
    }
}
