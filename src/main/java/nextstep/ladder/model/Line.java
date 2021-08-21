package nextstep.ladder.model;

public class Line {
    private final CoordinateValue heightPosition;

    public Line(CoordinateValue heightPosition) {
        this.heightPosition = heightPosition;
    }

    public boolean heightIs(CoordinateValue height) {
        return this.heightPosition.equals(height);
    }

    public CoordinateValue getHeightPosition() {
        return heightPosition;
    }
}
