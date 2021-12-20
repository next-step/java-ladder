package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final String EXCEPTION_MESSAGE_POSITION = "위치가 정확하지 않습니다.";
    private static final long MIN_DISTINCT_POINT_COUNT = 1L;
    private static final int MIN_POSITION = 0;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateLadder(lines);
        this.lines = lines;
    }

    private void validateLadder(List<Line> lines) {
        long distinctPointCount = lines.stream()
                                            .map(line -> line.getPoints().size())
                                            .distinct()
                                            .count();
        if (distinctPointCount != MIN_DISTINCT_POINT_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public int getPosition(int position) {
        validatePosition(position);
        for (Line line : lines) {
            Direction direction = Direction.valueOf(line.isLine(position), line.isNextLine(position));
            position += direction.getMovePosition();
        }
        return position;
    }

    private void validatePosition(int position) {
        if (lines.size() < position || MIN_POSITION > position) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_POSITION);
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
