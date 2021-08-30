package nextstep.ladder.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPlayers) {
        this.points = Collections.unmodifiableList(createPoints(countOfPlayers));
    }

    public Line(final List<Boolean> points) {
        validatePoints(points);
        this.points = Collections.unmodifiableList(points);
    }

    private List<Boolean> createPoints(int countOfPlayers) {
        List<Boolean> points = new LinkedList<>();
        points.add(false);
        boolean previousPoint = false;
        for (int i = 1; i < countOfPlayers; i++) {
            boolean point = false;
            if (!previousPoint) {
                point = RandomPointCreator.createPoint();
            }
            previousPoint = point;
            points.add(point);
        }
        return points;
    }

    private void validatePoints(List<Boolean> points) {
        boolean previousPoint = false;
        for (boolean point : points) {
            isCreatePoint(previousPoint, point);
            previousPoint = point;
        }
    }

    private void isCreatePoint(boolean previousPoint, boolean nowPoint) {
        if (previousPoint && nowPoint) {
            throw new IllegalArgumentException("가로 라인이 겹치므로 라인을 생성할 수 없습니다.");
        }
    }

    public List<Boolean> valueOfPoints() {
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
}
