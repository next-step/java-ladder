package domain;

public class Point {
    private final int index;
    private final Direction direction;
    
    private Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    } 
    
    public static Point first(final boolean right) {
        return new Point(0, Direction.first(right));
    }

    public int move() {
        return direction.isRight() ? index + 1 : direction.isLeft() ? index - 1 : index;
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point next(final boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public boolean isRight() {
        return direction.isRight();
    }
    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }


}
