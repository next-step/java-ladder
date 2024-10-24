package ladder2;

public class Position {
    private final int index;
    private final Point point;

    private Position(int index, Point point) {
        this.index = index;
        this.point = point;
    }

    public static Position first(boolean right) {
        return new Position(0, Point.first(right));
    }

    public Position next() {
        return new Position(index + 1, point.next(new NextGenerator()));
    }

    public boolean checkRange(int playerCount) {
        return playerCount - 2 > index;
    }

    public Position next(boolean right) {
        return new Position(index + 1, point.next(right));
    }

    public Position last() {
        return new Position(this.index + 1, point.last());
    }

    public int move() {
        if (point.move() == Direction.Right) {
            return index + 1;
        }
        if (point.move() == Direction.Left) {
            return index - 1;
        }
        return index;
    }
}
