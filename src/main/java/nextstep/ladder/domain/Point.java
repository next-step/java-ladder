package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BridgeStrategy;

public class Point {

    private final int index;

    private final Direction direction;

    public static Point first(BridgeStrategy strategy) {
        return new Point(0, Direction.first(strategy.makeBridge()));
    }

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        return index + direction.move();
    }


/*    public void setFirst() {
        this.direction.
    }*/
}
