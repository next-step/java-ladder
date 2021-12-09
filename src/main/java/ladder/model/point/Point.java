package ladder.model.point;

import ladder.model.direction.Direction;

import java.util.Objects;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction){
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Point last() {
        return new Point(this.index, this.direction.last());
    }

    public Point next() {
        return new Point(this.index + 1, this.direction.next());
    }

    public boolean isLeft() {
        return this.direction.left();
    }

    public boolean isRight() {
        return this.direction.right();
    }

    public int move() {
        if(isLeft()) {
            return this.index - 1;
        }
        if(isRight()) {
            return this.index + 1;
        }
        return this.index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
}
