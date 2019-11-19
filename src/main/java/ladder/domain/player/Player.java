package ladder.domain.player;

import ladder.domain.common.Point;

public class Player {
    private final Name name;
    private final Point point;

    public Player(Name name, Point point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name.getName();
    }

    public boolean isEqualCol(int x) {
        return point.getX() == x;
    }
}
