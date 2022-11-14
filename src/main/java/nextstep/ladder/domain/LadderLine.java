package nextstep.ladder.domain;

import java.util.List;

public final class LadderLine {
    public static final int MIN_POINTS_SIZE = 2;

    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    private final List<Point> points;

    public LadderLine(final List<Point> points) {
        validatePoints(points);
        this.points = points;
    }

    private static void validatePoints(final List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("Points can not be null");
        }
        if (points.size() < MIN_POINTS_SIZE) {
            throw new IllegalArgumentException(
                String.format("Points size should be greater than %s", MIN_POINTS_SIZE));
        }
        validateConnectedPoints(points);
    }

    private static void validateConnectedPoints(final List<Point> points) {
        Point prevPoint = points.get(FIRST_INDEX);
        for (int i = SECOND_INDEX; i < points.size(); i++) {
            final Point currPoint = points.get(i);
            if (prevPoint.isNode() && currPoint.isNode())  {
                throw new IllegalArgumentException("Points can not be connected in a row");
            }
            prevPoint = currPoint;
        }
    }

    public int size() {
        return points.size();
    }

    public boolean isNode(final int index) {
        validateRange(index);
        return points.get(index).isNode();
    }

    private void validateRange(final int index) {
        if (!isInRange(index)) {
            throw new IllegalArgumentException("can not create point of out of index");
        }
    }

    private boolean isInRange(final int index) {
        return FIRST_INDEX <= index && index < points.size();
    }

    @Override
    public String toString() {
        return "LadderLine [" +
            "points=" + points +
            ']';
    }

}
