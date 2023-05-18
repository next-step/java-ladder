package ladder.domain;

import ladder.strategy.LineCreateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;

    public Line(int countOfPerson, LineCreateStrategy lineCreateStrategy) {

        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, countOfPerson - 1)
                .forEach(index -> addPoint(points, index, lineCreateStrategy));
        this.points = points;
    }

    private void addPoint(List<Boolean> points, int index, LineCreateStrategy lineCreateStrategy) {
        if (index == 0 || !points.get(index - 1)) {
            points.add(lineCreateStrategy.createLine());
            return;
        }
        points.add(false);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
