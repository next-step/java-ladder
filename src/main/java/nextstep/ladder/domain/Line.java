package nextstep.ladder.domain;

import nextstep.ladder.RandomBooleanProvider;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public static final String POINT_COUNT_ERROR = "참여자는 2명 이상이어야 합니다.";
    public static final int MIN_PARTICIPANT_COUNT = 2;
    private final List<Point> points;

    public Line(List<Point> points) {
        assertParticipantCount(points);
        assertPointHasLine(points);
        this.points = points;
    }

    public Line(int participantCount) {
        this(createLine(participantCount));
    }

    private static List<Point> createLine(int participantCount) {
        List<Point> points = new ArrayList<>();

        for(int i = 0; i < participantCount - 1; i++) {
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
            comparePoints(points, point);
        });
    }

    private void comparePoints(List<Point> points, Point currentPoint) {
        int currentIndex = points.indexOf(currentPoint);

        if(currentIndex > 0) {
            currentPoint.compareWithPreviousPoint(currentPoint, getPreviousPoint(points, currentIndex));
        }
    }

    private void assertParticipantCount(List<Point> points) {
        if(points.size() < MIN_PARTICIPANT_COUNT - 1) {
            throw new IllegalArgumentException(POINT_COUNT_ERROR);
        }
    }

    public List<Point> getValue() {
        return this.points;
    }
}
