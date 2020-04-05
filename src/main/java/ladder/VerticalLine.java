package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public int getHeight(){
        return this.points.size();
    }

    private List<Point> dotPoints(int height) {
        List<Point> points = new ArrayList<>();
        for (int i = 1; i <= height; i++) {
            points.add(new Point(lineNo, i));
        }
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerticalLine that = (VerticalLine) o;
        return lineNo == that.lineNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineNo);
    }
}
