package nextstep.ladder.domain;

import java.util.List;

public class Position {
    int x;

    public Position(int x) {
        this.x = x;
    }

    public Position move(List<Point> row) {
        Direction next = row.get(x).getDirection();
        if (Direction.LEFT == next) {
            x--;
        }
        if (Direction.RIGHT == next) {
            x++;
        }
        return this;
    }

    public int getX() {
        return x;
    }

}
