package rick.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import rick.strategy.PointCreationStrategy;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, PointCreationStrategy pointsGenerationStrategy) {
        final int pointCount = countOfPerson - 1;
        boolean previousPointValue = false;

        for (int i = 0; i < pointCount; i++) {
            final boolean point = createPointValue(previousPointValue, pointsGenerationStrategy);
            points.add(point);
            previousPointValue = point;
        }
    }

    public Line(List<Boolean> points) {
        this.points.addAll(points);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private Boolean createPointValue(boolean previousPointValue, PointCreationStrategy pointsGenerationStrategy) {
        if (previousPointValue) {
            return false;
        }

        return pointsGenerationStrategy.create();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
