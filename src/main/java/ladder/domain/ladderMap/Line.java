package ladder.domain.ladderMap;

import ladder.domain.ParticipantList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final int RANDOM_BOUND = 2;
    private static final int ACTIVATING_NUMBER = 1;
    private static Random random = new Random();

    private List<Point> points;

    public Line(ParticipantList participantList) {
        List<Point> pointList = initLines(participantList);
        this.points = linkLines(pointList);
    }

    private List<Point> linkLines(List<Point> pointList) {
        List<Point> updatedPointList = new ArrayList<>();
        updatedPointList.add(pointList.get(0));
        updatedPointList.add(pointList.get(1));
        for (int idx = 1; idx < pointList.size() - 1; idx++) {
            updatedPointList.add(mightHaveHorizontalLine(pointList, idx));
        }
        return updatedPointList;
    }

    private Point mightHaveHorizontalLine(List<Point> pointList, int idx) {
        Point currentPoint = pointList.get(idx);
        Point prePoint = pointList.get(idx - 1);
        Point nextPoint = pointList.get(idx + 1);

        if (mustPaint(currentPoint, nextPoint)) {
            return nextPoint.nowHorizontal();
        }
        if (cannotPaint(prePoint, currentPoint, nextPoint)) {
            return nextPoint;
        }
        return horizontalOrEmptyPoint(nextPoint);
    }

    private Point horizontalOrEmptyPoint(Point point) {
        if (random.nextInt(RANDOM_BOUND) == ACTIVATING_NUMBER) {
            return point.nowHorizontal();
        }
        return point;
    }

    private boolean mustPaint(Point currentPoint, Point nextPoint) {
        if (nextPoint.vertical()) {
            return false;
        }
        return currentPoint.horizontal();
    }

    private boolean cannotPaint(Point prePoint, Point currentPoint, Point nextPoint) {
        if (nextPoint.vertical() || currentPoint.empty()) {
            return true;
        }
        return prePoint.horizontal() && currentPoint.vertical();
    }

    private List<Point> initLines(ParticipantList participantList) {
        return IntStream.range(0, width(participantList))
                .mapToObj(Point::new)
                .collect(Collectors.toList());
    }

    private int width(ParticipantList participantList) {
        return 5 * participantList.size();
    }

    @Override
    public String toString() {
        return points.stream()
                .map(Point::value)
                .collect(Collectors.joining());
    }
}
