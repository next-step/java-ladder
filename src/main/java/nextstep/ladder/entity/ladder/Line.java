package nextstep.ladder.entity.ladder;

import nextstep.ladder.entity.draw.DrawRule;

public class Line {
    private final Direction lineDirection;

    public Line(Direction direction, DrawRule drawRule) {
        this.lineDirection = nextDirection(direction, drawRule);
    }

    public Direction lineDirection() {
        return lineDirection;
    }

    public Direction nextDirection(Direction direction, DrawRule drawRule) {
        return direction.equals(Direction.RIGHT) ? Direction.LEFT : Direction.direction(drawRule.drawRule());
    }
}
