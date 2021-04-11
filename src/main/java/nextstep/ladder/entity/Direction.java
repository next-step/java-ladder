package nextstep.ladder.entity;

public enum Direction {
    RIGHT(1),
    LEFT(-1),
    NONE(0);

    int directionPoint;

    Direction(int directionPoint) {
        this.directionPoint = directionPoint;
    }
}
