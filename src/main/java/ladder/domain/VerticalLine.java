package ladder.domain;

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

    public int getPointCount() {
        return this.points.size();
    }

    public Point getPoint(int heightPosition) {
        return points.stream()
                .filter(p -> p.isHeightPosition(heightPosition))
                .findFirst()
                .orElse(null);
    }

    public boolean isExistPoint(int heightPosition) {
        return points.stream()
                .anyMatch(p -> p.isHeightPosition(heightPosition));
    }

    public boolean isDrawing(int heightPosition) {
        return points.stream()
                .anyMatch(p -> p.isHeightPosition(heightPosition) && p.isEndPointLineNumber(lineNo + 1));
    }

    public boolean isLineNumber(int lineNumber) {
        return this.lineNo == lineNumber;
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
