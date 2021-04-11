package nextstep.ladder.entity;

public class Line {
    private final Direction lineDirection;

    public Line(Direction direction) {
        this.lineDirection = direction(direction);
    }

    public Direction getLineDirection() {
        return lineDirection;
    }

    public Direction direction(Direction direction) {

        DrawRule randomDrawRule = new RandomDrawRule();

        if (direction.equals(Direction.RIGHT)) {
            return Direction.LEFT;
        }

        if (direction.equals(Direction.LEFT)) {
            return Direction.NONE;
        }

        return randomDrawRule.isDrawable();
    }
}
