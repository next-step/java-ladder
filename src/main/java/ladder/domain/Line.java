package ladder.domain;

import ladder.strategy.LineCreateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;

    public Line(int countOfPerson, LineCreateStrategy lineCreateStrategy) {
        this.points = createPoints(countOfPerson, lineCreateStrategy);
    }

    private List<Boolean> createPoints(int countOfPerson, LineCreateStrategy lineCreateStrategy) {

        List<Boolean> points = new ArrayList<>();

        IntStream.range(0, countOfPerson - 1)
                .forEach(index -> addPoint(points, index, lineCreateStrategy));

        return points;
    }

    private void addPoint(List<Boolean> points, int index, LineCreateStrategy lineCreateStrategy) {
        if (index == 0 || !points.get(index - 1)) {
            points.add(lineCreateStrategy.canCreateLine());
            return;
        }
        points.add(false);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public boolean hasLeftPoint(int currentPlayerPoint) {
        if (currentPlayerPoint == 0) {
            return false;
        }
        return points.get(currentPlayerPoint - 1);
    }

    public boolean hasRightPoint(int currentPlayerPoint) {
        if (points.size() == currentPlayerPoint || points.size() < currentPlayerPoint) {
            return false;
        }
        return points.get(currentPlayerPoint);
    }
}
