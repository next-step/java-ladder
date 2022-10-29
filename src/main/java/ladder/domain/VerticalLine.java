package ladder.domain;

import java.util.List;

public class VerticalLine {

    private final List<Direction> directions;

    private final Position position;

    public VerticalLine(List<Direction> directions, Position position) {
        this.directions = directions;
        this.position = position;
    }


    public void move(LadderPosition ladderPosition) {
        if (isArrived(ladderPosition)) {
            return;
        }
        Direction unit = this.directions.get(ladderPosition.length());
        ladderPosition.down();
        if (unit.hasPrevious()) {
            ladderPosition.previous();
            return;
        }
        if (unit.hasNext()) {
            ladderPosition.next();
            return;
        }
        move(ladderPosition);
    }

    private boolean isArrived(LadderPosition ladderPosition) {
        return directions.size() <= ladderPosition.length();
    }


    public List<Direction> getLineUnits() {
        return directions;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }
}
