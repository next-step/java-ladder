package ladder.model;

public enum Direction {
    LEFT(new Axis(1, -1)),
    RIGHT(new Axis(1, 1)),
    DOWN(new Axis(1, 0)),
    ;

    Direction(Axis axis) {

    }
}
