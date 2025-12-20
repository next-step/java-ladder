package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class LadderPosition {

    private int row;
    private int column;

    public LadderPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LadderPosition that = (LadderPosition) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
