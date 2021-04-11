package nextstep.ladder.entity;

public class Line {
    private final Direction lineDirection;

    public Line(Direction direction) {
        this.lineDirection = direction(direction, new RandomDrawRule());
    }

    public Line(Direction direction, DrawRule drawRule) {
        this.lineDirection = direction(direction, drawRule);
    }

    public Direction getLineDirection() {
        return lineDirection;
    }

    public Direction direction(Direction direction, DrawRule drawRule) {
        return direction.equals(Direction.RIGHT) ? Direction.LEFT : drawRule.nextDirection();
    }
}
