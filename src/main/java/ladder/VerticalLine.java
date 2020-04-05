package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VerticalLine {

    private final int lineNo;
    private List<Point> points;

    public VerticalLine(int lineNo) {
        this.lineNo = lineNo;
        this.points = new ArrayList<>();
    }

    public int getLineNo() {
        return this.lineNo;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(this.points);
    }

    public Point getPoint(int heightPosition) {
        return points.stream()
                .filter(p -> p.getHeightPosition() == heightPosition)
                .findFirst()
                .orElse(null);
    }

    public boolean isExistLine(int heightPosition) {
        return points.stream()
                .filter(p -> p.getHeightPosition() == heightPosition)
                .findFirst()
                .isPresent();
    }

    public void addPoint(int heightPosition, int endPointLineNo) {
        points.add(new Point(heightPosition, endPointLineNo));
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
