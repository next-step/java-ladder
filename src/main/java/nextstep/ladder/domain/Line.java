package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.LineDirection.LEFT;
import static nextstep.ladder.domain.LineDirection.RIGHT;
import static nextstep.ladder.domain.LineDirection.validateSequentialDirection;

public class Line {
    private final List<LineDirection> lineDirections;

    public Line(List<LineDirection> lineDirections) {
        validateExistSequentialLine(lineDirections);
        this.lineDirections = lineDirections;
    }

    private void validateExistSequentialLine(List<LineDirection> lineDirections) {
        IntStream.range(1, lineDirections.size())
                .forEach((i) -> validateSequentialDirection(lineDirections.get(i - 1), lineDirections.get(i)));
    }

    public List<LineDirection> getLineDirections() {
        return lineDirections;
    }

    public int move(int idx) {
        LineDirection lineDirection = lineDirections.get(idx);
        if (lineDirection.equals(LEFT)) {
            return idx - 1;
        }
        if (lineDirection.equals(RIGHT)) {
            return idx + 1;
        }
        return idx;
    }
}
