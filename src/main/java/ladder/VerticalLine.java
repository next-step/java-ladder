package ladder;

import java.util.ArrayList;
import java.util.List;

public class VerticalLine {

    private final int lineNo;
    private List<Point> points;

    public VerticalLine(int lineNo, int height) {
        this.lineNo = lineNo;
        this.points = dotPoints(height);
    }

    public int getLineNo() {
        return this.lineNo;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(this.points);
    }

    public Point getPoint(int heightPosition) {
        if (heightPosition >= points.size() || heightPosition < 0) {
            throw new IllegalArgumentException("점위치 범위를 넘어섰습니다.");
        }
        return this.points.get(heightPosition);
    }

    private List<Point> dotPoints(int height) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            points.add(new Point(lineNo, i));
        }
        return points;
    }
}
