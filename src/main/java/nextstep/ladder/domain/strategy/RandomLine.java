package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLine implements LineStrategy {
    private static final int FIRST_LINE_INDEX = 0;

    @Override
    public Line createLine(int personCount) {
        int lineCount = personCount - 1;
        int lastIndex = lineCount - 1;
        List<Point> points = new ArrayList<>();
        for (int index = 0; index < lineCount; index++) {
            Point point = createPoint(index, points, lastIndex);
            points.add(point);
        }

        return new Line(points);
    }

    private Point createPoint(int index, List<Point> points, int lastIndex) {
        if (index == FIRST_LINE_INDEX) {
            return new Point(randomPoint());
        }

        if (index == lastIndex) {
            return new Point(linedPoint());
        }

        boolean leftPointHasLine = pointHasLine(points, index - 1);
        if (leftPointHasLine) {
            return new Point(emptyPoint());
        }

        return new Point(randomPoint());
    }

    private boolean linedPoint() {
        return true;
    }

    private boolean emptyPoint() {
        return false;
    }

    private boolean randomPoint() {
        return new Random().nextBoolean();
    }

    private boolean pointHasLine(List<Point> list, int leftIndex) {
        return list.get(leftIndex).isPoint();
    }
}
