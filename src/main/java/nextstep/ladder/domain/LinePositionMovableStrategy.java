package nextstep.ladder.domain;

import java.util.List;

public class LinePositionMovableStrategy implements PositionMovableStrategy {

    private Position position;
    private List<Boolean> points;

    public LinePositionMovableStrategy(Position position, List<Boolean> points) {
        this.position = position;
        this.points = points;
    }

    @Override
    public boolean isLeftMovements() {
        return position.isNotFirstPosition() && points.get(position.leftPosition());
    }

    @Override
    public boolean isRightMovements() {
        return position.isNotLastPosition() && points.get(position.currentPosition());
    }

    @Override
    public int move() {
        if (isRightMovements()) {
            return position.rightPosition();
        }
        if (isLeftMovements()) {
            return position.leftPosition();
        }
        return position.currentPosition();
    }
}
