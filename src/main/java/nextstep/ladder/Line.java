package nextstep.ladder;

import nextstep.ladder.strategy.LadderStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int START_INDEX = 0;

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson, LadderStrategy strategy) {
        List<Boolean> pointList = new ArrayList<>();
        IntStream.range(START_INDEX, countOfPerson)
                .forEach(index -> addPoint(pointList, strategy));
        return new Line(pointList);
    }

    private static void addPoint(List<Boolean> pointList, LadderStrategy strategy) {
        boolean previousPoint = false;
        if (!pointList.isEmpty()) {
            previousPoint = pointList.get(pointList.size() - 1);
        }
        if (previousPoint) {
            pointList.add(false);
            return;
        }

        pointList.add(strategy.creatable());
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
