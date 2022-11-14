package ladder.model;

public enum Direction {
    LEFT(new Axis(1, -1)),
    RIGHT(new Axis(1, 1)),
    DOWN(new Axis(1, 0)),
    ;

    private Axis axis;

    Direction(Axis axis) {
        this.axis = axis;
    }

    public Axis getAxis() {
        return axis;
    }
}
