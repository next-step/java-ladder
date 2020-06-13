package camp.nextstep.edu.nextstep8.ladder.entity;

import java.util.List;

public class Row {
    private final List<Point> points;

    public Row(List<Point> points) {
        this.points = points;
    }

    public void draw(int x, int y) {
        Point cur = pick(x, y);
        Point next = pick(x, y + 1);

        if(cur.meetLast(points.size())) {
            return;
        }

        if(isAlreadyDraw(cur, next)) {
            return;
        }
        cur.markStart();
        next.markEnd();
    }

    private boolean isAlreadyDraw(Point cur, Point next) {
        return cur.isEnd() || next.isStart();
    }

    public Point pick(int x, int y) {
        return points.stream()
                .filter(p -> p.match(x, y) == true)
                .findFirst()
                .orElse(null);
    }
}
