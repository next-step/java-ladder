package ladder.model.player;

import ladder.model.row.Row;
import ladder.model.row.Rows;

import java.util.Objects;

public class Position {
    private static final int ZERO_LOCATION = 0;
    private static final int DECREASE_ONE = -1;

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public static Position of(int position){
        return new Position(position);
    }

    public int getPosition() {
        return position;
    }

    public Position add(int value){
        return new Position(position + value);
    }

    public Position findFinalLocation(Rows rows) {
        for (Row row : rows.getRows()) {
            position = findNextPosition(row).getPosition();
        }
        return Position.of(position);
    }

    public Position findNextPosition(Row nextRow) {
        position = position + findNextDirection(nextRow).getIncrement();
        return Position.of(position);
    }

    private Direction findNextDirection(Row nextRow) {
        return Direction.findDirection(isNextLeftPositionTrue(nextRow), isNextRightPositionTrue(nextRow));
    }

    private boolean isNextLeftPositionTrue(Row nextRow) {
        return isFirstNow() ? false : nextRow.getRowElement(Position.of(position + DECREASE_ONE));
    }

    private boolean isNextRightPositionTrue(Row nextRow) {
        return isLastNow(nextRow) ? false : nextRow.getRowElement(Position.of(position));
    }

    private boolean isFirstNow() {
        return position == ZERO_LOCATION;
    }

    private boolean isLastNow(Row nextRow) {
        return position == nextRow.getLastLocationValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
