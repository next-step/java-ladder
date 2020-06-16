package camp.nextstep.edu.nextstep8.ladder.entity;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private static final Point EMPTY_POINT = new Point(-1, -1);

    private final List<Point> points;
    private final int rowNumber;
    private final int columnSize;

    public Row(int rowNumber, int cols) {
        this.points = generateRow(rowNumber, cols);
        this.rowNumber = rowNumber;
        this.columnSize = cols;
    }

    public void draw(int x, int y) {
        Point cur = pick(x, y);
        Point next = pick(x, y + 1);

        if(meetLast(cur)) {
            return;
        }

        if(isAlreadyDraw(cur, next)) {
            return;
        }
        cur.markStart();
        next.markEnd();
    }

    public Point pick(int x, int y) {
        return points.stream()
                .filter(p -> p.match(x, y) == true)
                .findFirst()
                .orElse(EMPTY_POINT);
    }

    public int number() {
        return rowNumber;
    }

    public int columnSize() {
        return columnSize;
    }

    private boolean meetLast(Point cur) {
        return (points.size() <= cur.getHorizontalPosition() + 1);
    }

    private boolean isAlreadyDraw(Point cur, Point next) {
        return cur.isEnd() || next.isStart();
    }

    private List<Point> generateRow(int rowNumber, int cols) {
        List<Point> points = new ArrayList<>();
        for(int y = 0; y < cols; y++) {
            points.add(new Point(rowNumber, y));
        }
        return points;
    }
}
