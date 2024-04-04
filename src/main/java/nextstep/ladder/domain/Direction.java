package nextstep.ladder.domain;

public enum Direction {

    LEFT(-1),
    RIGHT(1),
    STOP(0);

    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }

}
