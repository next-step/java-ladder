package ladder.domain;

public class Point {

    private final int index;

    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public int move() {
        if (direction.isLeft()) {
            return index - 1;
        }
        if (direction.isRight()) {
            return index + 1;
        }
        return index;
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }


    public Point(boolean bool){
         this(0,Direction.first());
    }

    public boolean isFilled() {
        return true;
    }

    public static Point emptyPoint() {
        return Point.first(true);
    }

    public static Point randomPoint() {
        return Point.first(true);
    }
}
