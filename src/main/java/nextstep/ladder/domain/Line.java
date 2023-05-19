package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> points;
    private final Connector connector;
    public Line(int countOfPerson, Connector connector) {
        this.points = new ArrayList<>();
        this.connector = connector;
        for (int i = 1; i < countOfPerson; i++) {
            points.add(connect());
        }
    }

    public Line(List<Boolean> points, Connector connector) {
        this.points = new ArrayList<>(points);
        this.connector = connector;
    }

    private boolean connect() {
        if (canConnectPoints()) {
            return connector.connect();
        }
        return false;
    }

    private boolean canConnectPoints() {
        if (points.isEmpty()) {
            return true;
        }
        return !points.get(points.size() - 1);
    }

    public static Line of(int countOfPerson, Connector connector) {
        return new Line(countOfPerson, connector);
    }

    public boolean canMoveOnRight(int index) {
        return canMove(index);
    }

    public boolean canMoveOnLeft(int index) {
        return canMove(index - 1);
    }

    private boolean canMove(int index) {
        try {
            return points.get(index);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(points);
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
}
