package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

public class Line {
    private final List<Boolean> points;

    public Line(final int width, final IntFunction<Boolean> lineBuilderStrategy) {
        this.points = new ArrayList<>(width);

        for (int idx = 0; idx < width; idx++) {
            addPoint(lineBuilderStrategy.apply(idx));
        }
    }

    private void addPoint(boolean curPoint) {
        this.points.add(curPoint);
    }
}
