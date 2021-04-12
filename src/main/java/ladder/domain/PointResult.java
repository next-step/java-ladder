package ladder.domain;

public class PointResult {
    private final Position position;
    private final Direction direction;

    public PointResult(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "PointResult{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }
}
