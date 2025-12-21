package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class LadderPosition {

    private final Position row;
    private final Position column;

    public LadderPosition(int row, int column) {
        this(new Position(row), new Position(column));
    }

    public LadderPosition(Position row, Position column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LadderPosition that = (LadderPosition) o;
        return Objects.equals(row, that.row) && Objects.equals(column, that.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
