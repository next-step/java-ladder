package nextstep.ladder.domain;

import java.util.Objects;

public class Position {
    private static Position position;
    private int x;
    private int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position getInstance(int x, int y) {
        if(Objects.isNull(position)) {
            position = Position.of(x, y);
        }
        return position;
    }

    private static Position of(int x, int y) {
        return new Position(x, y);
    }

    public void leftMove() {
        this.x++;
        this.y--;
    }

    public void rightMove() {
        this.x++;
        this.y++;
    }

    public void down() {
        this.x++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
