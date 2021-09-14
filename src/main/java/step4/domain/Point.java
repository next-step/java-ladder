package step4.domain;

public class Point {

    private final int position;
    private final Cross cross;

    public Point(int position, Cross cross) {
        this.position = position;
        this.cross = cross;
    }


    public static Point first(boolean current) {
        Cross cross = new Cross(false, current);
        return new Point(0, cross);
    }

    public int move() {
        if (cross.move() == Direction.RIGHT) {
            return position + 1;
        }
        if (cross.move() == Direction.LEFT) {
            return position - 1;
        }
        return position;
    }

    public Point next(boolean current) {
        return new Point(this.position + 1, cross.next(current));
    }

    public Point next() {
        return new Point(this.position + 1, cross.next());
    }

    public Point last() {
        return new Point(this.position + 1, cross.last());
    }

    public Cross cross() {
        return cross;
    }

    public int position() {
        return position;
    }
}

