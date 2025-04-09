package nextstep.domain.line;

import nextstep.generator.LineGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(List<Boolean> points) {
        this.points = points.stream()
                .map(Point::new)
                .collect(Collectors.toList());
        checkValidPoints();
    }

    public Line(int playerCounts, LineGenerator lineGenerator) {
        points = new ArrayList<>();
        for (int index = 0; index < playerCounts -1 ; index++) {
            points.add(createLine(index, lineGenerator));
        }
        checkValidPoints();
    }

    private void checkValidPoints() {
        IntStream.range(0, this.points.size() - 1)
                .filter(index -> this.points.get(index).isConnected() && this.points.get(index + 1).isConnected())
                .findFirst()
                .ifPresent(index -> {
                    throw new RuntimeException("연속으로 선이 이어지만 안됩니다.");
                });
    }

    private Point createLine(int index, LineGenerator lineGenerator) {
        if (index == 0) {
            return new Point(lineGenerator);
        }
        if (points.get(index - 1).isConnected()) {
            return new Point(false);
        }
        return new Point(lineGenerator);
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Line line = (Line) object;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}
