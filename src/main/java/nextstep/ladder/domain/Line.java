package nextstep.ladder.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private static final int RANDOM_START_INDEX = 1;
    private final List<Boolean> points;

    public Line(int countOfPlayers, PointCreator pointCreator) {
        this.points = Collections.unmodifiableList(createPoints(countOfPlayers, pointCreator));
    }

    public Line(final List<Boolean> points) {
        validatePoints(points);
        this.points = Collections.unmodifiableList(points);
    }

    private List<Boolean> createPoints(final int countOfPlayers, final PointCreator pointCreator) {
        List<Boolean> points = new LinkedList<>();
        points.add(false);
        IntStream.range(RANDOM_START_INDEX, countOfPlayers)
                .forEach(index -> addPoint(points, pointCreator));
        return points;
    }

    private void addPoint(List<Boolean> points, PointCreator pointCreator) {
        if (!points.get(points.size() - 1)) {
            points.add(pointCreator.createPoint());
            return;
        }
        points.add(false);
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
