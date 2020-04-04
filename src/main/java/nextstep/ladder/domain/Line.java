package nextstep.ladder.domain;

import nextstep.ladder.RandomBooleanProvider;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public static final String POINT_COUNT_ERROR = "참여자는 2명 이상이어야 합니다.";
    private final List<Point> points;

    public Line(List<Point> points) {
        assertPointCount(points);
        assertPointHasLine(points);
        this.points = points;
    }

    public Line(int personCount) {
        this(createLine(personCount));
    }

    private static List<Point> createLine(int personCount) {
        List<Point> points = new ArrayList<>();

        for(int i = 0; i < personCount - 1; i++) {
            points.add(new Point(i, judgeHasLine(getPreviousPoint(points, i))));
        }

        return points;
    }

    private static boolean judgeHasLine(Point previousPoint) {
        if(previousPoint != null && previousPoint.isHasLine()) {
            return false;
        }

        return RandomBooleanProvider.getInstance().getRandomBoolean();
    }

    private static Point getPreviousPoint(List<Point> points, int currentIndex) {
        if(currentIndex > 0) {
            return points.get(currentIndex - 1);
        }
        return null;
    }

    private void assertPointHasLine(List<Point> points) {
        points.forEach(point -> {
            int currentIndex = points.indexOf(point);

            if(currentIndex > 0) {
                point.compareWithPreviousPoint(point, getPreviousPoint(currentIndex, points));
            }
        });
    }

    private Point getPreviousPoint(int currentIndex, List<Point> points) {
        if(currentIndex == 0) {
            return null;
        }
        return points.get(currentIndex - 1);
    }

    private void assertPointCount(List<Point> points) {
        if(points.size() < 2) {
            throw new IllegalArgumentException(POINT_COUNT_ERROR);
        }
    }

    public List<Point> getValue() {
        return this.points;
    }
}
