package nextstep.ladder.domain.ladder;

import java.util.List;

public class Line {

    private final List<Position> positions;

    public Line(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return positions;
    }
}
