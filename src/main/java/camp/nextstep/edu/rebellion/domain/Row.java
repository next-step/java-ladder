package camp.nextstep.edu.rebellion.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Row {
    private final int INIT_INDEX = 0;
    private final List<Point> points;

    public Row (int sizeOfPoints) {
        this.points = generateCols(sizeOfPoints);
    }

    public void mark(int ordinal) {
        Point cur = getCurrent(ordinal);
        Point next = getNext(ordinal);

        if (!isAlreadyExistsHorizonLine(cur, next)) {
            return;
        }

        makeHorizonLine(cur, next);
    }

    public boolean hasHorizonLine(int ordinal) {
        Point cur = getCurrent(ordinal);
        Point next = getNext(ordinal);
        return cur.hasNext() && next.hasPrev();
    }

    private Point getCurrent(int ordinal) {
        return points.get(ordinal);
    }

    private Point getNext(int ordinal) {
        return points.get(ordinal + 1);
    }

    private boolean isAlreadyExistsHorizonLine(Point cur, Point next) {
        return cur.canMark() && !next.hasPrev();
    }

    private void makeHorizonLine(Point cur, Point next) {
        cur.markOnNext();
        next.markOnPrev();
    }

    private List<Point> generateCols(int sizeOfPoints) {
        List<Point> points = new ArrayList<>();
        IntStream
                .range(INIT_INDEX, sizeOfPoints)
                .forEach(i -> points.add(new Point()));
        return points;
    }
}
