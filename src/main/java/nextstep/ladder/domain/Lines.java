package nextstep.ladder.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nextstep.ladder.generator.NonConsecutiveFlagGenerator;

public class Lines {

    private final List<Point> points;

    public Lines(NonConsecutiveFlagGenerator nonConsecutiveFlagGenerator) {
        this.points = PointConverter.convert(nonConsecutiveFlagGenerator.create());
    }

    public List<Boolean> getPoint() {
        return points.stream().map(Point::canMove).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lines lines1 = (Lines) o;
        return Objects.equals(points, lines1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    private static class PointConverter {
        private static List<Point> convert(List<Boolean> points) {
            return toPoints(points);
        }

        private static List<Point> toPoints(List<Boolean> lines) {
            ArrayList<Point> result = new ArrayList<>();
            for (int i = 0; i < lines.size(); i++) {
                result.add(new Point(lines.get(i), i));
            }
            return result;
        }
    }
}
