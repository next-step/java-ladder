package my.project.step4.domain;

/**
 * Created : 2020-12-11 오전 11:21
 * Developer : Seo
 */
public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(Bridge connectedOrNone) {
        return new Point(Movement.ZERO.ordinal(),
                Direction.first(connectedOrNone));
    }

    public int move() {
        if (direction.isRight()) {
            return index + Movement.ONE.ordinal();
        }
        if (direction.isLeft()) {
            return index - Movement.ONE.ordinal();
        }
        return this.index;
    }

    public Point next() {
        return new Point(index + Movement.ONE.ordinal(),
                direction.next());
    }

    public Point next(Bridge connectedOrNone) {
        return new Point(index + Movement.ONE.ordinal(),
                direction.next(connectedOrNone));
    }

    public Point last() {
        return new Point(index + Movement.ONE.ordinal(),
                direction.last());
    }

    public int present() {
        return this.index;
    }

    @Override
    public String toString() {
        return Bridge.VERTICAL.getSymbol() + direction;
    }
}
