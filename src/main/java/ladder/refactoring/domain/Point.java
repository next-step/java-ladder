package ladder.refactoring.domain;

public class Point {

    private final int postion;
    private final Direction direction;

    public Point(int postion, Direction direction) {
        this.postion = postion;
        this.direction = direction;
    }

    public static Point of(int postion, Direction direction) {
        return new Point(postion, direction);
    }

    public static Point ofFirstPoint() {
        return of(0, Direction.ofFirst());
    }

    @Override
    public int hashCode() {
        return direction.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point other = (Point) obj;
            return direction.equals(other.direction);
        }
        return false;
    }

    public Point last() {
        return of(postion + 1, direction.last());
    }

    public Point next() {
        return of(postion + 1, direction.next());
    }

    public int move() {
        return postion + direction.orient();
    }

    public boolean isRightDirection() {
        return direction.isRight();
    }
}
