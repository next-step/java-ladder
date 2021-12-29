package nextstep.ladder.domain;

/**
 * @author han
 */
public class Position {
    private static final int FORWARD = 1;

    private final int startPoint;
    private final int endPoint;

    private Position(int startPoint, int endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Position(int index) {
        this.startPoint = index;
        this.endPoint = index;
    }

    public static Position of(Position position) {
        return new Position(position.getStartPoint(), position.getEndPoint());
    }

    public Position move(Point point) {
        Direction move = point.move();

        if (move.equals(Direction.LEFT)) {
            return new Position(startPoint, endPoint - FORWARD);
        }

        if (move.equals(Direction.RIGHT)) {
            return new Position(startPoint, endPoint + FORWARD);
        }

        return this;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }
}
