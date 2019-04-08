package ladder.domain.ladder;

import ladder.vo.Length;
import ladder.vo.coordinate.Coordinate;
import ladder.vo.coordinate.CoordinateValue;

public class Ladder {
    private static final int LADDER_BOTTOM = 0;

    private Lines lines;

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public Length getWidth() {
        return this.lines.getWidth();
    }

    public Length getHeight() {
        return this.lines.getHeight();
    }

    public CoordinateValue getStartYCoordinate() {
        int y = getHeight().getValue();
        return new CoordinateValue(y);
    }

    public Coordinate getLadderResultCoordinate(Coordinate coordinate) {
        while (LADDER_BOTTOM < coordinate.getYValue()) {
            coordinate = this.lines.cross(coordinate);
        }

        return coordinate;
    }
}
