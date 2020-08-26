package ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class Line {
    private List<Points> points;

    public Line(List<Points> points) {
        this.points = points;
    }

    public static Line create(List<Points> points) {
        return new Line(points);
    }

    public int getSize() {
        return 0;
    }

    public static List<Boolean> getConnection(Line line) {
        return null;
    }

    public Stream<Points> stream() {
        return null;
    }
}
