package domain;

public class Point {
    private final int position;
    private final DirectionType directionType;

    public Point(int position, DirectionType directionType) {
        this.position = position;
        this.directionType = directionType;
    }

    public int move() {
        return directionType.move(position);
    }

    public static Point first(Movable right) {
        return new Point(0, DirectionType.first(right));
    }

    public Point last() {
        return new Point(position + 1, directionType.last());
    }

    public Point next(Movable right) {
        return new Point(position + 1, directionType.next(right));
    }

    public boolean hasIndex(int index) {
        return this.position == index;
    }

    public boolean hasDirectionType(DirectionType directionType) {
        return this.directionType.equals(directionType);
    }

    public boolean hasNoneDirection() {
        return this.directionType.equals(DirectionType.NONE);
    }

    public boolean hasMoveDirection() {
        return !hasNoneDirection();
    }

    @Override
    public String toString() {
        return "Point{" +
                "position=" + position +
                ", directionType=" + directionType +
                '}';
    }
}