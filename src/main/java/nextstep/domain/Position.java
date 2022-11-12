package nextstep.domain;

public class Position {
    private int direction;

    public Position(int direction) {
        this.direction = direction;
    }

    public int move(int point) {
        direction += point;
        return direction;
    }
}
