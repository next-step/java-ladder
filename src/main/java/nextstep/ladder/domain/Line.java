package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line {

    private static final String NOT_FOUND_NEXT_POSITION = "이동할 포지션을 찾을 수 없습니다.";

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

    public Position move(final Position position) {
        return this.positions
                .stream()
                .filter(linePosition -> !linePosition.equals(position))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(NOT_FOUND_NEXT_POSITION));
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
