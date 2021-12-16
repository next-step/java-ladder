package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int INDEX_SIZE = 1;
    private final List<Point> points;

    public Line(int size) {
        points = new ArrayList<>();
        init(size);
    }

    private void init(int playerSize) {
        this.points.add(new Point());
        IntStream.range(INDEX_SIZE, playerSize - INDEX_SIZE)
                .forEach(x -> this.points.add(new Point(getLastPoint(), true)));
        this.points.add(new Point(getLastPoint(), false));
    }

    private Point getLastPoint() {
        int index = this.points.size() - 1;
        return this.points.get(index);
    }

    public List<Point> getPoints() {
        return this.points;
    }
}
