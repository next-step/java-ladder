package ladder.domain;

import ladder.domain.generator.PointGenerator;

import java.util.Objects;

public class Line {

    private Points points;

    public Line(Points points) {

        this.points = points;
    }

    public static Line of(int width, PointGenerator pointGenerator) {

        return new Line(Points.draw(width, pointGenerator));
    }

    public int move(int position) {

        return points.getPoint(position).move();
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