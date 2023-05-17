package ladder.domain;

import ladder.strategy.AddLineStrategy;
import ladder.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;
    private final LineStrategy lineStrategy;

    public Line(int countOfPerson, LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;

        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, countOfPerson - 1)
                .forEach(index -> addPoint(points, index));
        this.points = points;
    }

    private void addPoint(List<Boolean> points, int index) {
        if (index == 0 || !points.get(index - 1)) {
            points.add(this.lineStrategy.generate());
            return;
        }
        points.add(false);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
