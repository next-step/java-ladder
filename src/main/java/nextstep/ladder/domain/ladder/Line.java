package nextstep.ladder.domain.ladder;

import java.util.List;

public class Line {

    private final Positions positions;

    private Line(Positions positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return positions.getPositions();
    }

    public static Line newInstance(int maxPosition, DirectionPredicate predicate) {
        return new Line(Positions.newInstance(maxPosition, predicate));
    }
}
