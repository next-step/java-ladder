package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int INDEX_SIZE = 1;
    private static final String EMPTY_FIRST = "    ";
    private static final char SPOT = '|';

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
        return Collections.unmodifiableList(this.points);
    }

    public void print() {
        System.out.print(EMPTY_FIRST);
        points.forEach(point -> {
            System.out.print(SPOT);
            point.print();
        });
        System.out.println();
    }
}
