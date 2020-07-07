package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Point> points;

    public LadderLine (int numberOfGameAttendees, HorizontalLineStrategy strategy) {
        this.points = createPointsBy(numberOfGameAttendees, strategy);
    }

    private List<Point> createPointsBy(final int numberOfGameAttendees, final HorizontalLineStrategy strategy) {
        final List<Point> newPoints = initPoints(numberOfGameAttendees);
        setHorizontalLines(newPoints, strategy);
        return newPoints;
    }

    private List<Point> initPoints(final int numberOfGameAttendees) {
        final List<Point> points = new ArrayList<>();
        for (int i = 0; i <numberOfGameAttendees; i++) {
            Point point = new Point(i);
            points.add(point);
        }
        return points;
    }

    private void setHorizontalLines(final List<Point> newPoints, final HorizontalLineStrategy strategy) {
        for (Point point : newPoints) {
            if (!isMovablePointExist(point) && isMovableIndex(point, newPoints) && strategy.isDrawLine()) {
                final Point nextPoint = getNextPoint(point, newPoints);
                point.setNextMovePoint(nextPoint);
                nextPoint.setNextMovePoint(point);
            }
        }
    }

    private boolean isMovablePointExist(final Point point) {
        return point.getNextMovePoint() != null;
    }

    private boolean isMovableIndex(final Point point, final List<Point> newPoints) {
        final int endIndexSizeShouldExclude = 1;
        final int maximumMovableIndex = newPoints.size() - endIndexSizeShouldExclude;
        return point.getPointIndex() < maximumMovableIndex;
    }

    private Point getNextPoint(final Point point, final List<Point> newPoints) {
        return newPoints.get(point.getPointIndex() + 1);
    }

    public int moveLine(final int attendeesPosition) {
        final Point attendeesPositionPoint = points.get(attendeesPosition);
        return (attendeesPositionPoint.getNextMovePoint() != null)
                ? attendeesPositionPoint.getNextMovePointIndex()
                : attendeesPosition;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (Point point : points) {
            stringBuilder.append(LadderCharacter.VERTICAL_LINE);
            stringBuilder.append(getPrintType(point));
        }
        stringBuilder.append("\t");
        return stringBuilder.toString();
    }

    private String getPrintType(final Point point) {
        return isLineLinked(point) ? LadderCharacter.HORIZONTAL_LINE : LadderCharacter.EMPTY_LINE;
    }

    private boolean isLineLinked(final Point point) {
        final Point nextMovePoint = point.getNextMovePoint();
        return nextMovePoint != null && nextMovePoint.isBiggerIndexThan(point);
    }

}
