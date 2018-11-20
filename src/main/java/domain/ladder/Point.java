package domain.ladder;

public class Point {

    private int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public int move() {
        if(direction.isLeft()){
            --this.index;
        }

        if(direction.isRight()){
            ++this.index;
        }

        return this.index;
    }


    public Point next(Boolean right) {
        return new Point(++index, direction.next(right));
    }

    public Point next() {
        return new Point(++index, direction.next());
    }

    public Point last() {
        return new Point(++index, direction.last());
    }
}
