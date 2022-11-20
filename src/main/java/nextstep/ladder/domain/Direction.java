package nextstep.ladder.domain;

public enum Direction {

    LEFT(-1),
    RIGHT(1),
    STRAIGHT(0);

    private int directionValue;

    Direction(int directionValue) {
        this.directionValue = directionValue;
    }
}
