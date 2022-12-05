package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderFactory {
    private final Names names;
    private final Height height;

    public static Ladder from(Names names, Height height, DirectionStrategy strategy) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height.height(); i++) {
            lines.add(makeLine(names.size(), strategy));
        }

        return new Ladder(lines);
    }

    private static Line makeLine(int countOfPoint, DirectionStrategy strategy) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(strategy);
        points.add(point);

        for (int i = 1; i < countOfPoint - 1; i++) {
            point = Point.next(point, strategy);
            points.add(point);
        }

        Point last = Point.last(point);
        points.add(last);

        return new Line(points);
    }

    public LadderFactory(Names names, Height height) {
        this.names = names;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderFactory that = (LadderFactory) o;
        return Objects.equals(names, that.names) && Objects.equals(height, that.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names, height);
    }
}
