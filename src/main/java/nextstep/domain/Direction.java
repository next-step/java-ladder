package nextstep.domain;

public class Direction {
    private int direction;

    public Direction(int direction) {
        this.direction = direction;
    }

    public int move(int point) {
        direction += point;
        return direction;
    }
}
