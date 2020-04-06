package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public static final String POINT_COUNT_ERROR = "참여자는 2명 이상이어야 합니다.";
    public static final String POINT_INDEX_ERROR = "해당 인덱스의 Point를 가져올 수 없습니다.";
    public static final int MIN_PARTICIPANT_COUNT = 2;
    private final List<Point> points;

    public Line(List<Point> points) {
        assertParticipantCount(points);
        assertPointHasLine(points);

        this.points = points;
    }

    /**
     * 5명의 사용자를 연결할 수 있는 4개의 Point를 생성한다.
     * Line은 사다리 높이만큼 생성되는 하나의 행으로써의 역할을 가진다.
     */
    public Line(int participantCount) {
        List<Point> points = new ArrayList<>();

        for(int i = 0; i < participantCount - 1; i++) {
            points.add(new Point(i, getPreviousPoint(points, i)));
        }
        assertParticipantCount(points);
        assertPointHasLine(points);

        this.points = points;
    }

    private static Point getPreviousPoint(List<Point> points, int currentIndex) {
        if(currentIndex > 0) {
            return points.get(currentIndex - 1);
        }

        return null;
    }

    public int move(int startPosition) {
        int nextPosition = startPosition;

        boolean isMoveLeft = isMove(nextPosition, (position) -> {
            if(position <= 0) {
                return false;
            }

            Point leftPoint = getPointByIndex(position - 1);
            return leftPoint.hasLine();
        });

        if(isMoveLeft) {
            return nextPosition - 1;
        }

        boolean isMoveRight = isMove(nextPosition, (position) -> {
            if(position == points.size()) {
                return false;
            }

           Point rightPoint = getPointByIndex(position);
           return rightPoint.hasLine();
        });

        if(isMoveRight) {
            return nextPosition + 1;
        }

        return nextPosition;
    }

    private boolean isMove(int position, MoveCondition moveCondition) {
        return moveCondition.isMove(position);
    }

    private Point getPointByIndex(int index) {
        return points.stream()
                .filter(point -> point.isSameIndex(index))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(POINT_INDEX_ERROR));
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
