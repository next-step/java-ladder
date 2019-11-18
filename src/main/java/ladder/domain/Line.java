package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int FIRST_POINT_INDEX = 0;

    private List<Point> points;

    public Line(int countOfParticipants) {
        this.points = generateRandomPoints(countOfParticipants);
    }

    private List<Point> generateRandomPoints(int countOfParticipants) {
        List<Point> randomPoints = new ArrayList<>();

        int pointSize = countOfParticipants - 1;

        for (int pointIndex = 0; pointIndex < pointSize; pointIndex++) {
            randomPoints.add(generateRandomPoint(randomPoints, pointIndex));
        }

        return randomPoints;
    }

    private Point generateRandomPoint(List<Point> randomPoint, int pointIndex) {
        if (pointIndex == FIRST_POINT_INDEX) {
            return randomPoint();
        }

        if (randomPoint.get(pointIndex - 1).checkTrue()) {
            return new Point(Boolean.FALSE);
        }

        return randomPoint();
    }

    private Point randomPoint() {
        return Point.ofRandom();
    }

    public int getPointsLength() {
        return points.size();
    }

    public List<Point> getPoints() {
        return this.points;
    }
}
