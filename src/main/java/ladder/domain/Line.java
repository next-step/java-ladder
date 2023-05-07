package ladder.domain;

public class Line {
    int horizontalPosition;
    int verticalPosition;

    public Line(int horizontalPosition, int verticalPosition) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
    }

    public static Line any(LineStrategy lineStrategy) {
        return new Line(lineStrategy.horizontalPosition(), lineStrategy.verticalPosition());
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getVerticalPosition() {
        return verticalPosition;
    }

    public boolean isYourPosition(int column, int row) {
        return (verticalPosition == column) && (horizontalPosition == row);
    }

    public boolean isSameColum(Line otherLine) {
        return this.verticalPosition == otherLine.verticalPosition;
    }

    public boolean isAdjacentRow(Line otherLine) {
        return Math.abs(this.horizontalPosition - otherLine.horizontalPosition) <= 1;
    }
}
