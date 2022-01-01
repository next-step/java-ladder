package nextstep.ladder.domain;

/**
 * @author han
 */
public class Position {
    private final int startPoint;
    private final int endPoint;

    public Position(int startPoint, int endPoint) {
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
        return new Position(startPoint, endPoint + point.move());
    }

    public Position move(int move) {
        return new Position(startPoint, endPoint + move);
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }
}
