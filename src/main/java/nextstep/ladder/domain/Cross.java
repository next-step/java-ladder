package nextstep.ladder.domain;

import static nextstep.ladder.domain.Direction.*;

public class Cross {
    private final int position;
    private final Point point;

    public Cross(final int position, final Point point) {
        this.position = position;
        this.point = point;
    }

    public int move() {
        if (point.move() == RIGHT) {
            return position + 1;
        }

        if (point.move() == LEFT) {
            return position - 1;
        }
        return position;
    }
}
