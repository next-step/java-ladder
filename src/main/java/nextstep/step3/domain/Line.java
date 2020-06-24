package nextstep.step3.domain;

import nextstep.step3.domain.strategy.DrawLineStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int userCount, DrawLineStrategy drawLineStrategy) {
        IntStream.range(0, userCount - 1)
                .mapToObj(index -> points.add(drawLineStrategy.isDrawLine(points, index)))
                .collect(Collectors.toList());
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
