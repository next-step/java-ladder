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

    public boolean isYourPosition(int i, int j) {
        return horizontalPosition == i && verticalPosition == j;
    }
}
