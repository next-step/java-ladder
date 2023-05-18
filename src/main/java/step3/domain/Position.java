package step3.domain;

public class Position {
    public int position;
    public final Point point;

    public Position(int position, Point point) {
        this.position = position;
        this.point = point;
    }

    public int move() {
        return move(this.point);
    }

    public int move(Point point) {
        if (point.move().isDirection(Direction.LEFT)) {
            return position - 1;
        }
        if (point.move().isDirection(Direction.RIGHT)) {
            return position + 1;
        }
        return position;
    }

}
