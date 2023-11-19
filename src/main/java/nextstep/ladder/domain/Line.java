package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class Line {
    private final List<Boolean> points;

    public Line(final int width, final IntFunction<Boolean> lineBuilderStrategy) {
        this.points = new ArrayList<>(width);

        for (int idx = 0; idx < width; idx++) {
            addPoint(idx, lineBuilderStrategy.apply(idx));
        }
    }

    List<Boolean> getPoints() {
        return points;
    }

    private void addPoint(final int idx, boolean curPoint) {
        if (idx > 0) {
            boolean prePoint = this.points.get(idx - 1);

            curPoint = adjustContinuousTrue(prePoint, curPoint);
        }

        this.points.add(curPoint);
    }

    private boolean adjustContinuousTrue(final boolean prePoint, boolean curPoint) {
        if (prePoint && curPoint) {
            return false;
        }

        return curPoint;
    }

    @Override
    public String toString() {
        final String delimiter = "|";

        return points.stream()
                .map(this::generateLadderPointString)
                .collect(Collectors.joining(delimiter, delimiter, delimiter));
    }

    private String generateLadderPointString(final Boolean bool) {
        if (bool) {
            return "-".repeat(5);
        }

        return " ".repeat(5);
    }
}
