package domain;

public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        System.out.println("is left? " + this.direction.isLeft());
        System.out.println("is right? " + this.direction.isRight());
        if (this.direction.isRight()) {
            return this.index + 1;
        } else {
            return this.direction.isLeft() ? this.index - 1 : this.index;
        }
    }

    public Point next() {
        return new Point(this.index + 1, this.direction.next());
    }

    public Point next(Boolean right) {
        return new Point(this.index + 1, this.direction.next(right));
    }

    public Point last() {
        return new Point(this.index + 1, this.direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public String toString() {
        return "Point{index=" + this.index + ", direction=" + this.direction + '}';
    }
}
