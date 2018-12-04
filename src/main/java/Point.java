public class Point {
    private int idx;
    private Direction direction;

    public Point(int idx, Direction direction) {
        this.idx = idx;
        this.direction = direction;
    }


    public int move() {
        if(direction.isLeft()) {
            return idx-1;
        }

        if(direction.isRight()) {
            return idx+1;
        }

        return idx;
    }

    public Point next() {
        return new Point(idx + 1, direction.next());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Point last() {
        return new Point(idx+1, direction.last());
    }

    @Override
    public String toString() {
        return "Point{" +
                "idx=" + idx +
                ", direction=" + direction +
                '}';
    }
}
