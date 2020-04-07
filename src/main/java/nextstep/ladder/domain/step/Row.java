package nextstep.ladder.domain.step;

import nextstep.ladder.domain.Position;

import java.util.Objects;

public class Row {
    private static final int ONE = 1;

    private final Position linePosition;
    private final Position stepPosition;

    private Row(int linePosition, int stepPosition) {
        this.linePosition = new Position(linePosition);
        this.stepPosition = new Position(stepPosition);
    }

    public static Row previous(Row row) {
        return new Row(decreaseOne(row.getLinePosition()), row.getStepPosition());
    }

    public static Row current(int linePosition, int stepPosition) {
        return new Row(linePosition, stepPosition);
    }

    public static Row next(int linePosition, int stepPosition) {
        return new Row(increaseOne(linePosition), stepPosition);
    }

    public static Row next(Row row) {
        return new Row(increaseOne(row.getLinePosition()), row.getStepPosition());
    }

    private static int increaseOne(int position) {
        return position + ONE;
    }

    private static int decreaseOne(int position) {
        return position - ONE;
    }

    public int getStepPosition() {
        return stepPosition.getPosition();
    }

    public int getLinePosition() {
        return linePosition.getPosition();
    }

    public boolean isEqaulLinePosition(int linePosition) {
        return this.linePosition.isEqualPosition(linePosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return linePosition == row.linePosition &&
                stepPosition == row.stepPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linePosition, stepPosition);
    }
}
