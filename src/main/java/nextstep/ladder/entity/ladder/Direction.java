package nextstep.ladder.entity.ladder;

public enum Direction {
    RIGHT(1),
    LEFT(-1),
    NONE(0);

    int directionPoint;

    Direction(int directionPoint) {
        this.directionPoint = directionPoint;
    }

    static Direction direction(boolean drawRule) {
        return drawRule ? Direction.RIGHT : NONE;
    }
}
