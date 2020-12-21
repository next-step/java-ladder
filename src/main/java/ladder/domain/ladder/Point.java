package ladder.domain.ladder;

public class Point {

    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Point next(boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point last(boolean left) {
        return new Point(index + 1, direction.last(left));
    }

    public int move() {
        if(isRight()){
            return index + 1;
        }
        if(isLeft()) {
            return index -1;
        }

        return index;
    }

    public boolean isLeft() {
        return direction.isLeft();
    }

    public boolean isRight() {
        return direction.isRight();
    }

    public int getCurrentIndex() {
        return index;
    }
}