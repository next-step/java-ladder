package nextstep.ladder.domain;

public enum Direction {

    LEFT(-1),
    RIGHT(1),
    STRAIGHT(0);
    public int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int value(){
        return direction;
    }

}
