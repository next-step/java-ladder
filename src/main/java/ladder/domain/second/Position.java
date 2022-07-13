package ladder.domain.second;

import ladder.domain.ConnectingStrategy;

public class Position {
    private int index;
    private Point point;

    private Position(int index, Point point) {
        this.index = index;
        this.point = point;
    }

    public static Position first(boolean right) {
        return new Position(0, Point.first(right));
    }

    public int move() {
        switch (point.move()) {
            case LEFT : return --index;
            case RIGHT: return ++index;
            case PASS : return index;
            default   : return index;
        }
    }

    public Position next(boolean right) {
        return new Position(index + 1, point.next(right));
    }

    public Position next(ConnectingStrategy connectingStrategy) {
        if (connectable()) {
            return new Position(index + 1, point.next(connectingStrategy.connectable()));
        }
        return new Position(index + 1, point.next(false));
    }

    public Position last() {
        return new Position(index + 1, point.last());
    }

    public boolean connectable() {
        return !point.isRight();
    }

    public boolean movable() {
        return point.isRight();
    }
}
