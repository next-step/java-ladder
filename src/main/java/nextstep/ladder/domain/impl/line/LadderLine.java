package nextstep.ladder.domain.impl.line;

import nextstep.ladder.domain.engine.Line;
import nextstep.ladder.exception.ContinousLinePointException;
import nextstep.ladder.exception.OutOfRangeException;
import nextstep.ladder.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderLine implements Line {

    private static final int MIN_POINT_COUNT = 2;

    private List<Boolean> points = new ArrayList<>();

    private LadderLine() {

    }

    private LadderLine(List<Boolean> points) {
        validPointsCount(points);
        validContinuous(points);

        this.points = points;
    }

    public static LadderLine from(Boolean... existPoints) {
        return new LadderLine(
                Arrays.stream(existPoints)
                        .collect(Collectors.toList()));
    }

    public static LadderLine from(List<Boolean> existPoints) {
        return new LadderLine(existPoints);
    }

    private void validContinuous(List<Boolean> points) {
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i) && points.get(i + 1)) {
                throw new ContinousLinePointException();
            }
        }
    }

    private void validPointsCount(List<Boolean> points) {
        if (points.size() < MIN_POINT_COUNT) {
            throw OutOfRangeException.shouldGreaterOrEqualThan(MIN_POINT_COUNT, points.size());
        }
    }

    public int getSize() {
        return points.size();
    }

    @Override
    public int move(int startPosition) {
        validStartPosition(startPosition);

        if (isExistPoint(startPosition)) {
            return startPosition - 1;
        }
        if (isExistPoint(startPosition + 1)) {
            return startPosition + 1;
        }
        return startPosition;
    }

    private void validStartPosition(int startPosition) {
        if (points.size() <= startPosition) {
            throw OutOfRangeException.shouldLessThan(startPosition, points.size());
        }
    }

    private boolean isExistPoint(int index) {
        if (points.size() <= index) {
            return false;
        }
        return points.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderLine)) return false;
        LadderLine ladderLine = (LadderLine) o;
        return Objects.equals(points, ladderLine.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return points.stream()
                .map(ResultView::parseBooleanToDot)
                .collect(Collectors.joining());
    }

}
