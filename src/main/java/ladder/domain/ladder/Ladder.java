package ladder.domain.ladder;

import ladder.vo.Length;
import ladder.vo.coordinate.Coordinate;
import ladder.vo.coordinate.CoordinateValue;

public class Ladder {
    private final Lines lines;

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
        while (coordinate.canGoDown()) {
            coordinate = this.lines.cross(coordinate);
        }

        return coordinate;
    }

    @Override
    public String toString() {
        return this.lines.toString();
    }
}
