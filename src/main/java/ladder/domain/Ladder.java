package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ladder {

    private final List<Line> lines;

    public static Ladder of(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.of(width - 1));
        }
        return new Ladder(lines);
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getLadderEndIdx(int idx) {
        List<Line> lines = this.getLines();
        for (int i = 0; i < lines.size(); i++) {
            idx = moveNextLine(idx, i);
        }
        return idx;
    }

    private int moveNextLine(int idx, int row) {
        List<Point> points = lines.get(row).getPoints();
        boolean moved = false;

        if (canMoveRight(idx, points)) {
            idx = idx + 1;
            moved = true;
        }
        if (!moved && canMoveLeft(idx, points)) {
            idx = idx - 1;
        }
        return idx;
    }

    private boolean canMoveRight(int idx, List<Point> points) {
        if (idx >= points.size()) return false;

        Point point = points.get(idx);
        return point.isExist();
    }

    private boolean canMoveLeft(int idx, List<Point> points) {
        if (idx - 1 < 0) return false;

        Point leftPoint = points.get(idx - 1);
        if (leftPoint.isExist()) {
            return true;
        }
        return false;
    }
}
