package ladder.domain.model;

import java.util.Collections;
import java.util.List;

public class LadderLine {
    private List<Point> lines;

    private LadderLine(List<Point> lines) {
        this.lines = lines;
    }

    public static LadderLine of(List<Point> lines) {
        return new LadderLine(lines);
    }

    public List<Point> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getSize() {
        return lines.size();
    }

    public Point getPoint(Index index) {
        return lines.stream()
                .filter(point -> point.getIndex().equals(index))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not found point"));
    }

    public Point getStartPoint() {
        return lines.stream()
                .filter(Point::isStartPoint)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not found start point"));
    }

    public Point getEndPoint() {
        return lines.stream()
                .filter(point -> point.isSamePoint(lines.size()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not found end point"));
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "lines=" + lines +
                '}';
    }
}
