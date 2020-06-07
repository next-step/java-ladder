package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Position {

    private final int position;
    private final Height height;
    private final Line line;

    public Position(int position, Height height, Line line) {
        this.position = position;
        this.height = height;
        this.line = line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position &&
                Objects.equals(height, position1.height) &&
                Objects.equals(line, position1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, height, line);
    }
}
