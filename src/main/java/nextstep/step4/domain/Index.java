package nextstep.step4.domain;

public class Index {
    private static final int MOVING_INDEX = 1;

    private final int position;
    private final Point point;

    private Index(int position, Point point) {
        this.position = position;
        this.point = point;
    }

    public static Index of(int position, Point point) {
        return new Index(position, point);
    }

    public int move() {
        if(point.move() == Direction.RIGHT) {
            return position + MOVING_INDEX;
        }
        
        if(point.move() == Direction.LEFT) {
            return position - MOVING_INDEX;
        }
        return position;
    }

    public Direction getDirection() {
        return point.move();
    }
}
