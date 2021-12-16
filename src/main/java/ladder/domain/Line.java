package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int INDEX_SIZE = 1;
    private final List<Point> line;

    public Line(int size) {
        line = new ArrayList<>();
        init(size);
    }

    private void init(int playerSize) {
        this.line.add(new Point());
        IntStream.range(INDEX_SIZE, playerSize - INDEX_SIZE)
                .forEach(x -> this.line.add(new Point(getLastPoint(), true)));
        this.line.add(new Point(getLastPoint(), false));
    }

    private Point getLastPoint() {
        int index = this.line.size() - 1;
        return this.line.get(index);
    }

    public List<Point> getLine() {
        return this.line;
    }
}
