package ladder.domain;

import ladder.constant.Direction;
import ladder.constant.Point;
import ladder.exception.ContinuousConnectionException;
import ladder.strategy.GenerationStrategy;

import java.util.List;
import java.util.Objects;

public class Line {

    private static final int PREVIOUS_VALUE = 1;

    private final List<Point> points;

    public Line(People people, GenerationStrategy strategy) {
        this(strategy.generatePoints(people.pointCount()));
    }

    public Line(Point... points) {
        this(List.of(points));
    }

    public Line(List<Point> points) {
        validatePoints(points);
        this.points = points;
    }

    private void validatePoints(List<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            validateContinuousConnect(points, i);
        }
    }

    private void validateContinuousConnect(List<Point> points, int currentIndex) {
        if (!continuousConnected(points, currentIndex)) {
            return;
        }
        throw new ContinuousConnectionException();
    }

    private boolean continuousConnected(List<Point> points, int currentIndex) {
        if (currentIndex == Position.MIN_VALUE) {
            return false;
        }
        return points.get(currentIndex).isConnect()
                && points.get(currentIndex - PREVIOUS_VALUE).isConnect();
    }

    public Direction direction(Position position) {
        if(connectedLeftLine(position)) {
            return Direction.LEFT;
        }
        if (connectedRightLine(position)) {
            return Direction.RIGHT;
        }
        return Direction.STAY;
    }

    private boolean connectedLeftLine(Position position) {
        return !position.minimum() && points.get(position.leftValue()).isConnect();
    }
    private boolean connectedRightLine(Position position) {
        return !position.maximum() && points.get(position.value()).isConnect();
    }

    public List<Point> points() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return this.points.toString();
    }
}

