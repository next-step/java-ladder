package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Position> positions;

    public Line(final Position left, final Position right) {
        this.positions = Arrays.asList(left, right);
    }

    public boolean isConflict(final Line line) {
        return this.positions
                .stream()
                .anyMatch(linePosition -> line.hasPosition(linePosition));
    }

    public boolean hasPosition(final Position position) {
        return this.positions.contains(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(positions, line.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }
}
