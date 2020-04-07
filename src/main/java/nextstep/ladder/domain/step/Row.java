package nextstep.ladder.domain.step;

import nextstep.ladder.vo.Position;

import java.util.Objects;

public class Row {
    private final Position movableLine;
    private final Position currentStep;

    private Row(int movableLine, int currentStep) {
        this.movableLine = new Position(movableLine);
        this.currentStep = new Position(currentStep);
    }

    public static Row of(int movableLine, int stepPosition) {
        return new Row(movableLine, stepPosition);
    }

    public int getCurrentStep() {
        return currentStep.getPosition();
    }

    public int getMovableLine() {
        return movableLine.getPosition();
    }

    public boolean isEqualLinePosition(int linePosition) {
        return this.movableLine.isEqualPosition(linePosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return movableLine == row.movableLine &&
                currentStep == row.currentStep;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movableLine, currentStep);
    }
}
